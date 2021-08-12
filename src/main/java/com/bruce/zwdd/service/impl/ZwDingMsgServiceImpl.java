package com.bruce.zwdd.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.xxpt.gateway.shared.api.request.OapiChatSendMsgRequest;
import com.alibaba.xxpt.gateway.shared.api.request.OapiGovDingIsvSendJsonRequest;
import com.alibaba.xxpt.gateway.shared.api.request.OapiMessageWorkNotificationRequest;
import com.alibaba.xxpt.gateway.shared.api.response.OapiChatSendMsgResponse;
import com.alibaba.xxpt.gateway.shared.api.response.OapiGovDingIsvSendJsonResponse;
import com.alibaba.xxpt.gateway.shared.api.response.OapiMessageWorkNotificationResponse;
import com.alibaba.xxpt.gateway.shared.client.http.IntelligentPostClient;
import com.bruce.zwdd.enums.ChatTypeEnum;
import com.bruce.zwdd.exception.ZwDingDingException;
import com.bruce.zwdd.model.constant.URLConstant;
import com.bruce.zwdd.model.msg.req.*;
import com.bruce.zwdd.model.msg.resp.MsgSendResp;
import com.bruce.zwdd.model.msg.resp.NotificationSendResp;
import com.bruce.zwdd.model.msg.resp.WorkNotificationResp;
import com.bruce.zwdd.service.ZwDingMsgService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

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

    @Override
    public <T extends BaseMsg> NotificationSendResp notificationSend(NotificationSendReq<T> req) {
        T msg = req.getMsg();
        if (msg == null) {
            throw new ZwDingDingException("消息不能为空!");
        }
        if (!(msg instanceof Text || msg instanceof Link || msg instanceof Oa
                || msg instanceof ActionCardSingle || msg instanceof ActionCard
                || msg instanceof ActionCardStatus || msg instanceof ActionCardNews
                || msg instanceof ActionCardLinks)) {
            throw new ZwDingDingException("不支持的消息类型!");
        }
        IntelligentPostClient client = initClient(URLConstant.SEND_MESSAGE);
        OapiMessageWorkNotificationRequest request = new OapiMessageWorkNotificationRequest();
        request.setTenantId(String.valueOf(config.getTenantId()));
        request.setMsg(JSONObject.toJSONString(msg));
        if (StringUtils.isNotEmpty(req.getReceiverIds())) {
            request.setReceiverIds(req.getReceiverIds());
        }
        if (StringUtils.isNotEmpty(req.getOrganizationCodes())) {
            request.setOrganizationCodes(req.getOrganizationCodes());
        }
        if (StringUtils.isNotEmpty(req.getBizMsgId())) {
            request.setBizMsgId(req.getBizMsgId());
        }
        OapiMessageWorkNotificationResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseObject(data, NotificationSendResp.class);
    }

    @Override
    public String dingSend(DingSendReq req) {
        IntelligentPostClient client = initClient(URLConstant.SEND_DING);
        OapiGovDingIsvSendJsonRequest request = new OapiGovDingIsvSendJsonRequest();
        request.setTenantId(config.getTenantId());
        request.setBodyType("text");
        if (req.getCreator() != null) {
            request.setCreator(JSONObject.toJSONString(req.getCreator()));
        }
        if (CollectionUtils.isNotEmpty(req.getReceivers())) {
            request.setReceivers(Collections.singletonList(JSONObject.toJSONString(req.getReceivers())));
        }
        request.setNotifyType(req.getNotifyType().getCode());
        request.setTextType(req.getTextType().getCode());
        request.setBody(JSONObject.toJSONString(req.getBody()));
        OapiGovDingIsvSendJsonResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseObject(data, String.class);
    }

    @Override
    public <T extends BaseMsg> MsgSendResp msgSend(MsgSendReq<T> req) {
        T msg = req.getMsg();
        if (msg == null) {
            throw new ZwDingDingException("消息不能为空!");
        }
        if (!(msg instanceof Text || msg instanceof Image
                || msg instanceof Link || msg instanceof File)) {
            throw new ZwDingDingException("不支持的消息类型!");
        }
        IntelligentPostClient client = initClient(URLConstant.SEND_MSG);
        OapiChatSendMsgRequest request = new OapiChatSendMsgRequest();
        request.setTenantId(config.getTenantId());
        request.setSenderId(req.getSenderId());
        request.setChatType(req.getChatType().getType());
        if (ChatTypeEnum.SINGLE.getType().equals(request.getChatType())) {
            request.setReceiverId(req.getReceiverId());
        }
        if (ChatTypeEnum.GROUP.getType().equals(request.getChatType())) {
            request.setChatId(req.getChatId());
        }
        request.setMsg(JSONObject.toJSONString(msg));
        OapiChatSendMsgResponse apiResult = client.post(request);
        String data = getData(apiResult);
        return JSONObject.parseObject(data, MsgSendResp.class);
    }
}
