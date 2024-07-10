package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     *  템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackTest(){
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(new Callback() {
            @Override
            public void call() {
                log.info("콜백템플릿 테스트 - 익명내부1");
            }
        });
        TimeLogTemplate timeLogTemplate2 = new TimeLogTemplate();
        timeLogTemplate2.execute(new Callback() {
            @Override
            public void call() {
                log.info("콜백템플릿 테스트 - 익명내부2");
            }
        });
    }
    /**
     *  템플릿 콜백 패턴 - 람다
     */
    @Test
    void callbackTest2(){
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> log.info("콜백템플릿 테스트 - 람다1"));
        TimeLogTemplate timeLogTemplate2 = new TimeLogTemplate();
        timeLogTemplate2.execute(() -> log.info("콜백템플릿 테스트 - 람다2"));
    }
}
