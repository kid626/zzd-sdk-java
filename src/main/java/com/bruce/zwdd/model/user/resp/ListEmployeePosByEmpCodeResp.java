package com.bruce.zwdd.model.user.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 14:25
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class ListEmployeePosByEmpCodeResp {

    //  {
    //      "mainJob":false,
    //          "gmtCreate":"2019-10-23 21:42:05",
    //          "employeeCode":"GE_78e5f5015d7a44c5b4b53c20e166aac6",
    //          "organizationCode":"144",
    //          "status":"A",
    //          "order":1,
    //          "orderInOrganization":10,
    //          "govEmpPosAddress":"杭州市余杭区xxx",
    //          "govEmpPosPhoneNo":"0551-5433432",
    //          "govEmpPosJob":"工程师",
    //          "empPosUnitCode":"",
    //          "empPosInnerInstitutionCode":"",
    //          "empPosDepartmentCode":"",
    //          "empPosVirtualOrganizationCode":"",
    //          "empPosFaxNo":"",
    //          "empPosEmployeeRoleCode":"",
    //          "jobAttributesCode":"",
    //          "posJobRankCode":"",
    //          "visibilityIndicatorCode":"",
    //          "positionExtProperties": [{
    //      "code":"ext_EMPLOYEEPOSITION_fe789104",
    //              "type":"3",
    //              "value": [
    //      "1"
    //   ]
    //  },
    //      {
    //          "code":"ext_EMPLOYEEPOSITION_ae789144",
    //              "type":"2",
    //              "value": [
    //          "1"
    //   ]
    //      },
    //      {
    //          "code":"ext_EMPLOYEEPOSITION_3kr87wj3",
    //              "type":"0",
    //              "value": [
    //          "aa"
    //   ]
    //      }
    // ]
    //  }

    private Boolean mainJob;
    private String gmtCreate;
    private String employeeCode;
    private String organizationCode;
    private String status;
    private Integer order;
    private Integer orderInOrganization;
    private String govEmpPosAddress;
    private String govEmpPosPhoneNo;
    private String govEmpPosJob;
    private String empPosUnitCode;
    private String empPosInnerInstitutionCode;
    private String empPosDepartmentCode;
    private String empPosVirtualOrganizationCode;
    private String empPosFaxNo;
    private String empPosEmployeeRoleCode;
    private String jobAttributesCode;
    private String posJobRankCode;
    private String visibilityIndicatorCode;
    private List<PositionExtPropertiesDTO> positionExtProperties;

    @NoArgsConstructor
    @Data
    public static class PositionExtPropertiesDTO {
        private String code;
        private String type;
        private List<String> value;
    }
}
