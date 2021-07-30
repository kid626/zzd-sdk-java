package com.bruce.zwdd.model.dept.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 14:37
 * @Author fzh
 */
@Data
public class PageSubOrganizationCodesReq implements Serializable {

    /**
     * 是否返回查询结果总数
     */
    Boolean returnTotalSize;

    /**
     * 每⻚条数, 默认20, 最⼤只能100
     */
    Integer pageSize;

    /**
     * 组织code
     */
    String organizationCode;

    /**
     * 当前⻚码, 开始⻚码为1, ⼩于1认为为1
     */
    Integer pageNo;

    /**
     * 查询下一级子组织状态条件 A - 查询有效的数据 F - 查询无效的数据 TOTAL - 查询所有的数据
     */
    String status;

}
