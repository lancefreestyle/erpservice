package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
public class RuleTitleVo implements Serializable {
    private String id;
    private String systemBusinessTypeId;
    private String dataTemplateId;
    private Timestamp beginDate;
    private Timestamp endDate;
    private Timestamp createDate;
    private Timestamp updateDate;
}
