package com.bruce.zwdd.model.constant;

public class URLConstant {

    // base

    /**
     * 获取 token
     */
    public static final String GET_TOKEN = "/gettoken.json";

    /**
     * 获取 jsapi token
     */
    public static final String GET_JSAPI_TOKEN = "/get_jsapi_token.json";

    /**
     * 根据authCode换取用户信息
     */
    public static final String GET_USER_INFO = "/rpc/oauth2/dingtalk_app_user.json";

    /**
     * 服务端通过临时授权码获取授权用户的个人信息 扫码登录
     */
    public static final String GET_USER_INFO_BY_CODE = "/rpc/oauth2/getuserinfo_bycode.json";

    // user

    /**
     * 根据员工Code查询详情
     */
    public static final String GET_EMP_BY_CODE = "/mozi/employee/getEmployeeByCode";

    /**
     * 批量根据员工code查询详情
     */
    public static final String LIST_EMP_BY_CODES = "/mozi/employee/listEmployeesByCodes";

    /**
     * 根据员工 Code 获取员工的任职
     */
    public static final String LIST_EMP_POS_BY_CODE = "/mozi/employee/listEmployeePositionsByEmployeeCode";

    /**
     * 批量根据员工code获取员⼯账号ID
     */
    public static final String LIST_EMP_ACCOUNT_IDS = "/mozi/employee/listEmployeeAccountIds";

    /**
     * 批量根据账号Id获取人员Code
     */
    public static final String LIST_CODES_BY_ACCOUNT_IDS = "/mozi/employee/listGovEmployeeCodesByAccountIds";

    /**
     * 查询组织下人员详情
     */
    public static final String PAGE_ORG_EMP_POS = "/mozi/organization/pageOrganizationEmployeePositions";

    /**
     * 根据手机号获取人员编码
     */
    public static final String GET_BY_MOBILE = "/mozi/employee/get_by_mobile";

    /**
     * 批量根据手机号获取人员编码
     */
    public static final String GET_BY_MOBILES = "/mozi/employee/get_by_mobiles";

    /**
     * 获取通讯录权限范围
     */
    public static final String AUTH_SCOPE = "/auth/scopesV2";

    /**
     * 查询组织下人员详情，包含个人信息和任职信息
     */
    public static final String PAGE_SEARCH_EMP = "/mozi/fusion/pageSearchEmployee";

    // org

    /**
     * 获取根组织(已删除)
     */
    public static final String GET_ROOT_ORG = "/mozi/organization/getRootOrganization";

    /**
     * 分页查询组织下的员⼯ Code
     */
    public static final String GET_ORG_EMP = "/mozi/organization/pageOrganizationEmployeeCodes";

    /**
     * 根据组织 code 查询详情
     */
    public static final String GET_ORG_BY_CODE = "/mozi/organization/getOrganizationByCode";

    /**
     * 批量根据组织Code查询详情
     */
    public static final String BATCH_GET_ORG_BY_CODES = "/mozi/organization/listOrganizationsByCodes";

    /**
     * 分页获取下一级组织
     */
    public static final String PAGE_SUB_ORG_CODES = "/mozi/organization/pageSubOrganizationCodes";

    /**
     * 根据组织名称关键词进行组织信息查询
     */
    public static final String PAGE_SEARCH_ORG = "/mozi/fusion/pageSearchOrganization";

    // msg

    /**
     * 工作通知
     */
    public static final String SEND_MESSAGE = "/message/workNotification";


}
