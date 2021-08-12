package com.bruce.zwdd.service;

import com.alibaba.fastjson.JSONObject;
import com.bruce.zwdd.enums.ChatTypeEnum;
import com.bruce.zwdd.enums.NotifyTypeEnum;
import com.bruce.zwdd.enums.TextTypeEnum;
import com.bruce.zwdd.model.msg.req.*;
import com.bruce.zwdd.model.msg.resp.MsgSendResp;
import com.bruce.zwdd.model.msg.resp.NotificationSendResp;
import com.bruce.zwdd.model.msg.resp.WorkNotificationResp;
import com.bruce.zwdd.service.impl.ZwDingMsgServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 15:14
 * @Author fzh
 */
public class ZwDingMsgServiceImplTest extends ZwDingBaseServiceImplTest {

    ZwDingMsgService zwDingMsgService;

    String accountId = "";

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

    @Test
    public void notificationSendText() {
        String bizMsgId = generateId();
        NotificationSendReq<Text> req = new NotificationSendReq<>();
        // 发送普通文本消息
        Text text = new Text();
        Text.TextBean textBean = new Text.TextBean();
        textBean.setContent("测试消息1");
        text.setText(textBean);
        req.setMsg(text);
        req.setBizMsgId(bizMsgId);
        req.setReceiverIds(accountId);
        NotificationSendResp resp = zwDingMsgService.notificationSend(req);
        Assert.assertEquals(resp.getContent().getMsgId(), bizMsgId);
        System.out.println(resp);
    }


    @Test
    public void notificationSendOa() {
        String bizMsgId = generateId();
        NotificationSendReq<Oa> req = new NotificationSendReq<>();
        Oa oa = new Oa();
        Oa.OaBean bean = new Oa.OaBean();
        bean.setHead(new Oa.OaBean.HeadBean());
        bean.getHead().setText("头部标题1");
        bean.getHead().setBgcolor("FFBBBBBB");
        bean.setMessageUrl("https://dingtalk.com");
        bean.setPcMessageUrl("https://dingtalk.com");
        bean.setBody(new Oa.OaBean.BodyBean());
        bean.getBody().setTitle("正文标题");
        bean.getBody().setAuthor("bruce");
        bean.getBody().setFileCount("0");
        bean.getBody().setImage("mediaId");
        bean.getBody().setContent("大段文本大段文本大段文本大段文本大段文本大段文本");
        bean.getBody().setRich(new Oa.OaBean.BodyBean.RichBean());
        bean.getBody().getRich().setNum("15.6");
        bean.getBody().getRich().setUnit("￥");
        List<Oa.OaBean.BodyBean.FormBean> forms = new ArrayList<>();
        Oa.OaBean.BodyBean.FormBean form1 = new Oa.OaBean.BodyBean.FormBean();
        form1.setKey("姓名:");
        form1.setValue("bruce");
        forms.add(form1);
        Oa.OaBean.BodyBean.FormBean form2 = new Oa.OaBean.BodyBean.FormBean();
        form2.setKey("年龄:");
        form2.setValue("24");
        forms.add(form2);
        Oa.OaBean.BodyBean.FormBean form3 = new Oa.OaBean.BodyBean.FormBean();
        form3.setKey("身高:");
        form3.setValue("1.85");
        forms.add(form3);
        Oa.OaBean.BodyBean.FormBean form4 = new Oa.OaBean.BodyBean.FormBean();
        form4.setKey("体重:");
        form4.setValue("160");
        forms.add(form4);
        Oa.OaBean.BodyBean.FormBean form5 = new Oa.OaBean.BodyBean.FormBean();
        form5.setKey("学历:");
        form5.setValue("本科");
        forms.add(form5);
        Oa.OaBean.BodyBean.FormBean form6 = new Oa.OaBean.BodyBean.FormBean();
        form6.setKey("爱好:");
        form6.setValue("打球、听音乐");
        forms.add(form6);
        bean.getBody().setTitle("正文标题");
        bean.getBody().setForm(forms);
        oa.setOa(bean);
        req.setMsg(oa);
        req.setBizMsgId(bizMsgId);
        req.setReceiverIds(accountId);
        NotificationSendResp resp = zwDingMsgService.notificationSend(req);
        Assert.assertEquals(resp.getContent().getMsgId(), bizMsgId);
        System.out.println(resp);
    }

    private String generateId() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String format = now.format(dtf);
        String sources = "0123456789";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 6; j++) {
            sb.append(sources.charAt(rand.nextInt(9)));
        }
        return format + sb;
    }


    @Test
    public void notificationSendActionCard() {
        String bizMsgId = generateId();
        NotificationSendReq<ActionCard> req = new NotificationSendReq<>();
        ActionCard actionCard = new ActionCard();
        ActionCard.ActionCardDTO dto = new ActionCard.ActionCardDTO();
        dto.setTitle("标题");
        dto.setMarkdown("目前不支持markdown，只能传纯文本");
        dto.setSingleTitle("查看详情");
        dto.setSingleUrl("https://open.dingtalk.com");
        actionCard.setActionCard(dto);
        req.setMsg(actionCard);
        req.setBizMsgId(bizMsgId);
        req.setReceiverIds(accountId);
        NotificationSendResp resp = zwDingMsgService.notificationSend(req);
        Assert.assertEquals(resp.getContent().getMsgId(), bizMsgId);
        System.out.println(resp);
    }

    @Test
    public void notificationSendActionCardSingle() {
        String bizMsgId = generateId();
        NotificationSendReq<ActionCardSingle> req = new NotificationSendReq<>();
        ActionCardSingle actionCard = new ActionCardSingle();
        ActionCardSingle.ActionCardDTO dto = new ActionCardSingle.ActionCardDTO();
        dto.setTitle("标题");
        dto.setMarkdown("目前不支持markdown，只能传纯文本");
        dto.setBtnOrientation("1");
        ArrayList<ActionCardSingle.ActionCardDTO.BtnJsonListDTO> list = new ArrayList<>();
        ActionCardSingle.ActionCardDTO.BtnJsonListDTO btnJsonDTO1 = new ActionCardSingle.ActionCardDTO.BtnJsonListDTO();
        btnJsonDTO1.setTitle("淘宝");
        btnJsonDTO1.setActionPcUrl("https://www.taobao.com");
        btnJsonDTO1.setActionMobileUrl("https://www.taobao.com");
        list.add(btnJsonDTO1);
        ActionCardSingle.ActionCardDTO.BtnJsonListDTO btnJsonDTO2 = new ActionCardSingle.ActionCardDTO.BtnJsonListDTO();
        btnJsonDTO2.setTitle("百度");
        btnJsonDTO2.setActionPcUrl("https://www.baidu.com");
        btnJsonDTO2.setActionMobileUrl("https://www.baidu.com");
        list.add(btnJsonDTO2);
        dto.setBtnJsonList(list);
        actionCard.setActionCard(dto);
        req.setMsg(actionCard);
        req.setBizMsgId(bizMsgId);
        req.setReceiverIds(accountId);
        NotificationSendResp resp = zwDingMsgService.notificationSend(req);
        Assert.assertEquals(resp.getContent().getMsgId(), bizMsgId);
        System.out.println(resp);
    }

    @Test
    public void notificationSendActionCardStatus() {
        String bizMsgId = generateId();
        NotificationSendReq<ActionCardStatus> req = new NotificationSendReq<>();
        ActionCardStatus actionCard = new ActionCardStatus();
        ActionCardStatus.ActionCardDTO dto = new ActionCardStatus.ActionCardDTO();
        dto.setTitle("审批通知");
        dto.setMarkdown("周强申请[Adobe Illustrator for Mac]收费软件的使用权限\n发起人:周强\n发起时间:2020-04-29 18:14:41");
        dto.setBtnOrientation("1");
        ActionCardStatus.ActionCardDTO.StatusInfoDTO statusInfoDTO = new ActionCardStatus.ActionCardDTO.StatusInfoDTO();
        statusInfoDTO.setText("待审批");
        statusInfoDTO.setBgcolor("#FF9F00");
        statusInfoDTO.setAllcolor("rgba(31, 31, 31)");
        statusInfoDTO.setDisableButton(true);
        dto.setStatusInfo(statusInfoDTO);
        ArrayList<ActionCardStatus.ActionCardDTO.BtnJsonListDTO> list = new ArrayList<>();
        ActionCardStatus.ActionCardDTO.BtnJsonListDTO btnJsonDTO1 = new ActionCardStatus.ActionCardDTO.BtnJsonListDTO();
        btnJsonDTO1.setTitle("同意");
        btnJsonDTO1.setActionUrl("openAction:www.service.com/api/xxx?processKey=xxxx&action=accepted");
        btnJsonDTO1.setBgcolor("rgba(31, 31, 31, 0.3)");
        list.add(btnJsonDTO1);
        ActionCardStatus.ActionCardDTO.BtnJsonListDTO btnJsonDTO2 = new ActionCardStatus.ActionCardDTO.BtnJsonListDTO();
        btnJsonDTO2.setTitle("拒绝");
        btnJsonDTO2.setActionUrl("openAction:www.service.com/api/xxx?processKey=xxxx&action=rejected");
        btnJsonDTO2.setBgcolor("rgba(31, 31, 31, 0.3)");
        list.add(btnJsonDTO2);
        dto.setBtnJsonList(list);
        actionCard.setActionCard(dto);
        req.setMsg(actionCard);
        req.setBizMsgId(bizMsgId);
        req.setReceiverIds(accountId);
        NotificationSendResp resp = zwDingMsgService.notificationSend(req);
        Assert.assertEquals(resp.getContent().getMsgId(), bizMsgId);
        System.out.println(resp);
    }

    @Test
    public void notificationSendActionCardLinks() {
        String bizMsgId = generateId();
        NotificationSendReq<ActionCardLinks> req = new NotificationSendReq<>();
        ActionCardLinks actionCard = new ActionCardLinks();
        ActionCardLinks.ActionCardDTO dto = new ActionCardLinks.ActionCardDTO();
        dto.setTitle("创建政务钉钉群，让工作沟通更高效");
        dto.setImageUrl("http://www.dingding.com/image.png");
        dto.setMarkdown("· 政务通讯录，1秒找同事  \n· 考勤/审批/日志等千款应用   \n· 办公电话，告别繁琐的座机");
        dto.setBtnOrientation("0");
        ArrayList<ActionCardLinks.ActionCardDTO.BtnJsonListDTO> list = new ArrayList<>();
        ActionCardLinks.ActionCardDTO.BtnJsonListDTO btnJsonDTO1 = new ActionCardLinks.ActionCardDTO.BtnJsonListDTO();
        btnJsonDTO1.setTitle("了解政务钉钉特色功能");
        btnJsonDTO1.setActionUrl("https://gov.dingtalk.com/");
        list.add(btnJsonDTO1);
        ActionCardLinks.ActionCardDTO.BtnJsonListDTO btnJsonDTO2 = new ActionCardLinks.ActionCardDTO.BtnJsonListDTO();
        btnJsonDTO2.setTitle("功能操作二");
        btnJsonDTO2.setActionUrl("https://gov.dingtalk.com/solution/?spm=a2q2b.13441934.0.0.123617deM2Bwaa");
        list.add(btnJsonDTO2);
        ActionCardLinks.ActionCardDTO.BtnJsonListDTO btnJsonDTO3 = new ActionCardLinks.ActionCardDTO.BtnJsonListDTO();
        btnJsonDTO3.setTitle("功能操作三");
        btnJsonDTO3.setActionUrl("https://service.dg-work.cn/page/home?spm=a2q2b.13441934.0.0.4fba17de09n0k6&pageId=598&language=zh");
        list.add(btnJsonDTO3);
        dto.setBtnJsonList(list);
        actionCard.setActionCard(dto);
        req.setMsg(actionCard);
        req.setBizMsgId(bizMsgId);
        req.setReceiverIds(accountId);
        NotificationSendResp resp = zwDingMsgService.notificationSend(req);
        Assert.assertEquals(resp.getContent().getMsgId(), bizMsgId);
        System.out.println(resp);
    }

    @Test
    public void notificationSendActionCardNews() {
        String bizMsgId = generateId();
        NotificationSendReq<ActionCardNews> req = new NotificationSendReq<>();
        ActionCardNews actionCard = new ActionCardNews();
        ActionCardNews.ActionCardDTO dto = new ActionCardNews.ActionCardDTO();
        dto.setTitle("习近平关于[不忘初心，牢记使命]摘编");
        dto.setMarkdown("中国共产党人的初心和使命，就是为中国人民谋幸福，为中华民族谋复兴，习近平说，中国共产党第十九次全国代表大会，是在全面建成小康社会决胜阶段、中国特色社会主义进入新时代的关键时期召开的一次十分重要的大会。");
        dto.setBtnOrientation("1");
        dto.setImageUrl("http://www.dingding.com/image.png");
        ArrayList<ActionCardNews.ActionCardDTO.BtnJsonListDTO> list = new ArrayList<>();
        ActionCardNews.ActionCardDTO.BtnJsonListDTO btnJsonDTO1 = new ActionCardNews.ActionCardDTO.BtnJsonListDTO();
        btnJsonDTO1.setTitle("阅读详情");
        btnJsonDTO1.setActionUrl("https://gov.dingtalk.com/");
        list.add(btnJsonDTO1);
        dto.setBtnJsonList(list);
        actionCard.setActionCard(dto);
        req.setMsg(actionCard);
        req.setBizMsgId(bizMsgId);
        req.setReceiverIds(accountId);
        NotificationSendResp resp = zwDingMsgService.notificationSend(req);
        Assert.assertEquals(resp.getContent().getMsgId(), bizMsgId);
        System.out.println(resp);
    }

    @Test
    public void dingSend() {
        DingSendReq.DingUserDTO dingUserDTO = new DingSendReq.DingUserDTO();
        dingUserDTO.setAccountId(accountId);
        DingSendReq req = new DingSendReq();
        DingSendReq.BodyDTO bodyDTO = new DingSendReq.BodyDTO();
        bodyDTO.setText("测试钉消息666");
        req.setBody(bodyDTO);
        req.setCreator(dingUserDTO);
        List<DingSendReq.DingUserDTO> list = new ArrayList<>();
        list.add(dingUserDTO);
        req.setReceivers(list);
        req.setTextType(TextTypeEnum.PLAIN);
        req.setNotifyType(NotifyTypeEnum.APP);
        String resp = zwDingMsgService.dingSend(req);
        Assert.assertNotNull(resp);
    }

    @Test
    public void msgSend() {
        MsgSendReq<Text> req = new MsgSendReq<>();
        // 发送普通文本消息
        Text text = new Text();
        Text.TextBean textBean = new Text.TextBean();
        textBean.setContent("测试消息");
        text.setText(textBean);
        req.setMsg(text);
        req.setChatType(ChatTypeEnum.SINGLE);
        req.setSenderId(accountId);
        req.setReceiverId(accountId);
        MsgSendResp resp = zwDingMsgService.msgSend(req);
        Assert.assertNotNull(resp);
        System.out.println(resp);
    }


}
