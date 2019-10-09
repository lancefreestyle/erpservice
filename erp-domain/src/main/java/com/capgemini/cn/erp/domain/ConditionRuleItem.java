package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the condition_rule_item database table.
 *
 */
@Entity
@Table(name="condition_rule_item")
@NamedQuery(name="ConditionRuleItem.findAll", query="SELECT c FROM ConditionRuleItem c")
public class ConditionRuleItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="and_or")
	private String andOr;

	@Column(name="calculation_id")
	private String calculationId;

	@Column(name="compare_value")
	private String compareValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String judgment;

	@Column(name="left_brackets")
	private String leftBrackets;

	@Column(name="right_brackets")
	private String rightBrackets;

	private String sequence;

	@Column(name="source_column")
	private String sourceColumn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to ConditionRule
	@ManyToOne
	@JoinColumn(name="condition_id")
	private ConditionRule conditionRule;

	public ConditionRuleItem() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAndOr() {
		return this.andOr;
	}

	public void setAndOr(String andOr) {
		this.andOr = andOr;
	}

	public String getCalculationId() {
		return this.calculationId;
	}

	public void setCalculationId(String calculationId) {
		this.calculationId = calculationId;
	}

	public String getCompareValue() {
		return this.compareValue;
	}

	public void setCompareValue(String compareValue) {
		this.compareValue = compareValue;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getJudgment() {
		return this.judgment;
	}

	public void setJudgment(String judgment) {
		this.judgment = judgment;
	}

	public String getLeftBrackets() {
		return this.leftBrackets;
	}

	public void setLeftBrackets(String leftBrackets) {
		this.leftBrackets = leftBrackets;
	}

	public String getRightBrackets() {
		return this.rightBrackets;
	}

	public void setRightBrackets(String rightBrackets) {
		this.rightBrackets = rightBrackets;
	}

	public String getSequence() {
		return this.sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getSourceColumn() {
		return this.sourceColumn;
	}

	public void setSourceColumn(String sourceColumn) {
		this.sourceColumn = sourceColumn;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public ConditionRule getConditionRule() {
		return this.conditionRule;
	}

	public void setConditionRule(ConditionRule conditionRule) {
		this.conditionRule = conditionRule;
	}

}
