package com.zxin.java.spring.melon.infrastructure.util.spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author zxin
 */
public class ServletUtils {

    public static ServletRequestAttributes getServletRequestAttributes(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.state(requestAttributes != null, "RequestAttributes is null");
        return requestAttributes;
    }

    public static HttpServletRequest getRequest(){
        return getServletRequestAttributes().getRequest();
    }

    public static HttpServletResponse getResponse(){
        return getServletRequestAttributes().getResponse();
    }


    /**
     * 获取客户端真实IP
     * 过滤代理{@link ProxyEnum}
     *
     * Header值","分割IP
     * @param request
     * @return
     */
    public static String getRequestIp(HttpServletRequest request){
        return Arrays.stream(ProxyEnum.values())
                .flatMap(proxy -> proxy.getHeaders().stream())
                .map(request::getHeader)
                .filter(header -> !StringUtils.isEmpty(header))
                .map(header -> header.split(",")[0])
                .findFirst().orElse(null);
    }

    @Getter
    @AllArgsConstructor
    private enum ProxyEnum {
        /**
         * RFC 7239（Forwarded HTTP Extension）
         * X-Forwarded-For: client, proxy1, proxy2
         */
        SQUID("Squid", Arrays.asList("X-Forwarded-For")),
        APACHE("Apache", Arrays.asList("Proxy-Client-IP")),
        WEBLOGIC("WebLogic", Arrays.asList("WL-Proxy-Client-IP")),
        NGINX("Nginx", Arrays.asList("X-Real-IP")),

        ;
        private String proxy;

        private List<String> headers;
    }

}
