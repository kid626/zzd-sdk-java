package com.bruce.zwdd.model.msg.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/14 15:52
 * @Author fzh
 */
@Data
public class WorkNotificationResp implements Serializable {


    /**
     * success : true
     * content : 消息id
     */

    private boolean success;
    private String content;

    private String errorCode;

    private String errorMsg;

}
