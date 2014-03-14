package ab.core.abserver;

import com.sun.net.httpserver.HttpExchange;

public abstract class AbstractPHPRequest extends AbstractHttpRequest
{

    public abstract void beforeHandlePHPRequest(HttpExchange paramHttpExchange);

    public abstract void afterHandlePHPRequest(HttpExchange paramHttpExchange);
}