package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long start = System.currentTimeMillis();

//        Object result = methodProxy.invoke(target, args); // 타겟 클래스 타겟메소드 실행
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();

        long resultTime = end - start;

        log.info("TimeProxy 종료 resultTime = {}",resultTime);
        return result;
    }
}
