package com.zxin.java.spring.melon.infrastructure.config;

import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * {@link EnableTransactionManagement} 已经在主类引用
 * @author zxin
 */
@Configuration
@MapperScan("com.zhangmen.uke.referral.domain.repository")
public class MybatisPlusConfig {

    /**
     * 乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * for 物理分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * 逻辑删除
     * @return
     */
    @Bean
    public LogicSqlInjector logicSqlInjector(){
        return new LogicSqlInjector();
    }

}
