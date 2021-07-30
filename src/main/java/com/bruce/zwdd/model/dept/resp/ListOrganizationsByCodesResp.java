package com.bruce.zwdd.model.dept.resp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/10 12:37
 * @Author fzh
 */
@Data
public class ListOrganizationsByCodesResp implements Serializable {

    private String creator;
    private String gmtModified;
    private String typeName;
    private String organizationName;
    private String modifier;
    private String typeCode;
    private Integer displayOrder;
    private String gmtCreate;
    private String parentName;
    private String parentCode;
    private String organizationCode;
    private String status;
    private String responsibleEmployeeCodes;
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

    @Data
    public static class OrganizationExtPropertiesDTO {
        private String code;
        private String type;
        private List<String> value;
    }
}
