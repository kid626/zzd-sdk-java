package com.bruce.zwdd.service;

import com.bruce.zwdd.model.msg.req.*;
import com.bruce.zwdd.model.msg.resp.MsgSendResp;
import com.bruce.zwdd.model.msg.resp.NotificationSendResp;
import com.bruce.zwdd.model.msg.resp.WorkNotificationResp;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 13:38
 * @Author fzh
 */
public interface ZwDingMsgService extends ZwDingBaseService {

    /**
     * 工作通知
     *
     * @param req WorkNotificationReq
     * @return String
     */
    WorkNotificationResp workNotification(WorkNotificationReq req);

    /**
     * 发送工作通知
     *
     * @param <T> 消息类型，支持 {@link Text,Link,Oa,ActionCard,ActionCardSingle,ActionCardLinks,ActionCardStatus,ActionCardNews}
     * @param req WorkNotificationReq
     * @return NotificationSendResp 消息 id
     */
    <T extends BaseMsg> NotificationSendResp notificationSend(NotificationSendReq<T> req);

    /**
     * 发送 ding 消息
     *
     * @param req DingSendReq
     * @return String   参数完整，都能返回 true
     */
    String dingSend(DingSendReq req);

    /**
     * 发送消息
     *
     * @param <T> 消息类型，支持 {@link Text,Link,File,Image}
     * @param req MsgSendReq
     * @return MsgSendResp  消息 id
     */
    <T extends BaseMsg> MsgSendResp msgSend(MsgSendReq<T> req);

}
