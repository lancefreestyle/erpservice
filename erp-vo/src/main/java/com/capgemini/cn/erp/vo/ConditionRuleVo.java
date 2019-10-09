package com.capgemini.cn.erp.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ConditionRuleVo implements Serializable {
	private String id;
	private String code;
	private Date createDate;
	private String description;
	private String name;
	private String enabled;
	private String sysCode;
	private String sysName;
	private String templateCode;
	private String templateName;
	private Date updateDate;
	private List<ConditionRuleItemVo> conditionRuleItemVos;
}
