package hello.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object object) {
        this.target = object;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("TimeProxy 실행");
        long start = System.currentTimeMillis();

        Object result = methodProxy.invoke(target, args); // 타겟 클래스 타겟메소드 실행

        long end = System.currentTimeMillis();

        long resultTime = end - start;

        log.info("TimeProxy 종료 resultTime = {}",resultTime);
        return result;
    }
}
