package com.adu.learn.mybatis.controller;

import com.adu.learn.mybatis.common.MybatisResult;
import com.adu.learn.mybatis.service.RedisService;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedissonClient redissonClient;

    @ApiOperation("新增(K V)")
    @GetMapping("add")
    public MybatisResult add(@RequestParam("key") String key,
                             @RequestParam("value") String value){
        redisService.add(key, value);
        return MybatisResult.ok();
    }

    @ApiOperation("新增(K V TTL)")
    @GetMapping("addByTTL")
    public MybatisResult addByTTL(@RequestParam("key") String key,
                             @RequestParam("value") String value){
        redisService.add(key, value,30, TimeUnit.SECONDS);
        return MybatisResult.ok();
    }

    @ApiOperation("查询")
    @GetMapping("get")
    public MybatisResult get(@RequestParam("key") String key){
        String value = redisService.get(key);
        return MybatisResult.ok(value);
    }

    @ApiOperation("test redisson lock")
    @GetMapping("redisson-lock")
    public MybatisResult lock(@RequestParam("lockName") String lockName){

        RLock lock = redissonClient.getLock(lockName);

        try {
            boolean b = lock.tryLock(30, TimeUnit.SECONDS);
            if(b){
                System.out.println("获取到lock");
            }

        } catch (Exception e){

        } finally {
            lock.unlock();
        }

        return MybatisResult.ok();
    }
}
