package com.bruce.zwdd.model.msg.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 10:56
 * @Author fzh
 */
@Data
public class MsgSendResp implements Serializable {

    private String messageId;

}
