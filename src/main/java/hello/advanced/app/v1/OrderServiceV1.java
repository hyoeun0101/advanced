package hello.advanced.app.v1;

import hello.trace.TraceId;
import hello.trace.TraceStatus;
import hello.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin( "OrderService.orderItem");
            orderRepository.save(traceId,itemId);


            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw  e;
        }
    }


}
