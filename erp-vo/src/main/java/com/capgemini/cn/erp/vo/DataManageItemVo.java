package com.capgemini.cn.erp.vo;

import java.util.Date;

/**
 * @author jikzhang
 * @version 1.0
 * @className DataManageItemVo
 * @date 2019/7/22 18:14
 * @description 科目预览vo
 */
public class DataManageItemVo {

    private String id;

    /**
     * 科目代码
     */
    private String accountCode;
    /**
     * 记账日期
     */
    private String billDate;

    private String debitNum;

    private String summaryName;

    private String accountName;

    private Date createDate;

    private String creditNum;

    private String clientCode;

    private String supplyCode;

    private String errorLog;

    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getDebitNum() {
        return debitNum;
    }

    public void setDebitNum(String debitNum) {
        this.debitNum = debitNum;
    }

    public String getSummaryName() {
        return summaryName;
    }

    public void setSummaryName(String summaryName) {
        this.summaryName = summaryName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(String creditNum) {
        this.creditNum = creditNum;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
