package com.bruce.zwdd.model.msg.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.bruce.zwdd.enums.MsgTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 卡片独立跳转
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 14:26
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class ActionCardSingle extends BaseMsg implements Serializable {


    // {
    //     "msgtype": "action_card",
    //     "action_card": {
    //         "title": "是透出到会话列表和通知的文案",
    //         "markdown": "目前不支持markdown，只能传纯文本",
    //         "btn_orientation": "1",
    //         "btn_json_list": [
    //         {
    //             "title": "一个按钮",
    //             "action_pc_url": "https://www.taobao.com",
    //             "action_mobile_url": "https://www.taobao.com"
    //         },
    //         {
    //             "title": "两个按钮",
    //             "action_pc_url": "https://www.taobao.com",
    //             "action_mobile_url": "https://www.taobao.com"
    //         }
    //         ]
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
        @JSONField(name = "btn_orientation")
        private String btnOrientation;
        @JSONField(name = "btn_json_list")
        private List<BtnJsonListDTO> btnJsonList;

        @NoArgsConstructor
        @Data
        public static class BtnJsonListDTO {
            private String title;
            @JSONField(name = "action_pc_url")
            private String actionPcUrl;
            @JSONField(name = "action_mobile_url")
            private String actionMobileUrl;
        }
    }
}
