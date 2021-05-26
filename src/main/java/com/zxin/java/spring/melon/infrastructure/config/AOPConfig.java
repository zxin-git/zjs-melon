package com.zxin.java.spring.melon.infrastructure.config;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zxin
 */
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class AOPConfig {

}
