package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class SourceSystemVo implements Serializable {
    private String id;
    private String sourceSystemCode;
    private String sourceSystemName;
    private Timestamp createDate;
    private Timestamp updateDate;
}
