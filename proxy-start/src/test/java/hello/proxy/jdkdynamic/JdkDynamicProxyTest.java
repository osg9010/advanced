package hello.proxy.jdkdynamic;

import hello.proxy.jdkdynamic.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA(){
        AInterface target = new AImpl();
        AInterface aInterface = new AInterface() {
            @Override
            public String call() {
                log.info("A-- 호출");
                return null;
            }

            @Override
            public String call2() {
                log.info("A22 호출");
                return null;
            }
        };
        TimeInvocationHandler handler= new TimeInvocationHandler(aInterface);

        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        proxy.call2();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());
    }

    @Test
    void dynamicB(){
        BInterface target = new BImpl();
        TimeInvocationHandler handler= new TimeInvocationHandler(target);

        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

        proxy.call();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());
    }
}
