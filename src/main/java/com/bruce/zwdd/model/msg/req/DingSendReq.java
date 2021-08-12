package com.bruce.zwdd.model.msg.req;

import com.bruce.zwdd.enums.NotifyTypeEnum;
import com.bruce.zwdd.enums.TextTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 10:35
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class DingSendReq implements Serializable {

    private BodyDTO body;
    private String bodyType = "text";
    private TextTypeEnum textType;
    private DingUserDTO creator;
    private NotifyTypeEnum notifyType;
    private List<DingUserDTO> receivers;

    @NoArgsConstructor
    @Data
    public static class BodyDTO {
        private String text;
    }

    @NoArgsConstructor
    @Data
    public static class DingUserDTO {
        private String accountId;
        private String accountOrgId;
        private String accountOrgName;
    }
}