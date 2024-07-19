package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

    private Subject tartget;
    private String cacheValue;

    public CacheProxy(Subject tartget) {
        this.tartget = tartget;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");

        if(cacheValue == null){
            cacheValue = tartget.operation();
        }

        return cacheValue;
    }
}
