package com.bruce.zwdd.model.msg.req;

import com.bruce.zwdd.enums.MsgTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 11:04
 * @Author fzh
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Image extends BaseMsg implements Serializable {

    // {
    //     "msgtype":"image",
    //     "image":{
    //         "mediaId":"xxx",
    //         "picSize":"xxx",
    //         "fileType":"xxx"
    //     }
    // }

    private String msgtype = MsgTypeEnum.IMAGE.getType();
    private ImageBean image;

    @Data
    public static class ImageBean {
        private String mediaId;
        private String picSize;
        private String fileType;
    }
}
