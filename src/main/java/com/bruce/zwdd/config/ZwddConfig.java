package com.bruce.zwdd.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 9:38
 * @Author fzh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZwddConfig {

    private String appKey;
    private String appSecret;
    private String domainName;
    private String protocol;
    private Long tenantId;

}
