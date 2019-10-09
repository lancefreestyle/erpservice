package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the engine_setting database table.
 *
 */
@Entity
@Table(name="engine_setting")
@NamedQuery(name="EngineSetting.findAll", query="SELECT e FROM EngineSetting e")
public class EngineSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enableDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date invalidDate;

	private String name;

	private String sysCode;

	private String sysName;

	private String templateCode;

	private String templateName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to EngineSettingItem
	@OneToMany(mappedBy="engineSetting", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EngineSettingItem> engineSettingItems;

	public EngineSetting() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getEnableDate() {
		return this.enableDate;
	}

	public void setEnableDate(Date enableDate) {
		this.enableDate = enableDate;
	}

	public Date getInvalidDate() {
		return this.invalidDate;
	}

	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
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

	public List<EngineSettingItem> getEngineSettingItems() {
		return this.engineSettingItems;
	}

	public void setEngineSettingItems(List<EngineSettingItem> engineSettingItems) {
		this.engineSettingItems = engineSettingItems;
	}

	public EngineSettingItem addEngineSettingItem(EngineSettingItem engineSettingItem) {
		getEngineSettingItems().add(engineSettingItem);
		engineSettingItem.setEngineSetting(this);

		return engineSettingItem;
	}

	public EngineSettingItem removeEngineSettingItem(EngineSettingItem engineSettingItem) {
		getEngineSettingItems().remove(engineSettingItem);
		engineSettingItem.setEngineSetting(null);

		return engineSettingItem;
	}

}
