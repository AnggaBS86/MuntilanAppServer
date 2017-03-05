package ab.core.abserver;

import ab.system.io.ParsingSetting;
import java.io.PrintStream;

public class ParsingCLICommand
{

    public String getResults(String cmd)
    {
        String result = "";
        AbstractParsingCLICommand cli = new AbstractParsingCLICommand()
        {
            public void beforeGetResultOperation()
            {
                System.out.println("Before get response");
            }

            public void afterGetResultOperation()
            {
                System.out.println("After get response");
            }
        };
        result = cli.getResultOperation(cmd);

        return result;
    }

    public String getCliCommand()
    {
        return ParsingSetting.getPHPPath();
    }

    public String getDocRoot()
    {
        return ParsingSetting.getDocumentRoot();
    }
}