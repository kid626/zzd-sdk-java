package com.bruce.zwdd.service;

import com.bruce.zwdd.exception.ZwDingDingException;
import com.bruce.zwdd.model.base.GetTokenResp;
import com.bruce.zwdd.model.base.AuthUserResp;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 9:38
 * @Author fzh
 */
public interface ZwDingBaseService {

    /**
     * 获取token，需要开发人员自己管理生命周期
     *
     * @return access_token
     * @throws ZwDingDingException ZwDingDingException
     */
    GetTokenResp getRealToken() throws ZwDingDingException;

    /**
     * 获取 token ，已做生命周期管理
     *
     * @return access_token
     * @throws ZwDingDingException ZwDingDingException
     */
    String getAccessToken() throws ZwDingDingException;

    /**
     * 获取 jsapi token，需要开发人员自己管理生命周期
     *
     * @param accessToken access_token
     * @return jsapi_token
     * @throws ZwDingDingException ZwDingDingException
     */
    GetTokenResp getJsapiRealToken(String accessToken) throws ZwDingDingException;

    /**
     * 获取 jsapi token，需要开发人员自己管理生命周期
     *
     * @return jsapi_token
     * @throws ZwDingDingException ZwDingDingException
     */
    GetTokenResp getJsapiRealToken() throws ZwDingDingException;

    /**
     * 获取 jsapi token ，已做生命周期管理
     *
     * @param accessToken access_token
     * @return jsapi_token
     * @throws ZwDingDingException ZwDingDingException
     */
    String getJsapiToken(String accessToken) throws ZwDingDingException;

    /**
     * 获取 jsapi token ，已做生命周期管理
     *
     * @return jsapi_token
     * @throws ZwDingDingException ZwDingDingException
     */
    String getJsapiToken() throws ZwDingDingException;

    /**
     * 根据authCode换取用户信息
     *
     * @param code code
     * @return AuthUserResp
     */
    AuthUserResp.ContentBean.DataBean getUserByCode(String code);

    /**
     * 根据扫码登录的临时授权码换取用户信息
     *
     * @param code 扫码登录临时授权码
     * @return AuthUserResp
     */
    AuthUserResp.ContentBean.DataBean getUserByOauth2Code(String code);


}
