package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
public class SystemBusinessTypeVo implements Serializable{
    private String id;
    private String sourceSystemId;
    private String businessTypeId;
    private Timestamp createDate;
    private Timestamp updateDate;
}
