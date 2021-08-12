package com.bruce.zwdd.service;

import com.bruce.zwdd.model.dept.req.ListOrganizationsByCodesReq;
import com.bruce.zwdd.model.dept.req.PageOrganizationEmployeeCodesReq;
import com.bruce.zwdd.model.dept.req.PageSearchOrgReq;
import com.bruce.zwdd.model.dept.req.PageSubOrganizationCodesReq;
import com.bruce.zwdd.model.dept.resp.GetOrgByCodeResp;
import com.bruce.zwdd.model.dept.resp.ListOrganizationsByCodesResp;
import com.bruce.zwdd.model.dept.resp.PageSearchOrgResp;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 13:38
 * @Author fzh
 */
public interface ZwDingDeptService extends ZwDingBaseService {

    /**
     * 分页查询组织下的员⼯ Code
     *
     * @param req PageOrganizationEmployeeCodesReq
     * @return String
     */
    List<String> pageOrganizationEmployeeCodes(PageOrganizationEmployeeCodesReq req);

    /**
     * 根据组织 Code 查询详情
     *
     * @param organizationCode 组织 code
     * @return GetOrgByCodeResp
     */
    GetOrgByCodeResp getOrganizationByCode(String organizationCode);

    /**
     * 批量根据组织Code查询详情
     *
     * @param req ListOrganizationsByCodesReq
     * @return ListOrganizationsByCodesResp
     */
    List<ListOrganizationsByCodesResp> listOrganizationsByCodes(ListOrganizationsByCodesReq req);

    /**
     * 根据组织Code查询组织汇报线
     *
     * @param organizationCode 组织 code
     * @return 组织线组织Code列表一条线从当前组织开始，向上一直查找父组织，直到根节点
     */
    List<String> getOrganizationLine(String organizationCode);

    /**
     * 分页获取下⼀级组织 Code 列表
     *
     * @param req PageSubOrganizationCodesReq
     * @return String
     */
    List<String> pageSubOrganizationCodes(PageSubOrganizationCodesReq req);

    /**
     * 根据组织名称关键词进行组织信息查询
     *
     * @param req PageSearchOrgReq
     * @return PageSearchOrgResp
     */
    List<PageSearchOrgResp> pageSearchOrganization(PageSearchOrgReq req);


}
