package com.bruce.zwdd.model.dept.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 14:45
 * @Author fzh
 */
@Data
public class PageSearchOrgReq implements Serializable {

    private Boolean returnTotalSize;
    private String inOrganizationCode;
    private Integer pageNo;
    private Integer pageSize;
    private String cascadeOrganizationCode;
    private String status;
    private String nameKeywords;

}
