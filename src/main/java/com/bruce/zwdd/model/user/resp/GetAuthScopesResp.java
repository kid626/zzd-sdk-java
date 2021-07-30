package com.bruce.zwdd.model.user.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/22 16:27
 * @Author fzh
 */
@Data
public class GetAuthScopesResp implements Serializable {


    /**
     * success : true
     * content : {"userVisibleScopes":["人员编码1","人员编码2"],"deptVisibleScopes":["组织编码1","组织编码2"]}
     * errorLevel :
     * errorCode : 0
     * errorMsg : success
     */


    private List<String> userVisibleScopes;
    private List<String> deptVisibleScopes;

}
