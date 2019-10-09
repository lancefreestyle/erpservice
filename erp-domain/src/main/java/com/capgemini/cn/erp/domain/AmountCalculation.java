package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the amount_calculation database table.
 *
 */
@Entity
@Table(name="amount_calculation")
@NamedQuery(name="AmountCalculation.findAll", query="SELECT a FROM AmountCalculation a")
public class AmountCalculation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String description;

	private String enabled;

	private String name;

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

	//bi-directional many-to-one association to AmountCalculationItem
	@OneToMany(mappedBy="amountCalculation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AmountCalculationItem> amountCalculationItems;

	public AmountCalculation() {
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

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<AmountCalculationItem> getAmountCalculationItems() {
		return this.amountCalculationItems;
	}

	public void setAmountCalculationItems(List<AmountCalculationItem> amountCalculationItems) {
		this.amountCalculationItems = amountCalculationItems;
	}

	public AmountCalculationItem addAmountCalculationItem(AmountCalculationItem amountCalculationItem) {
		getAmountCalculationItems().add(amountCalculationItem);
		amountCalculationItem.setAmountCalculation(this);

		return amountCalculationItem;
	}

	public AmountCalculationItem removeAmountCalculationItem(AmountCalculationItem amountCalculationItem) {
		getAmountCalculationItems().remove(amountCalculationItem);
		amountCalculationItem.setAmountCalculation(null);

		return amountCalculationItem;
	}

}
