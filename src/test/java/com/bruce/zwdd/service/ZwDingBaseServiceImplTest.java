package com.bruce.zwdd.service;

import com.bruce.zwdd.model.base.AuthUserResp;
import com.bruce.zwdd.service.impl.ZwDingBaseServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 15:14
 * @Author fzh
 */
public class ZwDingBaseServiceImplTest {

    String appKey = "***";
    String appSecret = "***";
    String protocol = "https";
    Long tenantId = 0L;
    String domainName = "openplatform.dg-work.cn";
    String organizationCode = "";

    ZwDingBaseService zwDingBaseService;

    @Before
    public void before() {
        zwDingBaseService = new ZwDingBaseServiceImpl(appKey, appSecret, domainName, protocol, tenantId);
    }


    @Test
    public void getAccessToken() {
        System.out.println(zwDingBaseService.getAccessToken());
    }

    @Test
    public void getJsapiToken() {
        System.out.println(zwDingBaseService.getJsapiToken());
    }


    @Test
    public void getUserInfo() {
        AuthUserResp.ContentBean.DataBean resp = zwDingBaseService.getUserByCode("");
        System.out.println(resp);
    }

    @Test
    public void getUserByOauth2Code() {
        AuthUserResp.ContentBean.DataBean resp = zwDingBaseService.getUserByOauth2Code("");
        System.out.println(resp);
    }

}
