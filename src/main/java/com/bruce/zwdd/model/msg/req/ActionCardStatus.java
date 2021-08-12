package com.bruce.zwdd.model.msg.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.bruce.zwdd.enums.MsgTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 审批卡片
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 14:55
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class ActionCardStatus extends BaseMsg implements Serializable {

    // {"msgtype":"action_card","action_card":{"title":"审批通知","markdown":"周强申请[Adobe Illustrator for Mac]收费软件的使用权限\n发起人:周强\n发起时间:2020-04-29 18:14:41","statusInfo":{"text":"已完成","bgcolor":"#00B853","allcolor":"rgba(31, 31, 31, .65)","disableButton":true},"btn_orientation":"1","btn_json_list":[{"title":"已同意","action_url":"openAction:www.service.com/api/xxx?processKey=xxxx&action=accepted","bgcolor":"rgba(31, 31, 31, 0.3)"}]}}

    private String msgtype = MsgTypeEnum.ACTION_CARD.getType();
    @JSONField(name = "action_card")
    private ActionCardDTO actionCard;

    @NoArgsConstructor
    @Data
    public static class ActionCardDTO {
        private String title;
        private String markdown;
        private StatusInfoDTO statusInfo;
        @JSONField(name = "btn_orientation")
        private String btnOrientation;
        @JSONField(name = "btn_json_list")
        private List<BtnJsonListDTO> btnJsonList;

        @NoArgsConstructor
        @Data
        public static class StatusInfoDTO {
            private String text;
            private String bgcolor;
            private String allcolor;
            private Boolean disableButton;
        }

        @NoArgsConstructor
        @Data
        public static class BtnJsonListDTO {
            private String title;
            @JSONField(name = "action_url")
            private String actionUrl;
            private String bgcolor;
        }
    }
}
