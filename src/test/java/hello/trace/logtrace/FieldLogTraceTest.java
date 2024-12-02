package hello.trace.logtrace;

import hello.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {
    LogTrace logTrace = new FieldLogTrace();
    @Test
    public void begin_end() {
        TraceStatus status1 = logTrace.begin("test1");
        TraceStatus status2 = logTrace.begin("test2");
        TraceStatus status3 = logTrace.begin("test3");

        logTrace.end(status3);
        logTrace.end(status2);
        logTrace.end(status1);

    }

    @Test
    public void begin_exception() {
        TraceStatus status1 = logTrace.begin("test1");
        TraceStatus status2 = logTrace.begin("test2");
        TraceStatus status3 = logTrace.begin("test3");

        logTrace.exception(status3,new IllegalStateException());
        logTrace.exception(status2, new IllegalStateException());
        logTrace.exception(status1, new IllegalStateException());
    }

}