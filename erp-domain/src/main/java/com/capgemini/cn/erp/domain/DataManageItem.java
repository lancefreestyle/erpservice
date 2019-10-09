package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the data_manage_item database table.
 *
 */
@Entity
@Table(name="data_manage_item")
@NamedQuery(name="DataManageItem.findAll", query="SELECT d FROM DataManageItem d")
public class DataManageItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="account_code")
	private String accountCode;

	@Column(name="account_name")
	private String accountName;

	@Column(name="bill_date")
	private String billDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="credit_num")
	private String creditNum;

	@Column(name="debit_num")
	private String debitNum;

	@Column(name="summary_name")
	private String summaryName;

	@Column(name="client_code")
	private String clientCode;

	@Column(name="supply_code")
	private String supplyCode;

	@Column(name="error_log")
	private String errorLog;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to DataManage
	@ManyToOne
	@JoinColumn(name="data_manage_id")
	private DataManage dataManage;

	public DataManageItem() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountCode() {
		return this.accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getBillDate() {
		return this.billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreditNum() {
		return this.creditNum;
	}

	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}

	public String getDebitNum() {
		return debitNum;
	}

	public void setDebitNum(String debitNum) {
		this.debitNum = debitNum;
	}

	public String getSummaryName() {
		return this.summaryName;
	}

	public void setSummaryName(String summaryName) {
		this.summaryName = summaryName;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public DataManage getDataManage() {
		return this.dataManage;
	}

	public void setDataManage(DataManage dataManage) {
		this.dataManage = dataManage;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getSupplyCode() {
		return supplyCode;
	}

	public void setSupplyCode(String supplyCode) {
		this.supplyCode = supplyCode;
	}

	public String getErrorLog() {
		return errorLog;
	}

	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
