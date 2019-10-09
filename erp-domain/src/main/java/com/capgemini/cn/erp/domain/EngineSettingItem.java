package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the engine_setting_item database table.
 *
 */
@Entity
@Table(name="engine_setting_item")
@NamedQuery(name="EngineSettingItem.findAll", query="SELECT e FROM EngineSettingItem e")
public class EngineSettingItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String calculationId;

	private String collectName;

	private String conditionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String enabled;

	private String groupName;

	private String loan;

	private String remark;

	private String subjectId;

	private String summaryId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to EngineSetting
	@ManyToOne
	@JoinColumn(name="engineId")
	private EngineSetting engineSetting;

	public EngineSettingItem() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCalculationId() {
		return this.calculationId;
	}

	public void setCalculationId(String calculationId) {
		this.calculationId = calculationId;
	}

	public String getCollectName() {
		return this.collectName;
	}

	public void setCollectName(String collectName) {
		this.collectName = collectName;
	}

	public String getConditionId() {
		return this.conditionId;
	}

	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getLoan() {
		return this.loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSummaryId() {
		return this.summaryId;
	}

	public void setSummaryId(String summaryId) {
		this.summaryId = summaryId;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public EngineSetting getEngineSetting() {
		return this.engineSetting;
	}

	public void setEngineSetting(EngineSetting engineSetting) {
		this.engineSetting = engineSetting;
	}

}
