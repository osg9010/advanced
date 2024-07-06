package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직 1 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("졸료시간 = {}",resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("비즈니스 로직 2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("졸료시간 = {}",resultTime);
    }
}
