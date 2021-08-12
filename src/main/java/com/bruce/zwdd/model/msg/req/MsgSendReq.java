package com.bruce.zwdd.model.msg.req;

import com.bruce.zwdd.enums.ChatTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 10:36
 * @Author fzh
 */
@Data
public class MsgSendReq<T extends BaseMsg> implements Serializable {

    /**
     * 消息体(参考下文示例消息格式)
     */
    private T msg;

    /**
     * 发送者用户id
     */
    private String senderId;

    /**
     * 单聊接受者用户id（chatType为1时必填）
     */
    private String receiverId;

    /**
     * 群聊会话id（chatType为2时必填）
     */
    private String chatId;

    /**
     * 发起的会话类型（1单聊、2群聊）
     */
    private ChatTypeEnum chatType;
}
