package com.bruce.zwdd.model.msg.req;

import com.bruce.zwdd.enums.MsgTypeEnum;
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
public class Text extends BaseMsg implements Serializable {


    /**
     * msgtype : text
     * text : {"content":"张三的请假申请"}
     */
    private String msgtype = MsgTypeEnum.TEXT.getType();
    private TextBean text;

    @Data
    public static class TextBean {
        /**
         * content : 张三的请假申请
         */

        private String content;
    }
}
