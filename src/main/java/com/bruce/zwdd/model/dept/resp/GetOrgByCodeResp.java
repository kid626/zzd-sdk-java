package com.bruce.zwdd.model.dept.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 15:03
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class GetOrgByCodeResp {

    // {
    //     "typeName": "虚节点",
    //     "organizationName": "余杭区",
    //     "typeCode": "GOV_HOLLOW_NODE",
    //     "gmtCreate": "2019-10-21 19:15:13",
    //     "parentName": "杭州市",
    //     "parentCode": "75",
    //     "organizationCode": "76",
    //     "status": "A", //A - 有效的数据, F - 无效的数据
    //     "responsibleEmployeeCodes":"GE_12j2hj33333ffff3e4r5tyhg5432wdv5|GE_1234hj33333ffff3e4r5tyhg5432wdv5",
    //     "displayOrder":"1",
    //     "businessStripCodes":"100|101",
    //     "address":"浙江省杭州市xxx",
    //     "contactEmployeeCode":"",
    //     "contactNumber":"",
    //     "divisionCode":"30000000000",
    //     "shortName":"",
    //     "institutionCode":"",
    //     "otherName":"",
    //     "postalCode":"",
    //     "remarks":"",
    //     "unifiedSocialCreditCode":"",
    //     "institutionLevelCode":"",
    //     "organizationExtProperties":[
    //         {
    //             "code":"ext_GOV_UNIT_fe789104",
    //                 "type":"3",
    //                 "value":[
    //             "1"
    //                     ]
    //         },
    //         {
    //             "code":"ext_GOV_UNIT_ae789144",
    //                 "type":"2",
    //                 "value":[
    //             "1"
    //                     ]
    //         },
    //         {
    //             "code":"ext_GOV_UNIT_3kr87wj3",
    //                 "type":"0",
    //                 "value":[
    //             "aa"
    //                     ]
    //         }
    //     ]
    // }

    private String typeName;
    private String organizationName;
    private String typeCode;
    private String gmtCreate;
    private String parentName;
    private String parentCode;
    private String organizationCode;
    private String status;
    private String responsibleEmployeeCodes;
    private String displayOrder;
    private String businessStripCodes;
    private String address;
    private String contactEmployeeCode;
    private String contactNumber;
    private String divisionCode;
    private String shortName;
    private String institutionCode;
    private String otherName;
    private String postalCode;
    private String remarks;
    private String unifiedSocialCreditCode;
    private String institutionLevelCode;
    private List<OrganizationExtPropertiesDTO> organizationExtProperties;

    @NoArgsConstructor
    @Data
    public static class OrganizationExtPropertiesDTO {
        private String code;
        private String type;
        private List<String> value;
    }
}
