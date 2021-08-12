## 简介 ##

```markdown
浙政钉（专有钉钉）sdk java 版 
VERSION : 1.2.0
```

## 官方文档(需要登录) ##

#### [服务端api](https://openplatform-portal.dg-work.cn/#/docs?apiType=serverapi&docKey=2674832) ####

- [企业内应用免登](https://openplatform-portal.dg-work.cn/#/docs?apiType=serverapi&docKey=2674834)
- [应用管理后台免登](https://openplatform-portal.dg-work.cn/#/docs?apiType=serverapi&docKey=2674932)
- [获取通讯录部门信息](https://openplatform-portal.dg-work.cn/#/docs?apiType=serverapi&docKey=2785626)
- [获取通讯录用户信息](https://openplatform-portal.dg-work.cn/#/docs?apiType=serverapi&docKey=2674843)
- [工作通知消息](https://openplatform-portal.dg-work.cn/#/docs?apiType=serverapi&docKey=2674860)

## 引入方式 ##

```text
需要先引入第三方 jar 包 zwdd-sdk-java-1.2.0.jar
```

## 使用说明 ##

```java
public class XXXService {

    ZwDingBaseService zwDingBaseService;

    public XXXService(String appKey, String appSecret, String domainName, String protocol, Long tenantId) {
        zwDingBaseService = new ZwDingBaseServiceImpl(appKey, appSecret, domainName, protocol, tenantId);
    }

    public String getAccessToken() {
        return zwDingBaseService.getAccessToken();
    }

}
```

## changelog #


### 1.0.0 ###
```text
[function] 首次封装
```


### 1.1.0 ###
```text
[function] 获取 jsapi_token 时支持使用自行管理的 access_token
```

### 1.2.0 ###
```text
[function] 添加 根据组织Code查询组织汇报线 接口
```
