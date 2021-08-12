package com.bruce.zwdd.enums;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/10 15:32
 * @Author fzh
 */
public enum NotifyTypeEnum {

    /**
     * DING通知方式，短信(sms)、APP内(app)
     */
    SMS("sms"),
    APP("app");

    private String code;

    public String getCode() {
        return code;
    }

    NotifyTypeEnum(String code) {
        this.code = code;
    }


}
