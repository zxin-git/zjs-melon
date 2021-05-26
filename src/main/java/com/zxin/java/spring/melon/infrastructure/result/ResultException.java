package com.zxin.java.spring.melon.infrastructure.result;

import lombok.Data;

/**
 * 调用接口响应异常
 */
@Data
public class ResultException extends RuntimeException {

    private Result result;

    public ResultException(Result result){
        this.result = result;
    }

}