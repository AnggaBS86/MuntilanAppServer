package ab.core.abserver;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

public abstract class AbstractHttpRequest
{
  public abstract void beforeHandlePHPRequest(HttpExchange paramHttpExchange);

  public abstract void afterHandlePHPRequest(HttpExchange paramHttpExchange);

  public void handlePHPRequest(HttpExchange exchange, String path)
    throws IOException
  {
    beforeHandlePHPRequest(exchange);

    String hasil = "";

    Headers responseHeaders = exchange.getResponseHeaders();
    responseHeaders.set("Content-Type", "text/html");
    exchange.sendResponseHeaders(200, 0L);

    OutputStream responseBody = exchange.getResponseBody();

    System.err.println("Request waktu per " + new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds());

    File f1 = new File(path);

    if (f1.exists())
    {
      hasil = new ParsingCLICommand().getResults(new ParsingCLICommand().getCliCommand() + " " + "-q" + " " + path);
    }
    else
    {
      hasil = "<!DOCTYPE html><html lang=\"en\"><head><title>404 Page Not Found</title><style type=\"text/css\">::selection{ background-color: #E13300; color: white; }::moz-selection{ background-color: #E13300; color: white; }::webkit-selection{ background-color: #E13300; color: white; }body {\tbackground-color: #fff;\tmargin: 40px;\tfont: 13px/20px normal Helvetica, Arial, sans-serif;\tcolor: black;}a {\tcolor: #003399;\tbackground-color: transparent;\tfont-weight: normal;}h1 {\tcolor: #444;\tbackground-color: transparent;\tborder-bottom: 1px solid #D0D0D0;\tfont-size: 19px;\tfont-weight: normal;\tmargin: 0 0 14px 0;\tpadding: 14px 15px 10px 15px;}code {\tfont-family: Consolas, Monaco, Courier New, Courier, monospace;\tfont-size: 12px;\tbackground-color: #f9f9f9;\tborder: 1px solid #D0D0D0;\tcolor: #002166;\tdisplay: block;\tmargin: 14px 0 14px 0;\tpadding: 12px 10px 12px 10px;}#container {\tmargin: 10px;\tborder: 1px solid #D0D0D0;\t-webkit-box-shadow: 0 0 8px #D0D0D0;}p {\tmargin: 12px 15px 12px 15px;}</style></head><body>\t<div id='container'>\t\t<h1>404 Page Not Found</h1>\t\t<p>The page you requested was not found.</p>\t</div></body></html>";
    }
    try
    {
      responseBody.write(hasil.getBytes());
    }
    finally
    {
      if (responseBody != null)
      {
        responseBody.flush();
        responseBody.close();
      }
      if (exchange != null)
      {
        exchange.close();
      }
    }

    afterHandlePHPRequest(exchange);
  }
}