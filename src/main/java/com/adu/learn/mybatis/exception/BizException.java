package com.adu.learn.mybatis.exception;

import lombok.Data;

@Data
public class BizException extends RuntimeException{

    private int code;


    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
