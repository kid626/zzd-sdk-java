package com.bruce.zwdd.model.user.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 14:39
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class GetByMobileResp {

    private Long accountId;
    private String mobile;
    private Integer status;
    private String employeeCode;
}
