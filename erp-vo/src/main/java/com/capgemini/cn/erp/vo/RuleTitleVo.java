package com.capgemini.cn.erp.vo;

import io.undertow.util.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleTitleVo implements Serializable {
    private String id;
    private SystemBusinessTypeVo systemBusinessTypeVo;
    private DataTemplateVo dataTemplateVo;
    private String beginDate;
    private String endDate;
    private Timestamp createDate;
    private Timestamp updateDate;
}
