package com.bruce.zwdd.model.msg.req;

import com.bruce.zwdd.enums.MsgTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 11:06
 * @Author fzh
 */
@Data
public class File extends BaseMsg implements Serializable {

    // {
    //     "msgtype":"file",
    //     "file":{
    //         "encrypt":false,
    //         "name":"1.jpg",
    //         "size":1024,
    //         "mediaId":"$iwHSAAC6KgoAC9EKgwKjcG5nAwAEJAUfBrDwNXiGnAKZ9QZt_lZ24yNfBwAIAAmhMA"
    //     }
    // }

    private String msgtype = MsgTypeEnum.FILE.getType();
    private FileBean file;

    @Data
    public static class FileBean {
        private Boolean encrypt;
        private String name;
        private Integer size;
        private String mediaId;
    }
}
