package com.bruce.zwdd.model;

import lombok.Data;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 政务钉钉 token ，包含  access_token 和 jsapi token
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 10:04
 * @Author fzh
 */
@Data
public class ZwddToken {

    /**
     * appKey
     */
    private String appKey;

    /**
     * 接口调用凭证 access_token 或 jsapi_token
     */
    private String token;

    /**
     * 过期时间
     */
    private Long expiresIn;

    /**
     * token开始时间
     */
    private Long createTime;

}
