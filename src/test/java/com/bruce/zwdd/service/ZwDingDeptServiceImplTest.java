package com.bruce.zwdd.service;

import com.bruce.zwdd.model.dept.req.ListOrganizationsByCodesReq;
import com.bruce.zwdd.model.dept.req.PageOrganizationEmployeeCodesReq;
import com.bruce.zwdd.model.dept.req.PageSearchOrgReq;
import com.bruce.zwdd.model.dept.req.PageSubOrganizationCodesReq;
import com.bruce.zwdd.model.dept.resp.GetOrgByCodeResp;
import com.bruce.zwdd.model.dept.resp.ListOrganizationsByCodesResp;
import com.bruce.zwdd.model.dept.resp.PageSearchOrgResp;
import com.bruce.zwdd.service.impl.ZwDingDeptServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 15:14
 * @Author fzh
 */
public class ZwDingDeptServiceImplTest extends ZwDingBaseServiceImplTest {

    ZwDingDeptService zwDingDeptService;

    @Before
    public void init() {
        zwDingDeptService = new ZwDingDeptServiceImpl(appKey, appSecret, domainName, protocol, tenantId);
    }

    @Test
    public void pageOrganizationEmployeeCodes() {
        PageOrganizationEmployeeCodesReq req = new PageOrganizationEmployeeCodesReq();
        req.setOrganizationCode(organizationCode);
        req.setTenantId(tenantId);
        req.setPageNo(1);
        List<String> list = zwDingDeptService.pageOrganizationEmployeeCodes(req);
        for (String resp : list) {
            System.out.println(resp);
        }
    }

    @Test
    public void getOrganizationByCode() {
        GetOrgByCodeResp resp = zwDingDeptService.getOrganizationByCode(organizationCode);
        System.out.println(resp);
    }

    @Test
    public void listOrganizationsByCodes() {
        ListOrganizationsByCodesReq req = new ListOrganizationsByCodesReq();
        req.setOrganizationCodes(Arrays.asList(organizationCode));
        req.setTenantId(tenantId);
        List<ListOrganizationsByCodesResp> list = zwDingDeptService.listOrganizationsByCodes(req);
        for (ListOrganizationsByCodesResp resp : list) {
            System.out.println(resp);
        }
    }

    @Test
    public void pageSubOrganizationCodes() {
        PageSubOrganizationCodesReq req = new PageSubOrganizationCodesReq();
        req.setOrganizationCode(organizationCode);
        req.setPageNo(1);
        List<String> list = zwDingDeptService.pageSubOrganizationCodes(req);
        for (String resp : list) {
            System.out.println(resp);
        }
    }

    @Test
    public void pageSearchOrganization() {
        PageSearchOrgReq req = new PageSearchOrgReq();
        req.setCascadeOrganizationCode(organizationCode);
        req.setNameKeywords("组织");
        req.setPageNo(1);
        List<PageSearchOrgResp> list = zwDingDeptService.pageSearchOrganization(req);
        for (PageSearchOrgResp resp : list) {
            System.out.println(resp);
        }
    }


}
