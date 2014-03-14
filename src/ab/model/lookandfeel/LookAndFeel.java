package ab.model.lookandfeel;

import java.awt.Component;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class LookAndFeel extends JFrame
{

    public void motifWindows(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifNimbus(Object obj)
    {
        try
        {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                System.out.print("Nimbus sukses");
                if("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }

    public void motifJava(Object obj)
    {
        try
        {
            setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifMotif(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifGTK(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifDefaultLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifHifiLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifAeroLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifArcylLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifJtattoLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifAlumuniumLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifBernstainLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifFastLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifGraphiteLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifLunaMayaLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifMcWinLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifMintLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifNoireLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }

    public void motifSmartLookAndFeel(Object obj)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            SwingUtilities.updateComponentTreeUI((Component) obj);
        }
        catch(Throwable tt)
        {
            System.err.println(tt);
        }
    }
}