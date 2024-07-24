package hello.proxy.pureproxy.concreteproxy.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ConcreteClient {
    private final ConcreteLogic concreteLogic;

    public void execute(){
        concreteLogic.operation();
    }
}
