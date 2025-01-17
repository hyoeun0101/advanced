package hello.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService extends AbstractService {
    @Override
    public void call() {
        log.info("call 호출");
    }
}
