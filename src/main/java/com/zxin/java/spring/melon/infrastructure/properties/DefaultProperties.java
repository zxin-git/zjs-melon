package com.zxin.java.spring.melon.infrastructure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author zxin
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties("com.zxin.java.spring.melon.properties.default")
public class DefaultProperties {

    private String appId = "13046";

    private String appName = "uke-referral";

    private Boolean endpointLog = true;

}
