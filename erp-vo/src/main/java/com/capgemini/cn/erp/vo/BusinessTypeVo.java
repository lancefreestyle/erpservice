package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
public class BusinessTypeVo implements Serializable {
    private String id;
    private String businessTypeCode;
    private String businessTypeName;
    private Timestamp createDate;
    private Timestamp updateDate;
}
