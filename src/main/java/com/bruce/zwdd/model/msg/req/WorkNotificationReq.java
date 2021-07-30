package com.bruce.zwdd.model.msg.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/14 15:50
 * @Author fzh
 */
@Data
public class WorkNotificationReq implements Serializable {

    /**
     * 接收者的部门id列表，最大列表长度：100, 接收者是部门id下(包括子部门下)的所有用户
     */
    String organizationCodes;

    /**
     * 接收人用户ID(accountId)，最大列表长度：100, 多个人时使用半角逗号分隔
     */
    String receiverIds;

    /**
     * 业务消息id，自定义，有去重功能 调用者的业务数据ID，同样的ID调用多次会提示"重复"错误
     */
    String bizMsgId;

    /**
     * json对象 必须 {"msgtype":"text","text":{"content":"消息内容"}} 消息内容，目前支持：文本消息：text, 链接消息：link, OA消息：oa, 卡片消息：action_card。最长不超过2048个字节
     */
    String msg;

}
