package hello.trace.threadlocal;

import hello.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {
    FieldService fieldService = new FieldService();

    @Test
    public void field() {
        log.info("====main start====");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        // A가 완전히 끝난 다음 B가 실행. 동시성 문제 발생X
        threadA.start();
        sleep(100);
        threadB.start();

        sleep(3000); //메인 쓰레드 종료.대기
        log.info("====main exit====");


    }

    private void sleep(int miilis) {
        try {
            Thread.sleep(miilis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
