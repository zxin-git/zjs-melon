package com.zxin.java.spring.melon.infrastructure.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author zxin
 */
public class URLEncodeUtils {

    private static final String UTF_8 = "UTF-8";

    public static String encode(String input) {
        try {
            return URLEncoder.encode(input, UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    public static String decode(String input) {
        try {
            return URLDecoder.decode(input, UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


}
