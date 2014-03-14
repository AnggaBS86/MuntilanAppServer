package ab.system.io;

import ab.configuration.constan.ConstantApplication;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ParsingSetting
{

    public static void updateSettingPHP(String path, String documentRoot, String port)
    {
        Properties p = new Properties();
        p.setProperty("php_path", "" + path);
        p.setProperty("document_root", "" + documentRoot);
        p.setProperty("port", "" + port);
        saveProperties(p, ConstantApplication.defaultPHPPathSetting);
    }

    public static synchronized String getPHPPath()
    {
        String path = "";
        Properties p2 = new Properties();
        p2 = loadProperties(ConstantApplication.defaultPHPPathSetting);
        path = p2.getProperty("php_path");
        return path;
    }

    public static synchronized String getDocumentRoot()
    {
        String file = "";
        Properties p2 = new Properties();
        p2 = loadProperties(ConstantApplication.defaultPHPPathSetting);
        file = p2.getProperty("document_root");
        return file;
    }

    public static synchronized String getPort()
    {
        String port = "";
        Properties p2 = new Properties();
        p2 = loadProperties(ConstantApplication.defaultPHPPathSetting);
        port = p2.getProperty("port");
        return port;
    }

    private static Properties loadProperties(String sFile)
    {
        Properties p = new Properties();
        try
        {
            FileInputStream in = new FileInputStream(sFile);
            p.load(in);
            in.close();
        }
        catch(IOException iOException)
        {
            JOptionPane.showMessageDialog(null, "IOException pada class PropertiesFiles \nDetail : " + iOException, "::AB Framework::", 0);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Exception pada class PropertiesFiles \nDetail : " + e, "::AB Framework::", 0);
        }

        return p;
    }

    private static synchronized void saveProperties(Properties p, String sFile)
    {
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream(sFile);
            try
            {
                p.store(out, "Konfigurasi AB Webserver");
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally
        {
            try
            {
                out.close();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}