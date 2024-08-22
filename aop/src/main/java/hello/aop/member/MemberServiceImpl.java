package hello.aop.member;

import hello.aop.member.annotation.ClassAop;
import hello.aop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberSerrvice {

    @Override
    @MethodAop("test Value")
    public String hello(String param) {
        return "ok";
    }

    public String internal(String param){
        return "ok";
    }

}
