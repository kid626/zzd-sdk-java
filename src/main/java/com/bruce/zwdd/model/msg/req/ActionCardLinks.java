package com.bruce.zwdd.model.msg.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.bruce.zwdd.enums.MsgTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc 卡片多链接
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 14:26
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class ActionCardLinks extends BaseMsg implements Serializable {

    // {
    //     "msgtype": "action_card",
    //     "action_card": {
    //         "title": "创建政务钉钉群，让工作沟通更高效",
    //         "imageUrl": "http://www.dingding.com/image.png",
    //         "markdown": "· 政务通讯录，1秒找同事  \n· 考勤/审批/日志等千款应用   \n· 办公电话，告别繁琐的座机",
    //         "btn_orientation": "0",
    //         "btn_json_list": [{
    //             "title": "了解政务钉钉特色功能",
    //             "action_url": "https://gov.dingtalk.com/"
    //         },
    //         {
    //             "title": "功能操作二",
    //             "action_url": "https://gov.dingtalk.com/solution/?spm=a2q2b.13441934.0.0.123617deM2Bwaa"
    //         },
    //         {
    //             "title": "功能操作三",
    //             "action_url": "https://service.dg-work.cn/page/home?spm=a2q2b.13441934.0.0.4fba17de09n0k6&pageId=598&language=zh"
    //         }
    // 	    ]
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
