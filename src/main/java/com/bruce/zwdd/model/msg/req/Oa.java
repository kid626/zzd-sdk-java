package com.bruce.zwdd.model.msg.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/14 15:54
 * @Author fzh
 */
@Data
public class Oa implements Serializable {


    /**
     * msgtype : oa
     * oa : {"message_url":"http://dingtalk.com","head":{"bgcolor":"FFBBBBBB","text":"头部标题"},"body":{"title":"正文标题","form":[{"key":"姓名:","value":"张三"},{"key":"年龄:","value":"20"},{"key":"身高:","value":"1.8米"},{"key":"体重:","value":"130斤"},{"key":"学历:","value":"本科"},{"key":"爱好:","value":"打球、听音乐"}],"rich":{"num":"15.6","unit":"元"},"content":"大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本","image":"@lADOADmaWMzazQKA","file_count":"3","author":"李四 "}}
     */

    private String msgtype;
    private OaBean oa;

    @Data
    public static class OaBean {
        /**
         * message_url : http://dingtalk.com
         * head : {"bgcolor":"FFBBBBBB","text":"头部标题"}
         * body : {"title":"正文标题","form":[{"key":"姓名:","value":"张三"},{"key":"年龄:","value":"20"},{"key":"身高:","value":"1.8米"},{"key":"体重:","value":"130斤"},{"key":"学历:","value":"本科"},{"key":"爱好:","value":"打球、听音乐"}],"rich":{"num":"15.6","unit":"元"},"content":"大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本","image":"@lADOADmaWMzazQKA","file_count":"3","author":"李四 "}
         */

        @JSONField(name = "message_url")
        private String messageUrl;
        private HeadBean head;
        private BodyBean body;

        @Data
        public static class HeadBean {
            /**
             * bgcolor : FFBBBBBB
             * text : 头部标题
             */

            private String bgcolor;
            private String text;

        }

        @Data
        public static class BodyBean {
            /**
             * title : 正文标题
             * form : [{"key":"姓名:","value":"张三"},{"key":"年龄:","value":"20"},{"key":"身高:","value":"1.8米"},{"key":"体重:","value":"130斤"},{"key":"学历:","value":"本科"},{"key":"爱好:","value":"打球、听音乐"}]
             * rich : {"num":"15.6","unit":"元"}
             * content : 大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本
             * image : @lADOADmaWMzazQKA
             * file_count : 3
             * author : 李四
             */

            private String title;
            private RichBean rich;
            private String content;
            private String image;
            @JSONField(name = "file_count")
            private String fileCount;
            private String author;
            private List<FormBean> form;


            @Data
            public static class RichBean {
                /**
                 * num : 15.6
                 * unit : 元
                 */

                private String num;
                private String unit;
            }

            @Data
            public static class FormBean {
                /**
                 * key : 姓名:
                 * value : 张三
                 */

                private String key;
                private String value;

            }
        }
    }
}
