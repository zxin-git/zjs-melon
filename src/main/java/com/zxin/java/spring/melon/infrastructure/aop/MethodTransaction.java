package com.zxin.java.spring.melon.infrastructure.aop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 方法 执行事务
 * @author zxin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MethodTransaction {

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 方法 入参
     */
    private Object[] args;

    /**
     * 方法 返回对象
     */
    private Object returnObj;

    /**
     * 方法 请求执行耗时
     */
    private long delay;

}
