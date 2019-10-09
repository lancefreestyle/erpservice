package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the condition_rule database table.
 *
 */
@Entity
@Table(name="condition_rule")
@NamedQuery(name="ConditionRule.findAll", query="SELECT c FROM ConditionRule c")
public class ConditionRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String description;

	private String name;

	private String enabled;

	@Column(name="sys_code")
	private String sysCode;

	@Column(name="sys_name")
	private String sysName;

	@Column(name="template_code")
	private String templateCode;

	@Column(name="template_name")
	private String templateName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to ConditionRuleItem
	@OneToMany(mappedBy="conditionRule", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ConditionRuleItem> conditionRuleItems;

	public ConditionRule() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getSysCode() {
		return this.sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getSysName() {
		return this.sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getTemplateCode() {
		return this.templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<ConditionRuleItem> getConditionRuleItems() {
		return this.conditionRuleItems;
	}

	public void setConditionRuleItems(List<ConditionRuleItem> conditionRuleItems) {
		this.conditionRuleItems = conditionRuleItems;
	}

	public ConditionRuleItem addConditionRuleItem(ConditionRuleItem conditionRuleItem) {
		getConditionRuleItems().add(conditionRuleItem);
		conditionRuleItem.setConditionRule(this);

		return conditionRuleItem;
	}

	public ConditionRuleItem removeConditionRuleItem(ConditionRuleItem conditionRuleItem) {
		getConditionRuleItems().remove(conditionRuleItem);
		conditionRuleItem.setConditionRule(null);

		return conditionRuleItem;
	}

}
