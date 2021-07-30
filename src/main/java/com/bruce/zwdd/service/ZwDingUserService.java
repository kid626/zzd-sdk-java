package com.bruce.zwdd.service;

import com.bruce.zwdd.model.user.req.PageOrganizationEmployeePositionsReq;
import com.bruce.zwdd.model.user.req.PageSearchEmployeeReq;
import com.bruce.zwdd.model.user.resp.*;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/11 13:38
 * @Author fzh
 */
public interface ZwDingUserService extends ZwDingBaseService {


    /**
     * 根据员工code查询详情
     *
     * @param employeeCode 员工 code
     * @return GetEmployeeByCodeResp
     */
    GetEmployeeByCodeResp getEmployeeByCode(String employeeCode);

    /**
     * 批量根据员工code查询详情
     *
     * @param employeeCodes 员工 codes
     * @return GetEmployeeByCodeResp
     */
    List<GetEmployeeByCodeResp> listEmployeesByCodes(List<String> employeeCodes);

    /**
     * 根据员工 Code 获取员工的任职
     *
     * @param employeeCode 员工 code
     * @param status       员工在组织内任职状态条件 A - 查询有效的数据 F - 查询无效的数据 TOTAL - 查询所有的数据
     * @param type         所需员工任职类型 默认是主职 EMPLOYEE_POSITION_ALL - 所有 EMPLOYEE_POSITION_MAIN - 主职EMPLOYEE_POSITION_ADJUNCT - 非主职
     * @return ListEmployeePosByEmpCodeResp
     */
    List<ListEmployeePosByEmpCodeResp> listEmployeePositionsByEmployeeCode(String employeeCode, String status, String type);


    /**
     * 批量根据员工Code获取员⼯账号ID
     *
     * @param employeeCodes 员工 codes
     * @return ListEmpAccountIdsResp
     */
    List<ListEmpAccountIdsResp> listEmployeeAccountIds(List<String> employeeCodes);

    /**
     * 批量根据账号Id获取人员Code
     *
     * @param accountIds 账号 id list
     * @return ListEmpCodesByAccountIdsResp
     */
    List<ListEmpCodesByAccountIdsResp> listGovEmployeeCodesByAccountIds(List<Long> accountIds);

    /**
     * 查询组织下人员详情
     *
     * @param req PageOrganizationEmployeePositionsReq
     * @return PageOrganizationEmployeePositionsResp
     */
    List<PageOrganizationEmployeePositionsResp> pageOrganizationEmployeePositions(PageOrganizationEmployeePositionsReq req);

    /**
     * 根据手机号码获取人员编码
     *
     * @param mobile 手机号码
     * @return GetByMobileResp
     */
    GetByMobileResp getByMobile(String mobile);

    /**
     * 批量根据手机号码获取人员编码
     *
     * @param mobiles 手机号码列表，逗号分隔，最多50个
     * @return GetByMobileResp
     */
    List<GetByMobileResp> getByMobiles(String mobiles);

    /**
     * 获取通讯录权限范围
     *
     * @param tenantId 租户 id
     * @return 获取通讯录权限范围
     */
    GetAuthScopesResp getAuthScopes(Long tenantId);

    /**
     * 根据姓名关键词进行人员信息查询
     *
     * @param req PageSearchEmployeeReq
     * @return PageSearchEmpResp
     */
    List<PageSearchEmpResp> pageSearchEmployee(PageSearchEmployeeReq req);


}
