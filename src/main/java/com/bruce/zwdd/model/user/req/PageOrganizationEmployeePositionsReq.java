package com.bruce.zwdd.model.user.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/14 14:51
 * @Author fzh
 */
@Data
public class PageOrganizationEmployeePositionsReq implements Serializable {

    /**
     * 是否返回查询结果总数
     */
    Boolean returnTotalSize;

    /**
     * 每⻚条数, 默认20, 最⼤只能100
     */
    Integer pageSize;

    /**
     * 员工状态，A为有效，F为无效，默认是所有
     */
    String employeeStatus;

    /**
     * 组织code
     */
    String organizationCode;

    /**
     * 当前⻚码, 开始⻚码为1, ⼩于1认为为1
     */
    Integer pageNo;


}
