package com.bruce.zwdd.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.xxpt.gateway.shared.api.request.OapiGetJsapiTokenJsonRequest;
import com.alibaba.xxpt.gateway.shared.api.request.OapiGettokenJsonRequest;
import com.alibaba.xxpt.gateway.shared.api.request.OapiRpcOauth2DingtalkAppUserJsonRequest;
import com.alibaba.xxpt.gateway.shared.api.request.OapiRpcOauth2GetuserinfoBycodeJsonRequest;
import com.alibaba.xxpt.gateway.shared.api.response.OapiGetJsapiTokenJsonResponse;
import com.alibaba.xxpt.gateway.shared.api.response.OapiGettokenJsonResponse;
import com.alibaba.xxpt.gateway.shared.api.response.OapiRpcOauth2DingtalkAppUserJsonResponse;
import com.alibaba.xxpt.gateway.shared.api.response.OapiRpcOauth2GetuserinfoBycodeJsonResponse;
import com.alibaba.xxpt.gateway.shared.client.http.ExecutableClient;
import com.alibaba.xxpt.gateway.shared.client.http.IntelligentPostClient;
import com.alibaba.xxpt.gateway.shared.client.http.api.OapiSameResponse;
import com.alibaba.xxpt.gateway.shared.client.http.api.OapiSpResultResponse;
import com.bruce.zwdd.config.ZwddConfig;
import com.bruce.zwdd.enums.TokenTypeEnum;
import com.bruce.zwdd.exception.ZwDingDingException;
import com.bruce.zwdd.model.ZwddToken;
import com.bruce.zwdd.model.base.AuthUserResp;
import com.bruce.zwdd.model.base.GetTokenResp;
import com.bruce.zwdd.model.constant.URLConstant;
import com.bruce.zwdd.service.ZwDingBaseService;
import com.bruce.zwdd.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 13:36
 * @Author fzh
 */
@Slf4j
public class ZwDingBaseServiceImpl implements ZwDingBaseService {

    public ZwddConfig config;

    /**
     * 失效时间提前 5 分钟
     */
    private final static Long TIME_PERIOD = 60 * 5L;
    private final ExecutableClient executableClient = ExecutableClient.getInstance();

    /**
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public ZwDingBaseServiceImpl(String appKey, String appSecret, String domainName, String protocol, Long tenantId) {
        config = new ZwddConfig(appKey, appSecret, domainName, protocol, tenantId);
        executableClient.setAccessKey(appKey);
        executableClient.setSecretKey(appSecret);
        executableClient.setDomainName(domainName);
        executableClient.setProtocal(protocol);
        executableClient.init();
    }

    @Override
    public GetTokenResp getRealToken() throws ZwDingDingException {
        IntelligentPostClient client = initClient(URLConstant.GET_TOKEN);
        OapiGettokenJsonRequest request = new OapiGettokenJsonRequest();
        request.setAppkey(config.getAppKey());
        request.setAppsecret(config.getAppSecret());
        OapiGettokenJsonResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseObject(data, GetTokenResp.class);
    }

    @Override
    public String getAccessToken() throws ZwDingDingException {
        long curTime = System.currentTimeMillis() / 1000;
        ZwddToken zwddToken = FileUtils.getValue(TokenTypeEnum.ACCESS_TOKEN, config.getAppKey());
        if (zwddToken == null || (curTime - zwddToken.getCreateTime()) >= (zwddToken.getExpiresIn() - TIME_PERIOD)) {
            GetTokenResp realToken = getRealToken();
            zwddToken = new ZwddToken();
            zwddToken.setAppKey(config.getAppKey());
            zwddToken.setToken(realToken.getAccessToken());
            zwddToken.setExpiresIn(realToken.getExpiresIn());
            zwddToken.setCreateTime(curTime);
            FileUtils.write2File(zwddToken, TokenTypeEnum.ACCESS_TOKEN);
        }
        return zwddToken.getToken();
    }

    @Override
    public GetTokenResp getJsapiRealToken() throws ZwDingDingException {
        IntelligentPostClient client = initClient(URLConstant.GET_JSAPI_TOKEN);
        OapiGetJsapiTokenJsonRequest request = new OapiGetJsapiTokenJsonRequest();
        request.setAccessToken(getAccessToken());
        OapiGetJsapiTokenJsonResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseObject(data, GetTokenResp.class);
    }

    @Override
    public String getJsapiToken() throws ZwDingDingException {
        long curTime = System.currentTimeMillis() / 1000;
        ZwddToken zwddToken = FileUtils.getValue(TokenTypeEnum.JSAPI_TOKEN, config.getAppKey());
        if (zwddToken == null || (curTime - zwddToken.getCreateTime()) >= (zwddToken.getExpiresIn() - TIME_PERIOD)) {
            GetTokenResp realToken = getJsapiRealToken();
            zwddToken = new ZwddToken();
            zwddToken.setAppKey(config.getAppKey());
            zwddToken.setToken(realToken.getAccessToken());
            zwddToken.setExpiresIn(realToken.getExpiresIn());
            zwddToken.setCreateTime(curTime);
            FileUtils.write2File(zwddToken, TokenTypeEnum.JSAPI_TOKEN);
        }
        return zwddToken.getToken();
    }

    @Override
    public AuthUserResp.ContentBean.DataBean getUserByCode(String code) {
        IntelligentPostClient client = initClient(URLConstant.GET_USER_INFO);
        OapiRpcOauth2DingtalkAppUserJsonRequest request = new OapiRpcOauth2DingtalkAppUserJsonRequest();
        request.setAccess_token(getAccessToken());
        request.setAuth_code(code);
        OapiRpcOauth2DingtalkAppUserJsonResponse apiResult = client.post(request);
        String data = getData(apiResult);
        AuthUserResp resp = JSONObject.parseObject(data, AuthUserResp.class);
        if (!resp.isSuccess()) {
            throw new ZwDingDingException(resp.getContent().getResponseMessage());
        }
        if (!resp.getContent().isSuccess()) {
            throw new ZwDingDingException(resp.getContent().getResponseMessage());
        }
        return resp.getContent().getData();
    }

    @Override
    public AuthUserResp.ContentBean.DataBean getUserByOauth2Code(String code) {
        IntelligentPostClient client = initClient(URLConstant.GET_USER_INFO_BY_CODE);
        OapiRpcOauth2GetuserinfoBycodeJsonRequest request = new OapiRpcOauth2GetuserinfoBycodeJsonRequest();
        request.setAccess_token(getAccessToken());
        request.setCode(code);
        OapiRpcOauth2GetuserinfoBycodeJsonResponse apiResult = client.post(request);
        String data = getData(apiResult);
        AuthUserResp resp = JSONObject.parseObject(data, AuthUserResp.class);
        if (!resp.isSuccess()) {
            throw new ZwDingDingException(resp.getContent().getResponseMessage());
        }
        if (!resp.getContent().isSuccess()) {
            throw new ZwDingDingException(resp.getContent().getResponseMessage());
        }
        return resp.getContent().getData();
    }

    public IntelligentPostClient initClient(String api) {
        return executableClient.newIntelligentPostClient(api);
    }

    public String getData(OapiSpResultResponse response) {
        if (log.isDebugEnabled()) {
            log.debug("api 返回:{}", JSONObject.toJSONString(response));
        }
        if (!Boolean.TRUE.equals(response.getSuccess())) {
            throw new ZwDingDingException(response.getMessage());
        }
        if (!Boolean.TRUE.equals(response.getContent().getSuccess())) {
            throw new ZwDingDingException(response.getContent().getResponseMessage());
        }
        return response.getContent().getData();
    }

    public String getData(OapiSameResponse response) {
        if (log.isDebugEnabled()) {
            log.debug("api 返回:{}", JSONObject.toJSONString(response));
        }
        if (!Boolean.TRUE.equals(response.getSuccess())) {
            throw new ZwDingDingException(response.getMessage());
        }
        return response.getContent();
    }

}
