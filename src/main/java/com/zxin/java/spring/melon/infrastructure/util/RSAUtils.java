package com.zxin.java.spring.melon.infrastructure.util;

import lombok.Data;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author zxin
 */
public class RSAUtils {

    public static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return keyPair;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成密钥对Base64编码
     * @return
     */
    public static KeyPairBase64 generateKeyPairBase64(){
        KeyPair keyPair = generateKeyPair();
        KeyPairBase64 keyPairBase64 = new KeyPairBase64();
        keyPairBase64.setPrivateKey(Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
        keyPairBase64.setPublicKey(Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        return keyPairBase64;
    }

    @Data
    public static class KeyPairBase64 {

        private String privateKey;

        private String publicKey;

    }

}
