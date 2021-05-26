package com.zxin.java.spring.melon.infrastructure.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 分布式锁切面
 * @author zxin
 */
@Aspect
@Component
public class DLockAspect {

    @Autowired
    private RedissonClient redisson;

    private static final SpelExpressionParser parser = new SpelExpressionParser();

    private static final LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();


    @Pointcut("@annotation(com.zxin.java.spring.melon.infrastructure.aop.DLock)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        String name = toLockName(joinPoint);
        RLock lock = redisson.getLock(name);
//        boolean acquired = lock.tryLock(10, 10, TimeUnit.SECONDS);
//        if(acquired){
            try {
                lock.lock();
                return joinPoint.proceed();
            } catch (Throwable e) {
                throw e;
            } finally {
                lock.unlock();
            }
//        } else {
//            throw new DLockException(String.format("获取锁异常[%s]", name));
//        }

    }

    /**
     * 获取 锁key
     * @param joinPoint
     * @return
     */
    private String toLockName(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DLock dLock = methodSignature.getMethod().getAnnotation(DLock.class);
        String key = dLock.value();
        Object[] args = joinPoint.getArgs();
        Method method = methodSignature.getMethod();

        String[] params = discoverer.getParameterNames(method);
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], args[len]);
        }
        Expression expression = parser.parseExpression(key);
        return expression.getValue(context, String.class);
    }

}
