package com.zxin.java.spring.melon.infrastructure.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.Assert;

/**
 * @author zxin
 */
public class JsonUtils {

    public static <T> String toJson(T t) {
        Assert.notNull(t, "object is null");
        return JSON.toJSONString(t);
    }

    public static <T> T fromJson(String json, Class<T> tClass){
        Assert.hasText(json, "Json is null or empty");
        return JSON.parseObject(json, tClass);
    }

}
