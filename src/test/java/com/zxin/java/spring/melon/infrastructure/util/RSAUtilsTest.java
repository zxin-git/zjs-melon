package com.zxin.java.spring.melon.infrastructure.util;

import org.junit.Test;

public class RSAUtilsTest {

    @Test
    public void rsa() {
        RSAUtils.KeyPairBase64 keyPairBase64 = RSAUtils.generateKeyPairBase64();
        System.out.println(keyPairBase64);
    }
}