package com.bruce.zwdd.enums;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/10 15:32
 * @Author fzh
 */
public enum TextTypeEnum {

    /**
     * DING消息体加密方式，明文(plaintext) or 密文(ciphertext)
     */
    CIPHER("ciphertext"),
    PLAIN("plaintext");

    private String code;

    public String getCode() {
        return code;
    }

    TextTypeEnum(String code) {
        this.code = code;
    }


}
