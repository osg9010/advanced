package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.ContextV1;
import hello.advanced.trace.strategy.code.Strategy;
import hello.advanced.trace.strategy.code.StrategyLogic1;
import hello.advanced.trace.strategy.code.StrategyLogic2;
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

    /**
     * 전략패턴 사용
     */
    @Test
    void strategyV1(){
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2(){
        Strategy logic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직3 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(logic1);
        log.info("logic1 = {}",logic1.getClass());
        contextV1.execute();
        Strategy logic2 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직4 실행");
            }
        };

        ContextV1 contextV2 = new ContextV1(logic2);
        log.info("logic2 = {}",logic2.getClass());
        contextV2.execute();

    }

    @Test
    void strategyV3(){

        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직3 실행");
            }
        });
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직4 실행");
            }
        });
        contextV2.execute();

    }
    @Test
    void strategyV4(){

        ContextV1 contextV1 = new ContextV1(()->log.info("비즈니스 람닫1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(()->log.info("비즈니스 람닫2 실행"));
        contextV2.execute();

    }
}
