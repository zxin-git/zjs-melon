package com.zxin.java.spring.melon.infrastructure.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * ApplicationContext持有者
 * 依赖Spring IOC自动注入
 * @author zxin
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    /**
     * 获取ApplicationContext实例
     * 依赖IOC自动装配
     * @return
     */
    public static ApplicationContext get() {
        Assert.state(Objects.nonNull(applicationContext), "ApplicationContext未注入");
        return applicationContext;
    }
}
