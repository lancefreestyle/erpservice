package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceSystemVo implements Serializable {
    private String id;
    private String sourceSystemCode;
    private String sourceSystemName;
    private Timestamp createDate;
    private Timestamp updateDate;
}
