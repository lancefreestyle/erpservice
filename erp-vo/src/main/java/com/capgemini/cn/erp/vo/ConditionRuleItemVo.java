package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ConditionRuleItemVo implements Serializable {
	private String id;
	private String andOr;
	private String calculationId;
	private String compareValue;
	private Date createDate;
	private String judgment;
	private String leftBrackets;
	private String rightBrackets;
	private String sequence;
	private String sourceColumn;
	private Date updateDate;
	private ConditionRuleVo conditionRuleVo;
}
