package hello.aop.exam;


import hello.aop.exam.aop.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
@Import(TraceAspect.class)
public class ExamTest {

    @Autowired
    ExamService service;

    @Test
    void Test(){
        for (int i = 0 ; i < 5 ; i++){
            log.info("clientRequest = {}",i);
            service.request("data"+i);
        }
    }
}
