package com.adu.learn.mybatis.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MybatisResult<T> {
    private int code;
    private String msg;
    private T data;

    public MybatisResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> MybatisResult<T> failed(String msg){
        return new MybatisResult<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
    }

    public static <T> MybatisResult<T> failed(int code, String msg){
        return new MybatisResult<>(code, msg, null);
    }

    public static <T> MybatisResult<T> ok(T data){
        return new MybatisResult<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> MybatisResult<T> ok(){
        return new MybatisResult<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }
}
