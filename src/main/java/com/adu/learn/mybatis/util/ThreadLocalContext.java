package com.adu.learn.mybatis.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalContext {

    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static String get(){
        String userName = threadLocal.get();
        return userName;
    }

    public static void set(String userName){
        threadLocal.set(userName);
    }

    public static void main(String[] args) {
        threadLocal.set("dulv");
        threadLocal.set("dulv1");

        log.error(ThreadLocalContext.get());
    }
}
