package hello.proxy.proxyfactory;

import hello.proxy.common.advice.TimeAdvice;
import hello.proxy.common.service.ConcreteService;
import hello.proxy.common.service.ServiceImpl;
import hello.proxy.common.service.ServiceInterface;
import jdk.jfr.Name;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용")
    void interfaceProxy(){
        ServiceInterface service = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass = {}",service.getClass());
        log.info("proxyClass = {}",proxy.getClass());
        proxy.find();

        boolean aopProxy = AopUtils.isAopProxy(proxy);
        boolean aopProxy2 = AopUtils.isJdkDynamicProxy(proxy);
        boolean aopProxy3 = AopUtils.isCglibProxy(proxy);

        Assertions.assertThat(aopProxy).isTrue();
        Assertions.assertThat(aopProxy2).isTrue();
        Assertions.assertThat(aopProxy3).isFalse();
    }
    @Test
    @DisplayName("구체 클래스만 있으면 cglib 프록시 사용")
    void concreteProxy(){
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());
        proxy.call();

        boolean aopProxy = AopUtils.isAopProxy(proxy);
        boolean aopProxy2 = AopUtils.isCglibProxy(proxy);
        boolean aopProxy3 = AopUtils.isJdkDynamicProxy(proxy);

        Assertions.assertThat(aopProxy).isTrue();
        Assertions.assertThat(aopProxy2).isTrue();
        Assertions.assertThat(aopProxy3).isFalse();
    }

    @Test
    @DisplayName("ProxyTargetClass 있으면 인터페이스 기반 클래스여도   cglib 사용")
    void proxyTargetClass(){
        ServiceInterface service = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        proxyFactory.addAdvice(new TimeAdvice());
        proxyFactory.setProxyTargetClass(true);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass = {}",service.getClass());
        log.info("proxyClass = {}",proxy.getClass());
        proxy.find();


        Assertions.assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        Assertions.assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse();
        Assertions.assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }

}
