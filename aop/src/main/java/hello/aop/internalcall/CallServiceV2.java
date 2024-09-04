package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

//    private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> callServiceV2Provider;


    public CallServiceV2(ApplicationContext applicationContext, ObjectProvider<CallServiceV2> callServiceV2Provider) {
        this.callServiceV2Provider = callServiceV2Provider;
//        this.applicationContext = applicationContext;
    }

    public void external(){
        log.info("call external");
//        internal(); // 내부 메소드 호출 -> AOP 적용 안됌
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceV2Provider.getObject();
        callServiceV2.internal(); // 외부 메소드 호출 2 지연조회
    }

    public void internal() {
        log.info("call internal");
    }
}
