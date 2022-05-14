package com.adu.learn.mybatis.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    public static final String REDIS_PRE = "mybatis:";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public <K, V> void add(K key, V value){
        stringRedisTemplate
                .opsForValue()
                .set(REDIS_PRE + key, JSONObject.toJSONString(value));
    }

    public <K, V> void add(K key, V value, long timeout, TimeUnit unit){
        stringRedisTemplate
                .opsForValue()
                .set(REDIS_PRE + key, JSONObject.toJSONString(value), timeout, unit);
    }

    public <K,V> V get(K key) {
        String value = stringRedisTemplate.opsForValue().get(REDIS_PRE + key);
        String s = JSONObject.parseObject(value, String.class);
        return (V) s;
    }
}
