package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the amount_calculation_item database table.
 *
 */
@Entity
@Table(name="amount_calculation_item")
@NamedQuery(name="AmountCalculationItem.findAll", query="SELECT a FROM AmountCalculationItem a")
public class AmountCalculationItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="constant_value")
	private String constantValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String operator;

	@Column(name="source_column_lower")
	private String sourceColumnLower;

	@Column(name="source_column_upper")
	private String sourceColumnUpper;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to AmountCalculation
	@ManyToOne
	@JoinColumn(name="amount_calculation_id")
	private AmountCalculation amountCalculation;

	public AmountCalculationItem() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConstantValue() {
		return this.constantValue;
	}

	public void setConstantValue(String constantValue) {
		this.constantValue = constantValue;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getSourceColumnLower() {
		return this.sourceColumnLower;
	}

	public void setSourceColumnLower(String sourceColumnLower) {
		this.sourceColumnLower = sourceColumnLower;
	}

	public String getSourceColumnUpper() {
		return this.sourceColumnUpper;
	}

	public void setSourceColumnUpper(String sourceColumnUpper) {
		this.sourceColumnUpper = sourceColumnUpper;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public AmountCalculation getAmountCalculation() {
		return this.amountCalculation;
	}

	public void setAmountCalculation(AmountCalculation amountCalculation) {
		this.amountCalculation = amountCalculation;
	}

}
