package com.bruce.zwdd.model.user.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 13:53
 * @Author fzh
 */
@NoArgsConstructor
@Data
public class GetEmployeeByCodeResp {


    // {
    //     "employeeName": "罗小丫",
    //         "gmtCreate": "2019-10-24 14:00:38",
    //         "status": "A",
    //         "employeeCode": "GE_b5ec29b8c869419db1ac3fbba71983fb",
    //         "empGender": "2",
    //         "govEmpRemarks":"备注",
    //         "govEmpAvatar":"fasdfqw3id",
    //         "empJobLevelCode":"",
    //         "empBudgetedPostCode":"",
    //         "empPoliticalStatusCode":"",
    //         "positionExtProperties":[
    //     {
    //         "code":"ext_EMPLOYEE_fe789104",
    //             "type":"3",
    //             "value":[
    //         "1"
    //                 ]
    //     },
    //     {
    //         "code":"ext_EMPLOYEE_ae789144",
    //             "type":"2",
    //             "value":[
    //         "1"
    //                 ]
    //     },
    //     {
    //         "code":"ext_EMPLOYEE_3kr87wj3",
    //             "type":"0",
    //             "value":[
    //         "aa"
    //                 ]
    //     }
    //         ]
    // }

    private String employeeName;
    private String gmtCreate;
    private String status;
    private String employeeCode;
    private String empGender;
    private String govEmpRemarks;
    private String govEmpAvatar;
    private String empJobLevelCode;
    private String empBudgetedPostCode;
    private String empPoliticalStatusCode;
    private List<PositionExtPropertiesDTO> positionExtProperties;

    @NoArgsConstructor
    @Data
    public static class PositionExtPropertiesDTO {
        private String code;
        private String type;
        private List<String> value;
    }
}
