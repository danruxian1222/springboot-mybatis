package com.adu.learn.mybatis.exception;

import com.adu.learn.mybatis.common.MybatisResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=BizException.class)
    @ResponseBody
    public MybatisResult exceptionHandler(BizException e){
        log.error(e.getMessage(), e);
        return MybatisResult.failed(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public MybatisResult exceptionHandler(Exception e){
        log.error(e.getMessage(), e);
        return MybatisResult.failed("请求处理异常!请联系管理员");
    }
}
