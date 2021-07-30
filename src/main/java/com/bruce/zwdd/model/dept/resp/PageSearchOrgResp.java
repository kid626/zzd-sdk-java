package com.bruce.zwdd.model.dept.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 15:12
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class PageSearchOrgResp {

    private String organizationName;
    private String parentCode;
    private String organizationCode;
    private String status;
}
