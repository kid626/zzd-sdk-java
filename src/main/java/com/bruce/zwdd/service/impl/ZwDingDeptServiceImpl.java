package com.bruce.zwdd.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.xxpt.gateway.shared.api.request.*;
import com.alibaba.xxpt.gateway.shared.api.response.*;
import com.alibaba.xxpt.gateway.shared.client.http.IntelligentPostClient;
import com.bruce.zwdd.model.constant.URLConstant;
import com.bruce.zwdd.model.dept.req.ListOrganizationsByCodesReq;
import com.bruce.zwdd.model.dept.req.PageOrganizationEmployeeCodesReq;
import com.bruce.zwdd.model.dept.req.PageSearchOrgReq;
import com.bruce.zwdd.model.dept.req.PageSubOrganizationCodesReq;
import com.bruce.zwdd.model.dept.resp.GetOrgByCodeResp;
import com.bruce.zwdd.model.dept.resp.ListOrganizationsByCodesResp;
import com.bruce.zwdd.model.dept.resp.PageSearchOrgResp;
import com.bruce.zwdd.service.ZwDingDeptService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 14:23
 * @Author fzh
 */
public class ZwDingDeptServiceImpl extends ZwDingBaseServiceImpl implements ZwDingDeptService {

    /**
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public ZwDingDeptServiceImpl(String appKey, String appSecret, String domainName, String protocol, Long tenantId) {
        super(appKey, appSecret, domainName, protocol, tenantId);
    }

    @Override
    public List<String> pageOrganizationEmployeeCodes(PageOrganizationEmployeeCodesReq req) {
        IntelligentPostClient client = initClient(URLConstant.GET_ORG_EMP);
        OapiMoziOrganizationPageOrganizationEmployeeCodesRequest request = new OapiMoziOrganizationPageOrganizationEmployeeCodesRequest();
        request.setOrganizationCode(req.getOrganizationCode());
        request.setTenantId(config.getTenantId());
        if (req.getReturnTotalSize() != null) {
            request.setReturnTotalSize(req.getReturnTotalSize());
        }
        if (StringUtils.isNotEmpty(req.getEmployeePositionStatus())) {
            request.setEmployeePositionStatus(req.getEmployeePositionStatus());
        }
        if (req.getPageNo() != null) {
            request.setPageNo(req.getPageNo());
        }
        if (req.getPageSize() != null) {
            request.setPageSize(req.getPageSize());
        }
        OapiMoziOrganizationPageOrganizationEmployeeCodesResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, String.class);
    }

    @Override
    public GetOrgByCodeResp getOrganizationByCode(String organizationCode) {
        IntelligentPostClient client = initClient(URLConstant.GET_ORG_BY_CODE);
        OapiMoziOrganizationGetOrganizationByCodeRequest request = new OapiMoziOrganizationGetOrganizationByCodeRequest();
        request.setTenantId(config.getTenantId());
        request.setOrganizationCode(organizationCode);
        OapiMoziOrganizationGetOrganizationByCodeResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseObject(data, GetOrgByCodeResp.class);
    }

    @Override
    public List<ListOrganizationsByCodesResp> listOrganizationsByCodes(ListOrganizationsByCodesReq req) {
        IntelligentPostClient client = initClient(URLConstant.BATCH_GET_ORG_BY_CODES);
        OapiMoziOrganizationListOrganizationsByCodesRequest request = new OapiMoziOrganizationListOrganizationsByCodesRequest();
        List<String> organizationCodes = req.getOrganizationCodes();
        if (CollectionUtils.isNotEmpty(organizationCodes)) {
            request.setOrganizationCodes(organizationCodes);
        }
        request.setTenantId(config.getTenantId());
        OapiMoziOrganizationListOrganizationsByCodesResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, ListOrganizationsByCodesResp.class);
    }

    @Override
    public List<String> pageSubOrganizationCodes(PageSubOrganizationCodesReq req) {
        IntelligentPostClient client = initClient(URLConstant.PAGE_SUB_ORG_CODES);
        OapiMoziOrganizationPageSubOrganizationCodesRequest request = new OapiMoziOrganizationPageSubOrganizationCodesRequest();
        request.setOrganizationCode(req.getOrganizationCode());
        request.setTenantId(config.getTenantId());
        if (req.getReturnTotalSize() != null) {
            request.setReturnTotalSize(req.getReturnTotalSize());
        }
        if (StringUtils.isNotEmpty(req.getStatus())) {
            request.setStatus(req.getStatus());
        }
        if (req.getPageNo() != null) {
            request.setPageNo(req.getPageNo());
        }
        if (req.getPageSize() != null) {
            request.setPageSize(req.getPageSize());
        }
        OapiMoziOrganizationPageSubOrganizationCodesResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, String.class);
    }

    @Override
    public List<PageSearchOrgResp> pageSearchOrganization(PageSearchOrgReq req) {
        IntelligentPostClient client = initClient(URLConstant.PAGE_SEARCH_ORG);
        OapiMoziFusionPageSearchOrganizationRequest request = new OapiMoziFusionPageSearchOrganizationRequest();
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
        OapiMoziFusionPageSearchOrganizationResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseArray(data, PageSearchOrgResp.class);
    }


}
