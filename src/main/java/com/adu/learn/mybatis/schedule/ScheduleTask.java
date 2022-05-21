package com.adu.learn.mybatis.schedule;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
@Component
@EnableAsync
public class ScheduleTask {

    @Autowired
    private RedissonClient redissonClient;

    @Scheduled(cron = "0 0/1 * * * ?")
    @Async
    public void task1() {
        log.info("--------------task1 begin----------------");
        tryLock("redis-lock", ()->{
            log.error("-------------task1 execute---------");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    @Async
    public void task2() {
        log.info("--------------task2 begin----------------");
        tryLock("redis-lock", ()->{
            log.error("-------------task2 execute---------");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    private void tryLock(String lockName, Supplier supplier){
        RLock lock = redissonClient.getLock(lockName);
        try {
            if(lock.tryLock()){
                supplier.get();
                lock.unlock();
            }

        } catch (Exception e){
        } finally {
        }

    }

    private void lock(String lockName, Supplier supplier) {
        RLock lock = redissonClient.getLock(lockName);
        try {
            lock.lock();
            supplier.get();
        } catch (Exception e){
        } finally {
            lock.unlock();
        }
    }
}
