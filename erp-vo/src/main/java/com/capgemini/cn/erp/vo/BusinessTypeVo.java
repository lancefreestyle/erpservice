package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTypeVo implements Serializable {
    private String id;
    private String businessTypeCode;
    private String businessTypeName;
    private Timestamp createDate;
    private Timestamp updateDate;
}
