package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the data_manage database table.
 *
 */
@Entity
@Table(name="data_manage")
@NamedQuery(name="DataManage.findAll", query="SELECT d FROM DataManage d")
public class DataManage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String amount;

	@Column(name="certificate_code")
	private String certificateCode;

	private String company;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="import_batch")
	private String importBatch;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="import_date")
	private Date importDate;

	@Column(name="split_batch_name")
	private String splitBatchName;

	private String status;

	@Column(name="sys_code")
	private String sysCode;

	@Column(name="sys_name")
	private String sysName;

	@Column(name="sys_type")
	private String sysType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to DataManageItem
	@OneToMany(mappedBy="dataManage")
	private List<DataManageItem> dataManageItems;

	public DataManage() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCertificateCode() {
		return this.certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getImportBatch() {
		return this.importBatch;
	}

	public void setImportBatch(String importBatch) {
		this.importBatch = importBatch;
	}

	public Date getImportDate() {
		return this.importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public String getSplitBatchName() {
		return this.splitBatchName;
	}

	public void setSplitBatchName(String splitBatchName) {
		this.splitBatchName = splitBatchName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getSysType() {
		return this.sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<DataManageItem> getDataManageItems() {
		return this.dataManageItems;
	}

	public void setDataManageItems(List<DataManageItem> dataManageItems) {
		this.dataManageItems = dataManageItems;
	}

	public DataManageItem addDataManageItem(DataManageItem dataManageItem) {
		getDataManageItems().add(dataManageItem);
		dataManageItem.setDataManage(this);

		return dataManageItem;
	}

	public DataManageItem removeDataManageItem(DataManageItem dataManageItem) {
		getDataManageItems().remove(dataManageItem);
		dataManageItem.setDataManage(null);

		return dataManageItem;
	}

}
