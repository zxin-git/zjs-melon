package com.zxin.java.spring.melon.infrastructure.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.Resource;

/**
 * @author zxin
 */
@Configuration
public class MessageSourceConfig {

    /**
     * MessageSource
     */
    @Resource
    private MessageSource messageSource;

    /**
     * Validation message i18n
     * @return Validator
     */
    @Bean
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(this.messageSource);
        return validator;
    }

}
