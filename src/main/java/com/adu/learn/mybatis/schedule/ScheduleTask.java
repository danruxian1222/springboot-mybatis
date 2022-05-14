package com.adu.learn.mybatis.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableAsync
public class ScheduleTask {

    @Scheduled(cron = "0/2 * * * * ?")
    @Async
    public void task1() {
        log.info("-------------task1---------");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    @Async
    public void task2() {

        log.info("-------------task2---------");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
