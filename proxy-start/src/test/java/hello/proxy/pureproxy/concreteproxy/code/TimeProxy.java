package hello.proxy.pureproxy.concreteproxy.code;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {

    private ConcreteLogic logic;

    public TimeProxy(ConcreteLogic logic) {
        this.logic = logic;
    }

    @Override
    public String operation() {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();
        String result = logic.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeProxy 종료 resultTime={}ms",resultTime);
        return result;
    }
}
