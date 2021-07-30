package com.bruce.zwdd.model.msg.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/14 15:54
 * @Author fzh
 */
@Data
public class Link implements Serializable {


    /**
     * msgtype : link
     * link : {"messageUrl":"http://s.dingtalk.com/market/dingtalk/error_code.php","picUrl":"@lALOACZwe2Rk","title":"测试","text":"测试"}
     */

    private String msgtype;
    private LinkBean link;

    @Data
    public static class LinkBean {
        /**
         * messageUrl : http://s.dingtalk.com/market/dingtalk/error_code.php
         * picUrl : @lALOACZwe2Rk
         * title : 测试
         * text : 测试
         */

        private String messageUrl;
        private String picUrl;
        private String title;
        private String text;

    }
}
