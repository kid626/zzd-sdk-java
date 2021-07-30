package com.bruce.zwdd.service;

import com.alibaba.fastjson.JSONObject;
import com.bruce.zwdd.model.msg.req.Link;
import com.bruce.zwdd.model.msg.req.Text;
import com.bruce.zwdd.model.msg.req.WorkNotificationReq;
import com.bruce.zwdd.model.msg.resp.WorkNotificationResp;
import com.bruce.zwdd.service.impl.ZwDingMsgServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 15:14
 * @Author fzh
 */
public class ZwDingMsgServiceImplTest extends ZwDingBaseServiceImplTest {

    ZwDingMsgService zwDingMsgService;

    @Before
    public void init() {
        zwDingMsgService = new ZwDingMsgServiceImpl(appKey, appSecret, domainName, protocol, tenantId);
    }


    @Test
    public void workNotification() {
        WorkNotificationReq req = new WorkNotificationReq();
        Link link = new Link();
        link.setMsgtype("link");
        Link.LinkBean linkBean = new Link.LinkBean();
        linkBean.setTitle("测试 title");
        linkBean.setPicUrl("https://cn.bing.com/images/search?view=detailV2&ccid=Osh2D0sc&id=9E528B5CDB3BD45F758063DE0A1FECBD29071FDB&thid=OIP.Osh2D0sckvtd-5AI1U_GZwHaHa&mediaurl=http%3a%2f%2fpic13.nipic.com%2f20110420%2f3320946_081839675000_2.jpg&exph=1024&expw=1024&q=%e5%9b%be%e7%89%87&simid=607992405238941084&ck=F45D28011AE4C8EBF8EC39CDC6DD470A&selectedIndex=1&FORM=IRPRST");
        linkBean.setText("测试 text");
        linkBean.setMessageUrl("https://www.baidu.com");
        link.setLink(linkBean);
        Text text = new Text();
        text.setMsgtype("text");
        Text.TextBean textBean = new Text.TextBean();
        textBean.setContent("测试消息");
        text.setText(textBean);
        req.setMsg(JSONObject.toJSONString(link));
        req.setBizMsgId("2021072912330000");
        req.setReceiverIds("***");
        WorkNotificationResp resp = zwDingMsgService.workNotification(req);
        System.out.println(resp);
    }

}
