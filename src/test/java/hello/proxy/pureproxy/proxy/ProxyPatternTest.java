package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import hello.proxy.pureproxy.proxy.code.Subject;
import hello.proxy.pureproxy.proxy.code.CacheProxy;
import org.junit.jupiter.api.Test;

//프록시 패턴: 접근 제어가 목적
public class ProxyPatternTest {

    @Test
    public void noProxyTest() throws Exception {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        Subject realSubject = new RealSubject();

        //프록시는 실제대상을 참조
        Subject cacheProxy = new CacheProxy(realSubject);

        //클라이언트는 프록시를 참조
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        client.execute();
        client.execute();
        client.execute();
    }
}
