package com.zxin.java.spring.melon.infrastructure.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.zxin.java.spring.melon.infrastructure.util.LocalDateTimeUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 时间戳 转 LocalDateTime
 */
public class Timestamp2LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String text = jsonParser.getText();
        if(StringUtils.isNotEmpty(text)){
            Long ms = Long.valueOf(text);
            return LocalDateTimeUtils.ofEpochMilli(ms);
        }else{
            return null;
        }
    }
}