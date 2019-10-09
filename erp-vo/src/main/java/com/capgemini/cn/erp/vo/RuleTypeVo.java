package com.capgemini.cn.erp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleTypeVo implements Serializable {
    private String id;
    private String ruleTypeName;
    private String ruleTypeDesc;
    private Timestamp createDate;
    private Timestamp updateDate;
}
