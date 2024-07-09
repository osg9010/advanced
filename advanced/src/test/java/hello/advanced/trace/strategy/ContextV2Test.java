package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    /**
     * 익명 내부 클래스
     */
    @Test
    void strategyV2(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 3 실행");
            }
        });
    }
    /**
     * 익명 내부 클래스2 / 람다
     */
    @Test
    void strategyV3(){
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(() -> log.info("비즈니스 로직 4 실행"));
    }
}
