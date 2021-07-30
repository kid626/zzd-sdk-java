package com.bruce.zwdd.model.dept.req;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/10 12:35
 * @Author fzh
 */
@Data
public class ListOrganizationsByCodesReq implements Serializable {


    /**
     * 组织code列表（list最大值100）
     */
    List<String> organizationCodes;

    /**
     * 租户 id
     */
    Long tenantId;


}
