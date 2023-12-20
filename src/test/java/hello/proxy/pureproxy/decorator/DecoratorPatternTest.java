package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import hello.proxy.pureproxy.proxy.code.Subject;
import org.junit.jupiter.api.Test;

//프록시 패턴: 접근 제어가 목적
public class DecoratorPatternTest {

    @Test
    void noDecorator(){
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    public void decorator1() throws Exception {
        Component realComponent = new RealComponent();

        //messageDecorator - > realComponent
        Component messageDecorator = new MessageDecorator(realComponent);

        //client -> messageDecorator
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);

        client.execute();
    }

    @Test
    public void decorator2() throws Exception {
        Component realComponent = new RealComponent();

        //client -> timeDecorator -> messageDecorator -> realComponent 의존
        Component messageDecorator = new MessageDecorator(realComponent);

        //client -> timeDecorator -> messageDecorator 의존
        Component timeDecorator = new TimeDecorator(messageDecorator);

        //client -> timeDecorator 의존
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);

        client.execute();
    }
}
