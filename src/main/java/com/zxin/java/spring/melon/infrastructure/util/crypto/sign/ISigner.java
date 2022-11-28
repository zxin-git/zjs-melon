package com.zxin.java.spring.melon.infrastructure.util.crypto.sign;

/**
 * 签名器
 */
public interface ISigner {
    
    /**
     * 签名
     *
     * @param content    需签名的内容（原文字符串 utf-8编码）
     * @param privateKey 私钥自有（Bas64编码）
     * @return 签名值（Bas64编码）
     */
    String sign(String content, String privateKey);
    
    /**
     * 验签
     *
     * @param content   签名的内容 （原文字符串 utf-8编码）
     * @param sign      签名值（Bas64编码）
     * @param publicKey 公钥（Bas64编码）
     * @return 验签是否通过
     */
    boolean verify(String content, String sign, String publicKey);
    
}
