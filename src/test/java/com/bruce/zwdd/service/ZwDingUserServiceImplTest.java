package com.bruce.zwdd.service;

import com.bruce.zwdd.model.user.req.PageOrganizationEmployeePositionsReq;
import com.bruce.zwdd.model.user.req.PageSearchEmployeeReq;
import com.bruce.zwdd.model.user.resp.*;
import com.bruce.zwdd.service.impl.ZwDingUserServiceImpl;
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
public class ZwDingUserServiceImplTest extends ZwDingBaseServiceImplTest {

    ZwDingUserService zwDingUserService;

    private String employeeCode = "***";

    @Before
    public void init() {
        zwDingUserService = new ZwDingUserServiceImpl(appKey, appSecret, domainName, protocol, tenantId);
    }

    @Test
    public void getEmployeeByCode() {
        GetEmployeeByCodeResp resp = zwDingUserService.getEmployeeByCode(employeeCode);
        System.out.println(resp);
    }

    @Test
    public void listEmployeesByCodes() {
        List<GetEmployeeByCodeResp> list = zwDingUserService.listEmployeesByCodes(Arrays.asList(employeeCode));
        for (GetEmployeeByCodeResp resp : list) {
            System.out.println(resp);
        }
    }

    @Test
    public void listEmployeePositionsByEmployeeCode() {
        List<ListEmployeePosByEmpCodeResp> list = zwDingUserService.listEmployeePositionsByEmployeeCode(employeeCode, "", "");
        for (ListEmployeePosByEmpCodeResp resp : list) {
            System.out.println(resp);
        }
    }

    @Test
    public void listEmployeeAccountIds() {
        List<ListEmpAccountIdsResp> list = zwDingUserService.listEmployeeAccountIds(Arrays.asList(employeeCode));
        for (ListEmpAccountIdsResp resp : list) {
            System.out.println(resp);
        }
    }

    @Test
    public void listGovEmployeeCodesByAccountIds() {
        List<ListEmpCodesByAccountIdsResp> list = zwDingUserService.listGovEmployeeCodesByAccountIds(Arrays.asList(0L));
        for (ListEmpCodesByAccountIdsResp resp : list) {
            System.out.println(resp);
        }
    }

    @Test
    public void getByMobile() {
        GetByMobileResp resp = zwDingUserService.getByMobile("");
        System.out.println(resp);
    }

    @Test
    public void getByMobiles() {
        List<GetByMobileResp> list = zwDingUserService.getByMobiles("");
        for (GetByMobileResp resp : list) {
            System.out.println(resp);
        }
    }

    @Test
    public void pageOrganizationEmployeePositions() {
        PageOrganizationEmployeePositionsReq req = new PageOrganizationEmployeePositionsReq();
        req.setOrganizationCode(organizationCode);
        List<PageOrganizationEmployeePositionsResp> resp = zwDingUserService.pageOrganizationEmployeePositions(req);
        System.out.println(resp);
    }

    @Test
    public void getAuthScopes() {
        GetAuthScopesResp resp = zwDingUserService.getAuthScopes(tenantId);
        System.out.println(resp);
    }

    @Test
    public void pageSearchEmployee() {
        PageSearchEmployeeReq request = new PageSearchEmployeeReq();
        request.setInOrganizationCode(organizationCode);
        request.setNameKeywords("人名");
        List<PageSearchEmpResp> list = zwDingUserService.pageSearchEmployee(request);
        for (PageSearchEmpResp resp : list) {
            System.out.println(resp);
        }
    }
}
