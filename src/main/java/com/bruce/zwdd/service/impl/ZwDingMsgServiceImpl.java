package com.bruce.zwdd.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.xxpt.gateway.shared.api.request.OapiMessageWorkNotificationRequest;
import com.alibaba.xxpt.gateway.shared.api.response.OapiMessageWorkNotificationResponse;
import com.alibaba.xxpt.gateway.shared.client.http.IntelligentPostClient;
import com.bruce.zwdd.exception.ZwDingDingException;
import com.bruce.zwdd.model.constant.URLConstant;
import com.bruce.zwdd.model.msg.req.WorkNotificationReq;
import com.bruce.zwdd.model.msg.resp.WorkNotificationResp;
import com.bruce.zwdd.service.ZwDingMsgService;
import org.apache.commons.lang3.StringUtils;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/14 15:58
 * @Author fzh
 */
public class ZwDingMsgServiceImpl extends ZwDingBaseServiceImpl implements ZwDingMsgService {

    /**
     * @param appKey    应用的唯一标识key
     * @param appSecret 应用的密钥
     */
    public ZwDingMsgServiceImpl(String appKey, String appSecret, String domainName, String protocol, Long tenantId) {
        super(appKey, appSecret, domainName, protocol, tenantId);
    }

    @Override
    public WorkNotificationResp workNotification(WorkNotificationReq req) {
        IntelligentPostClient client = initClient(URLConstant.SEND_MESSAGE);
        OapiMessageWorkNotificationRequest request = new OapiMessageWorkNotificationRequest();
        request.setTenantId(String.valueOf(config.getTenantId()));
        request.setMsg(req.getMsg());
        if (StringUtils.isNotEmpty(req.getOrganizationCodes())) {
            request.setOrganizationCodes(req.getOrganizationCodes());
        }
        if (StringUtils.isNotEmpty(req.getReceiverIds())) {
            request.setReceiverIds(req.getReceiverIds());
        }
        if (StringUtils.isNotEmpty(req.getBizMsgId())) {
            request.setBizMsgId(req.getBizMsgId());
        }
        OapiMessageWorkNotificationResponse apiResult = client.post(request);
        String data = getData(apiResult);
        WorkNotificationResp resp = JSONObject.parseObject(data, WorkNotificationResp.class);
        if (!resp.isSuccess()) {
            throw new ZwDingDingException(resp.getErrorMsg());
        }
        return resp;
    }
}
