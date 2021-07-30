package com.bruce.zwdd.model.user.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2020/9/14 14:52
 * @Author fzh
 */
@Data
public class PageOrganizationEmployeePositionsResp implements Serializable {

    /**
     * employeeName : 棱石
     * gmtCreate : 2020-07-21 10:58:30
     * empGender : 1
     * employeeCode : GE_0cde45ff162449f894fcf2fff2477421
     * empPoliticalStatusCode :
     * govEmployeePositions : [{"posJobRankCode":"","orderInOrganization":898,"mainJob":true,"empPosUnitCode":"1021000000","gmtCreate":"2020-07-21 10:58:31","empPosInnerInstitutionCode":"GO_66ffbae57f6d4eaa93da404c2591ba69","empPosEmployeeRoleCode":"REN_YUAN_JU_SE_TE_SHU_YONG_HU","employeeCode":"GE_0cde45ff162449f894fcf2fff2477421","jobAttributesCode":"1","organizationCode":"GO_66ffbae57f6d4eaa93da404c2591ba69","empPosVirtualOrganizationCode":"1021100000","status":"A"}]
     * empJobLevelCode : ZHI_JI_QI_TA
     * empBudgetedPostCode : BIAN_ZHI_QI_TA
     * status : A
     */

    private String employeeName;
    private String gmtCreate;
    private String empGender;
    private String employeeCode;
    private String empPoliticalStatusCode;
    private String empJobLevelCode;
    private String empBudgetedPostCode;
    private String status;
    private List<GovEmployeePositionsBean> govEmployeePositions;

    @Data
    public static class GovEmployeePositionsBean {
        /**
         * posJobRankCode :
         * orderInOrganization : 898
         * mainJob : true
         * empPosUnitCode : 1021000000
         * gmtCreate : 2020-07-21 10:58:31
         * empPosInnerInstitutionCode : GO_66ffbae57f6d4eaa93da404c2591ba69
         * empPosEmployeeRoleCode : REN_YUAN_JU_SE_TE_SHU_YONG_HU
         * employeeCode : GE_0cde45ff162449f894fcf2fff2477421
         * jobAttributesCode : 1
         * organizationCode : GO_66ffbae57f6d4eaa93da404c2591ba69
         * empPosVirtualOrganizationCode : 1021100000
         * status : A
         */

        private String posJobRankCode;
        private int orderInOrganization;
        private boolean mainJob;
        private String empPosUnitCode;
        private String gmtCreate;
        private String empPosInnerInstitutionCode;
        private String empPosEmployeeRoleCode;
        private String employeeCode;
        private String jobAttributesCode;
        private String organizationCode;
        private String empPosVirtualOrganizationCode;
        private String status;

    }
}
