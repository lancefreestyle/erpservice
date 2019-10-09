package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleTitleVo implements Serializable {
    private String id;
    private SystemBusinessTypeVo systemBusinessTypeVo;
    private DataTemplateVo dataTemplateVo;
    private Timestamp beginDate;
    private Timestamp endDate;
    private Timestamp createDate;
    private Timestamp updateDate;
}
