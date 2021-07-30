package com.bruce.zwdd.service;

import com.bruce.zwdd.model.msg.req.WorkNotificationReq;
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

}
