package com.bruce.zwdd.model.msg.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/8/12 11:00
 * @Author fzh
 */
@Data
public class BaseMsg implements Serializable {

    private String msgtype;

}
