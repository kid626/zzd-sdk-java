package com.bruce.zwdd.model.user.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 14:31
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class ListEmpAccountIdsResp {

    // {
    //     "accountId": 132,
    //         "accountCode": "ceshirenyuan",
    //         "accountNamespace": "local",
    //         "employeeCode": "GE_78e5f5015d7a44c5b4b53c20e166aac6"
    // }

    private Integer accountId;
    private String accountCode;
    private String accountNamespace;
    private String employeeCode;
}
