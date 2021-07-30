package com.bruce.zwdd.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.xxpt.gateway.shared.api.request.*;
import com.alibaba.xxpt.gateway.shared.api.response.*;
import com.alibaba.xxpt.gateway.shared.client.http.IntelligentPostClient;
import com.bruce.zwdd.exception.ZwDingDingException;
import com.bruce.zwdd.model.constant.URLConstant;
import com.bruce.zwdd.model.user.req.PageOrganizationEmployeePositionsReq;
import com.bruce.zwdd.model.user.req.PageSearchEmployeeReq;
import com.bruce.zwdd.model.user.resp.*;
import com.bruce.zwdd.service.ZwDingUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/14 9:24
 * @Author fzh
 */
@Slf4j
public class ZwDingUserServiceImpl extends ZwDingBaseServiceImpl implements ZwDingUserService {


    /**
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public ZwDingUserServiceImpl(String appKey, String appSecret, String domainName, String protocol, Long tenantId) {
        super(appKey, appSecret, domainName, protocol, tenantId);
    }

    @Override
    public GetEmployeeByCodeResp getEmployeeByCode(String employeeCode) {
        IntelligentPostClient client = initClient(URLConstant.GET_EMP_BY_CODE);
        OapiMoziEmployeeGetEmployeeByCodeRequest request = new OapiMoziEmployeeGetEmployeeByCodeRequest();
        request.setTenantId(config.getTenantId());
        request.setEmployeeCode(employeeCode);
        OapiMoziEmployeeGetEmployeeByCodeResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseObject(data, GetEmployeeByCodeResp.class);
    }

    @Override
    public List<GetEmployeeByCodeResp> listEmployeesByCodes(List<String> employeeCodes) {
        IntelligentPostClient client = initClient(URLConstant.LIST_EMP_BY_CODES);
        OapiMoziEmployeeListEmployeesByCodesRequest request = new OapiMoziEmployeeListEmployeesByCodesRequest();
        request.setTenantId(config.getTenantId());
        request.setEmployeeCodes(employeeCodes);
        OapiMoziEmployeeListEmployeesByCodesResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, GetEmployeeByCodeResp.class);
    }

    @Override
    public List<ListEmployeePosByEmpCodeResp> listEmployeePositionsByEmployeeCode(String employeeCode, String status, String type) {
        IntelligentPostClient client = initClient(URLConstant.LIST_EMP_POS_BY_CODE);
        OapiMoziEmployeeListEmployeePositionsByEmployeeCodeRequest request = new OapiMoziEmployeeListEmployeePositionsByEmployeeCodeRequest();
        request.setTenantId(config.getTenantId());
        request.setEmployeeCode(employeeCode);
        if (StringUtils.isNotBlank(status)) {
            request.setEmployeePositionStatus(status);
        }
        if (StringUtils.isNotBlank(type)) {
            request.setEmployeePositionType(type);
        }
        OapiMoziEmployeeListEmployeePositionsByEmployeeCodeResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, ListEmployeePosByEmpCodeResp.class);
    }

    @Override
    public List<ListEmpAccountIdsResp> listEmployeeAccountIds(List<String> employeeCodes) {
        IntelligentPostClient client = initClient(URLConstant.LIST_EMP_ACCOUNT_IDS);
        OapiMoziEmployeeListEmployeeAccountIdsRequest request = new OapiMoziEmployeeListEmployeeAccountIdsRequest();
        request.setTenantId(config.getTenantId());
        request.setEmployeeCodes(employeeCodes);
        OapiMoziEmployeeListEmployeeAccountIdsResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, ListEmpAccountIdsResp.class);
    }

    @Override
    public List<ListEmpCodesByAccountIdsResp> listGovEmployeeCodesByAccountIds(List<Long> accountIds) {
        IntelligentPostClient client = initClient(URLConstant.LIST_CODES_BY_ACCOUNT_IDS);
        OapiMoziEmployeeListGovEmployeeCodesByAccountIdsRequest request = new OapiMoziEmployeeListGovEmployeeCodesByAccountIdsRequest();
        request.setTenantId(config.getTenantId());
        request.setAccountIds(accountIds);
        OapiMoziEmployeeListGovEmployeeCodesByAccountIdsResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, ListEmpCodesByAccountIdsResp.class);
    }

    @Override
    public List<PageOrganizationEmployeePositionsResp> pageOrganizationEmployeePositions(PageOrganizationEmployeePositionsReq req) {
        IntelligentPostClient postClient = initClient(URLConstant.PAGE_ORG_EMP_POS);
        OapiMoziOrganizationPageOrganizationEmployeePositionsRequest request = new OapiMoziOrganizationPageOrganizationEmployeePositionsRequest();
        request.setOrganizationCode(req.getOrganizationCode());
        request.setTenantId(config.getTenantId());
        if (req.getReturnTotalSize() != null) {
            request.setReturnTotalSize(req.getReturnTotalSize());
        }
        if (StringUtils.isNotEmpty(req.getEmployeeStatus())) {
            request.setEmployeeStatus(req.getEmployeeStatus());
        }
        if (req.getPageNo() != null) {
            request.setPageNo(req.getPageNo());
        }
        if (req.getPageSize() != null) {
            request.setPageSize(req.getPageSize());
        }
        OapiMoziOrganizationPageOrganizationEmployeePositionsResponse apiResult = postClient.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, PageOrganizationEmployeePositionsResp.class);
    }

    @Override
    public GetByMobileResp getByMobile(String mobile) {
        IntelligentPostClient client = initClient(URLConstant.GET_BY_MOBILE);
        OapiMoziEmployeeGetByMobileRequest request = new OapiMoziEmployeeGetByMobileRequest();
        request.setTenantId(config.getTenantId());
        request.setAreaCode("86");
        request.setNamespace("local");
        request.setMobile(mobile);
        OapiMoziEmployeeGetByMobileResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseObject(data, GetByMobileResp.class);
    }

    @Override
    public List<GetByMobileResp> getByMobiles(String mobiles) {
        IntelligentPostClient client = initClient(URLConstant.GET_BY_MOBILES);
        OapiMoziEmployeeGetByMobilesRequest request = new OapiMoziEmployeeGetByMobilesRequest();
        request.setTenantId(config.getTenantId());
        request.setAreaCode("86");
        request.setNamespace("local");
        request.setMobiles(mobiles);
        OapiMoziEmployeeGetByMobilesResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, GetByMobileResp.class);
    }

    @Override
    public GetAuthScopesResp getAuthScopes(Long tenantId) {
        IntelligentPostClient client = initClient(URLConstant.AUTH_SCOPE);
        OapiAuthScopesV2Request request = new OapiAuthScopesV2Request();
        request.setTenantId(config.getTenantId());
        OapiAuthScopesV2Response apiResult = client.post(request);
        if (!apiResult.getSuccess()) {
            throw new ZwDingDingException(apiResult.getErrorMsg());
        }
        String data = apiResult.getContent();
        return JSONObject.parseObject(data, GetAuthScopesResp.class);
    }

    @Override
    public List<PageSearchEmpResp> pageSearchEmployee(PageSearchEmployeeReq req) {
        IntelligentPostClient client = initClient(URLConstant.PAGE_SEARCH_EMP);
        OapiMoziFusionPageSearchEmployeeRequest request = new OapiMoziFusionPageSearchEmployeeRequest();
        request.setTenantId(config.getTenantId());
        request.setNameKeywords(req.getNameKeywords());
        if (StringUtils.isNotBlank(req.getStatus())) {
            request.setStatus(req.getStatus());
        }
        if (StringUtils.isNotBlank(req.getCascadeOrganizationCode())) {
            request.setCascadeOrganizationCode(req.getCascadeOrganizationCode());
        }
        if (StringUtils.isNotBlank(req.getInOrganizationCode())) {
            request.setInOrganizationCode(req.getInOrganizationCode());
        }
        if (req.getReturnTotalSize() != null) {
            request.setReturnTotalSize(req.getReturnTotalSize());
        }
        if (req.getPageNo() != null) {
            request.setPageNo(req.getPageNo());
        }
        if (req.getPageSize() != null) {
            request.setPageSize(req.getPageSize());
        }
        OapiMoziFusionPageSearchEmployeeResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, PageSearchEmpResp.class);
    }

}
