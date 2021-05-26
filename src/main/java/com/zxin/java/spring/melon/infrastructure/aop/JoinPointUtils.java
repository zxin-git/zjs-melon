package com.zxin.java.spring.melon.infrastructure.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * @author zxin
 */
public class JoinPointUtils {

    public static MethodTransaction toMethodTransaction(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        return MethodTransaction.builder()
                .className(signature.getDeclaringTypeName())
                .methodName(signature.getName())
                .args(joinPoint.getArgs())
                .build();
    }


}
