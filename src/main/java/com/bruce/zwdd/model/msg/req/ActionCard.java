package com.bruce.zwdd.model.msg.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.bruce.zwdd.enums.MsgTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 卡片整体跳转
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 14:26
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class ActionCard extends BaseMsg implements Serializable {

    // {
    //     "msgtype": "action_card",
    //     "action_card": {
    //         "title": "是透出到会话列表和通知的文案",
    //         "markdown": "目前不支持markdown，只能传纯文本",
    //         "single_title": "查看详情",
    //         "single_url": "https://open.dingtalk.com",
    //         "single_pc_url": "https://open.dingtalk.com"
    //     }
    // }

    private String msgtype = MsgTypeEnum.ACTION_CARD.getType();
    @JSONField(name = "action_card")
    private ActionCardDTO actionCard;

    @NoArgsConstructor
    @Data
    public static class ActionCardDTO {
        private String title;
        private String markdown;
        @JSONField(name = "single_title")
        private String singleTitle;
        @JSONField(name = "single_url")
        private String singleUrl;
        @JSONField(name = "single_pc_url")
        private String singlePcUrl;
    }
}
