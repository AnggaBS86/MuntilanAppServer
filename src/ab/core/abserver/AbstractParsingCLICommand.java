package ab.core.abserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractParsingCLICommand
{

    public abstract void beforeGetResultOperation();

    public abstract void afterGetResultOperation();

    public String getResultOperation(String cmd)
    {
        beforeGetResultOperation();

        String result = "";
        Process p = null;
        try
        {
            if(System.getProperty("os.name").contains("Windows"))
            {
                p = Runtime.getRuntime().exec(cmd);
            }
            else
            {
                return "<!DOCTYPE html><html lang=\"en\"><head><title>500 Internal Server Error </title><style type=\"text/css\">::selection{ background-color: #E13300; color: white; }::moz-selection{ background-color: #E13300; color: white; }::webkit-selection{ background-color: #E13300; color: white; }body {\tbackground-color: #fff;\tmargin: 40px;\tfont: 13px/20px normal Helvetica, Arial, sans-serif;\tcolor: black;}a {\tcolor: #003399;\tbackground-color: transparent;\tfont-weight: normal;}h1 {\tcolor: #444;\tbackground-color: transparent;\tborder-bottom: 1px solid #D0D0D0;\tfont-size: 19px;\tfont-weight: normal;\tmargin: 0 0 14px 0;\tpadding: 14px 15px 10px 15px;}code {\tfont-family: Consolas, Monaco, Courier New, Courier, monospace;\tfont-size: 12px;\tbackground-color: #f9f9f9;\tborder: 1px solid #D0D0D0;\tcolor: #002166;\tdisplay: block;\tmargin: 14px 0 14px 0;\tpadding: 12px 10px 12px 10px;}#container {\tmargin: 10px;\tborder: 1px solid #D0D0D0;\t-webkit-box-shadow: 0 0 8px #D0D0D0;}p {\tmargin: 12px 15px 12px 15px;}</style></head><body>\t<div id='container'>\t\t<h1>500 Internal Server Error</h1>\t\t<p>Maaf, sistem operasi anda belum mendukung untuk Muntilan Webserver</p><p>Untuk sementara hanya tersedia untuk sistem operasi Microsoft Windows</p></div></body></html>";
            }

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while((line = input.readLine()) != null)
            {
                result = result + line;
            }
            input.close();
        }
        catch(IOException ex)
        {
            Logger.getLogger(ParsingCLICommand.class.getName()).log(Level.SEVERE, null, ex);
            result = getStackTrace(ex);
        }
        catch(Exception ex)
        {
            Logger.getLogger(ParsingCLICommand.class.getName()).log(Level.SEVERE, null, ex);
            result = getStackTrace(ex);
        }
        catch(Throwable ex)
        {
            Logger.getLogger(ParsingCLICommand.class.getName()).log(Level.SEVERE, null, ex);
            result = getStackTrace(ex);
        }

        afterGetResultOperation();
        return result;
    }

    private String getStackTrace(Exception ex)
    {
        String osName = System.getProperty("os.name").toString();

        String stackTrace = "<!DOCTYPE html><html lang=\"en\"><head><title>500 Internal Server Error </title><style type=\"text/css\">::selection{ background-color: #E13300; color: white; }::moz-selection{ background-color: #E13300; color: white; }::webkit-selection{ background-color: #E13300; color: white; }body {\tbackground-color: #fff;\tmargin: 40px;\tfont: 13px/20px normal Helvetica, Arial, sans-serif;\tcolor: black;}a {\tcolor: #003399;\tbackground-color: transparent;\tfont-weight: normal;}h1 {\tcolor: #444;\tbackground-color: transparent;\tborder-bottom: 1px solid #D0D0D0;\tfont-size: 19px;\tfont-weight: normal;\tmargin: 0 0 14px 0;\tpadding: 14px 15px 10px 15px;}code {\tfont-family: Consolas, Monaco, Courier New, Courier, monospace;\tfont-size: 12px;\tbackground-color: #f9f9f9;\tborder: 1px solid #D0D0D0;\tcolor: #002166;\tdisplay: block;\tmargin: 14px 0 14px 0;\tpadding: 12px 10px 12px 10px;}#container {\tmargin: 10px;\tborder: 1px solid #D0D0D0;\t-webkit-box-shadow: 0 0 8px #D0D0D0;}p {\tmargin: 12px 15px 12px 15px;}</style></head><body><div id='container'><h1>500 Internal Server Error</h1><p><u><b>Exception : </u><br/>" + ex.toString() + "</b></p>" + "<p></p>&nbsp;&nbsp;&nbsp;<font color='red'><u><b>Stack Trace : </u></b><br/>";

        for(int i = 1; i < ex.getStackTrace().length; i++)
        {
            stackTrace = stackTrace + "&nbsp;&nbsp;&nbsp;" + ex.getStackTrace()[i] + "<br/>";
        }
        stackTrace = stackTrace + "</font></div><div id='container'>&nbsp;&nbsp;&nbsp;<i>Muntilan Webserver 0.1</i> <br/>&nbsp;&nbsp;&nbsp;Sistem Operasi : " + osName + "<br/>&nbsp;&nbsp;&nbsp;" + getDateTime() + "</div></body></html>";

        return stackTrace;
    }

    private String getDateTime()
    {
        String dateTime = null;
        Date d = new Date();
        dateTime = d.getDate() + "/" + (d.getMonth() + 1) + "/" + (d.getYear() + 1900) + " -- " + "" + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

        return dateTime;
    }

    private String getStackTrace(Throwable ex)
    {
        String stackTrace = "";
        for(int i = 1; i < ex.getStackTrace().length; i++)
        {
            stackTrace = stackTrace + ex.getStackTrace()[i] + "<br/>";
        }
        return stackTrace;
    }
}