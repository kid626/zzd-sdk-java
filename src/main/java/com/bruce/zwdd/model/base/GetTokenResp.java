package com.bruce.zwdd.model.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 9:57
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class GetTokenResp implements Serializable {

    // {
    //     "accessToken":"c139fe44362f41b6b84862ec82ab84d9",
    //     "expiresIn":"7200"
    // }

    private String accessToken;
    private Long expiresIn;
}
