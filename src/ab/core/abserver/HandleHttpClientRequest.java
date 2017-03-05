package ab.core.abserver;

import ab.configuration.constan.ConstantResponse;
import ab.system.io.ParsingSetting;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleHttpClientRequest
        implements HttpHandler, Runnable
{

    final String documentRoot = new ParsingCLICommand().getDocRoot();
    private ExecutorService executor;

    public void run()
    {
        this.executor = Executors.newCachedThreadPool();
        try
        {
            int port = 8080;
            port = Integer.parseInt(ParsingSetting.getPort());
            InetSocketAddress addr = new InetSocketAddress(port);
            HttpServer server = HttpServer.create(addr, 0);
            server.createContext("/", this);
            server.setExecutor(this.executor);
            server.start();
            System.out.println("Muntilan Application Server is running on port " + ParsingSetting.getPort());
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void handle(HttpExchange exchange)
    {
        synchronized(this)
        {
            String uri = exchange.getRequestURI().toASCIIString();
            try
            {
                uri = URLDecoder.decode(uri, "UTF-8");
            }
            catch(UnsupportedEncodingException e)
            {
                try
                {
                    uri = URLDecoder.decode(uri, "ISO-8859-1");
                }
                catch(UnsupportedEncodingException e1)
                {
                    Headers responseHeaders = exchange.getResponseHeaders();
                    responseHeaders = exchange.getResponseHeaders();
                    responseHeaders.set("Content-Type", "text/html");
                    OutputStream responseBody = exchange.getResponseBody();
                    try
                    {
                        responseBody.write(e1.toString().getBytes());
                    }
                    catch(IOException ex)
                    {
                        Logger.getLogger(HandleHttpClientRequest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    finally
                    {
                        if(responseBody != null)
                        {
                            try
                            {
                                responseBody.close();
                            }
                            catch(IOException ex)
                            {
                                Logger.getLogger(HandleHttpClientRequest.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if(responseHeaders != null)
                        {
                            responseHeaders.clear();
                        }
                        if(exchange != null)
                        {
                            exchange.close();
                        }
                    }
                }
            }

            String filePath = this.documentRoot + "" + uri;
            int lastIndex = 0;
            String path = "";

            if(filePath.contains("?"))
            {
                lastIndex = filePath.lastIndexOf("?");
                path = filePath.substring(0, lastIndex).trim();
            }
            else
            {
                path = filePath;
            }
            try
            {
                AbstractPHPRequest request = new AbstractPHPRequest()
                {
                    public void beforeHandlePHPRequest(HttpExchange exchange)
                    {
                        System.out.println("Before handle PHP request");
                    }

                    public void afterHandlePHPRequest(HttpExchange exchange)
                    {
                        System.out.println("After handle PHP request");
                    }
                };
                request.handlePHPRequest(exchange, path);
            }
            catch(Exception ex)
            {
                try
                {
                    Headers responseHeaders = exchange.getResponseHeaders();
                    responseHeaders = exchange.getResponseHeaders();
                    responseHeaders.set("Content-Type", "text/html");
                    OutputStream responseBody = exchange.getResponseBody();

                    String stackTrace = "";
                    for(int i = 1; i < ex.getStackTrace().length; i++)
                    {
                        stackTrace = stackTrace + ex.getStackTrace()[i] + "<br/>";
                    }

                    responseBody.write(ConstantResponse.internalServerError("Stack Trace", stackTrace).getBytes());
                }
                catch(IOException ex1)
                {
                    ex1.printStackTrace();
                }
            }
        }
    }
}