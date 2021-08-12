package com.bruce.zwdd.model.msg.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 13:52
 * @Author fzh
 */
@Data
public class NotificationSendResp implements Serializable {

    /**
     * success : true
     * content : 消息id
     */

    private boolean success;
    private ContentBean content;

    private String errorCode;

    private String errorMsg;

    @Data
    public static class ContentBean {

        private String msgId;

    }

}
