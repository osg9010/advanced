package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 orderControllerV2;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy( OrderControllerV2 orderControllerV2, LogTrace logTrace) {
        super(null);
        this.orderControllerV2 = orderControllerV2;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status =null;
        try{
            status = logTrace.begin("OrderController.request");
            // 타겟호출
            String result = orderControllerV2.request(itemId);
            logTrace.end(status);
            return result;
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return orderControllerV2.noLog();
    }
}
