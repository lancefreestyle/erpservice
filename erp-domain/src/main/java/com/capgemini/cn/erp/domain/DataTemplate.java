package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the data_template database table.
 *
 */
@Entity
@Table(name="data_template")
@NamedQuery(name="DataTemplate.findAll", query="SELECT d FROM DataTemplate d")
public class DataTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String allowDuplicateImport;

	private String autoComputer;

	private String autoCreditImport;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String islock;

	private String sysCode;

	private String sysName;

	private String templateCode;

	private String templateName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to DataTemplateItem
	@OneToMany(mappedBy="dataTemplate",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DataTemplateItem> dataTemplateItems;

	public DataTemplate() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAllowDuplicateImport() {
		return this.allowDuplicateImport;
	}

	public void setAllowDuplicateImport(String allowDuplicateImport) {
		this.allowDuplicateImport = allowDuplicateImport;
	}

	public String getAutoComputer() {
		return this.autoComputer;
	}

	public void setAutoComputer(String autoComputer) {
		this.autoComputer = autoComputer;
	}

	public String getAutoCreditImport() {
		return this.autoCreditImport;
	}

	public void setAutoCreditImport(String autoCreditImport) {
		this.autoCreditImport = autoCreditImport;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIslock() {
		return this.islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
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

	public List<DataTemplateItem> getDataTemplateItems() {
		return this.dataTemplateItems;
	}

	public void setDataTemplateItems(List<DataTemplateItem> dataTemplateItems) {
		this.dataTemplateItems = dataTemplateItems;
	}

	public DataTemplateItem addDataTemplateItem(DataTemplateItem dataTemplateItem) {
		getDataTemplateItems().add(dataTemplateItem);
		dataTemplateItem.setDataTemplate(this);

		return dataTemplateItem;
	}

	public DataTemplateItem removeDataTemplateItem(DataTemplateItem dataTemplateItem) {
		getDataTemplateItems().remove(dataTemplateItem);
		dataTemplateItem.setDataTemplate(null);

		return dataTemplateItem;
	}

}
