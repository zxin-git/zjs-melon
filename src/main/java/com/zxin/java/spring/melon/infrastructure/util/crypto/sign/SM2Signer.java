package com.zxin.java.spring.melon.infrastructure.util.crypto.sign;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.asymmetric.SM2;

/**
 * @author zxin
 */
public class SM2Signer implements ISigner {
    
    private static final SM2Signer SIGNER = new SM2Signer();
    
    public static SM2Signer getInstance() {
        return SIGNER;
    }
    
    @Override
    public String sign(String content, String privateKey) {
        SM2 sm2 = new SM2(privateKey, null);
        byte[] signBs = sm2.sign(content.getBytes());
        return Base64.encode(signBs);
    }
    
    @Override
    public boolean verify(String content, String sign, String publicKey) {
        SM2 sm2 = new SM2(null, publicKey);
        return sm2.verify(content.getBytes(), Base64.decode(sign));
    }
    
}
