package com.zxin.java.spring.melon.infrastructure.exception;


import com.zxin.java.spring.melon.infrastructure.result.Result;
import com.zxin.java.spring.melon.infrastructure.result.ResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zxin
 */
@Slf4j
@RestControllerAdvice
public class BusExceptionHandler {

    /**
     * 异常返回，靠返回码，data为空
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result businessException(BusinessException e) {
        return Result.builder().code(e.getCode()).message(e.getMessage()).build();
    }


    /**
     * 透传上游接口异常
     * @param e
     * @return
     */
    @ExceptionHandler(ResultException.class)
    public Result ResultException(ResultException e) {
        log.warn("接口调用出现异常", e);
        return e.getResult();
    }

}
