package com.bruce.zwdd.model.user.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 14:47
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class PageSearchEmpResp {

    // {
    //     "accountId": 143442414,
    //     "employeeName": "小智",
    //     "govEmpAvatar": "$iwHRA-gKAAvRc_MCo3BuZwMGBNEC7gXRAu4GsHu9K1w3kwzl7J2jzUblGQ8HAAgACaEw",
    //     "account": "ajddw-xz1",
    //     "employeeCode": "GE_28afe52f7a614c26aa9d3b4a14f551d6",
    //     "status": "A"
    // }


    private Long accountId;
    private String employeeName;
    private String govEmpAvatar;
    private String account;
    private String employeeCode;
    private String status;
}
