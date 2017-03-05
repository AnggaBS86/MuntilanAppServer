package ab.core.abserver;

public class MainAppServer
{

    public static void main(String[] args)
    {
        new HandleHttpClientRequest().run();
    }
}