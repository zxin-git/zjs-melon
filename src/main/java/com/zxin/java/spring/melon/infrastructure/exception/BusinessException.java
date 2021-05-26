package com.zxin.java.spring.melon.infrastructure.exception;

import lombok.Data;
import org.springframework.core.NestedRuntimeException;

@Data
public class BusinessException extends NestedRuntimeException{

    private String code;

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

}