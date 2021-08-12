package com.bruce.zwdd.enums;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName em-zzd-sdk
 * @Date 2021/8/10 15:32
 * @Author fzh
 */
public enum ChatTypeEnum {

    /**
     * 发起的会话类型（1单聊、2群聊）
     */
    SINGLE(1),
    GROUP(2);

    private Integer type;

    public Integer getType() {
        return type;
    }

    ChatTypeEnum(Integer type) {
        this.type = type;
    }


}
