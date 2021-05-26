package com.zxin.java.spring.melon.infrastructure.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 中台Result
 * @author zxin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private String code;
    private String message;
    private T data;

}
