package com.zxin.java.spring.melon.infrastructure.aop;

import com.zxin.java.spring.melon.infrastructure.properties.DefaultProperties;
import com.zxin.java.spring.melon.infrastructure.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 接口日志拦截器
 * @author zxin
 */
@Slf4j
@Aspect
@Component
public class EndpointLogAspect {

    @Autowired
    private DefaultProperties properties;

    /**
     * 定义拦截规则：
     * 拦截endpoint包下面的所有类中，且有@RequestMapping注解(使用@within则包含继承@RequestMapping的注解)的方法。
     */
    @Pointcut("execution(* com.zxin.java.spring.melon.endpoint..*(..)) && @within(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        if(BooleanUtils.isNotTrue(properties.getEndpointLog())){
            return joinPoint.proceed();
        }else{
            long start = System.currentTimeMillis();
            MethodTransaction methodTransaction = JoinPointUtils.toMethodTransaction(joinPoint);
            try {
                Object returnObj = joinPoint.proceed();
                methodTransaction.setReturnObj(returnObj);
                methodTransaction.setDelay(System.currentTimeMillis() - start);
                return returnObj;
            } catch (Throwable e) {
                log.warn(JsonUtils.toJson(methodTransaction), e);
                throw e;
            } finally {
                log.info(JsonUtils.toJson(methodTransaction));
            }
        }
    }

}