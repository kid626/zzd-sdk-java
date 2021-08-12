package com.bruce.zwdd.model.msg.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.bruce.zwdd.enums.MsgTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 卡片资讯
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 14:26
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class ActionCardNews extends BaseMsg implements Serializable {

    // {
    //     "msgtype": "action_card",
    //     "action_card": {
    //         "title": "习近平关于[不忘初心，牢记使命]摘编",
    //         "imageUrl": "http://www.dingding.com/image.png",
    //         "markdown": "中国共产党人的初心和使命，就是为中国人民谋幸福，为中华民族谋复兴，习近平说，中国共产党第十九次全国代表大会，是在全面建成小康社会决胜阶段、中国特色社会主义进入新时代的关键时期召开的一次十分重要的大会。",
    //         "btn_orientation": "1",
    //         "btn_json_list": [{
    //             "title": "阅读详情",
    //             "action_url": "https://gov.dingtalk.com/"
    //         }]
    //     }
    // }

    private String msgtype = MsgTypeEnum.ACTION_CARD.getType();
    @JSONField(name = "action_card")
    private ActionCardDTO actionCard;

    @NoArgsConstructor
    @Data
    public static class ActionCardDTO {
        private String title;
        private String imageUrl;
        private String markdown;
        @JSONField(name = "btn_orientation")
        private String btnOrientation;
        @JSONField(name = "btn_json_list")
        private List<BtnJsonListDTO> btnJsonList;

        @NoArgsConstructor
        @Data
        public static class BtnJsonListDTO {
            private String title;
            @JSONField(name = "action_url")
            private String actionUrl;
        }
    }
}
