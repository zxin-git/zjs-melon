package com.zxin.java.spring.melon.infrastructure.util.crypto.sign;

import cn.hutool.crypto.asymmetric.SignAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 支持算法枚举
 */
@Getter
@AllArgsConstructor
public enum SignerEnum implements ISigner{

    MD5withRSA("MD5withRSA", new GeneralSigner(SignAlgorithm.MD5withRSA)),
    SHA256withRSA("SHA256withRSA", new GeneralSigner(SignAlgorithm.SHA256withRSA)),
    SM3withSM2("SM3withSM2", SM2Signer.getInstance()),
    ;
    
    private String code;
    
    private ISigner signer;
    
    /**
     * 根据code获取枚举对象
     *
     * @param code
     * @return
     */
    public static SignerEnum getByCode(String code) {
        return Arrays.stream(SignerEnum.values())
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public String sign(String content, String privateKey) {
        return signer.sign(content, privateKey);
    }

    @Override
    public boolean verify(String content, String sign, String publicKey) {
        return signer.verify(content, sign, publicKey);
    }
}
