package com.zxin.java.spring.melon.infrastructure.util.crypto.sign;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zxin
 */
@Data
@AllArgsConstructor
public class GeneralSigner implements ISigner {
    
    /**
     * 签名算法
     */
    private SignAlgorithm signAlgorithm;
    
    @Override
    public String sign(String content, String privateKey) {
        Sign signer = new Sign(signAlgorithm, privateKey, null);
        byte[] signBs = signer.sign(content.getBytes());
        return Base64.encode(signBs);
    }
    
    @Override
    public boolean verify(String content, String sign, String publicKey) {
        Sign signer = new Sign(signAlgorithm, null, publicKey);
        return signer.verify(content.getBytes(), Base64.decode(sign));
    }
    
}
