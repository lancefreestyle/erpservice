package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "revenue_sale_data", schema = "ubr_service_db1", catalog = "")
public class RevenueSaleDataEntity {
    private String id;
    private String systemBusinessTypeId;
    private Object status;
    private String productGroupId;
    private String productGroupItemId;
    private String traceId;
    private BigDecimal traceAmount;
    private BigDecimal calculatedAmount;
    private BigDecimal calculatAmount;
    private int sharedCount;
    private int shareCount;
    private String payType;
    private String businessDepartment;
    private String profitCenter;
    private Timestamp traceBeginDate;
    private Timestamp traceEndDate;
    private Timestamp tallyBeginDate;
    private Timestamp tallyEndDate;
    private Timestamp createDate;
    private Timestamp updateDate;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "system_business_type_id")
    public String getSystemBusinessTypeId() {
        return systemBusinessTypeId;
    }

    public void setSystemBusinessTypeId(String systemBusinessTypeId) {
        this.systemBusinessTypeId = systemBusinessTypeId;
    }

    @Basic
    @Column(name = "status")
    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    @Basic
    @Column(name = "product_group_id")
    public String getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(String productGroupId) {
        this.productGroupId = productGroupId;
    }

    @Basic
    @Column(name = "product_group_item_id")
    public String getProductGroupItemId() {
        return productGroupItemId;
    }

    public void setProductGroupItemId(String productGroupItemId) {
        this.productGroupItemId = productGroupItemId;
    }

    @Basic
    @Column(name = "trace_id")
    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Basic
    @Column(name = "trace_amount")
    public BigDecimal getTraceAmount() {
        return traceAmount;
    }

    public void setTraceAmount(BigDecimal traceAmount) {
        this.traceAmount = traceAmount;
    }

    @Basic
    @Column(name = "calculated_amount")
    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(BigDecimal calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    @Basic
    @Column(name = "calculat_amount")
    public BigDecimal getCalculatAmount() {
        return calculatAmount;
    }

    public void setCalculatAmount(BigDecimal calculatAmount) {
        this.calculatAmount = calculatAmount;
    }

    @Basic
    @Column(name = "shared_count")
    public int getSharedCount() {
        return sharedCount;
    }

    public void setSharedCount(int sharedCount) {
        this.sharedCount = sharedCount;
    }

    @Basic
    @Column(name = "share_count")
    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    @Basic
    @Column(name = "pay_type")
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "business_department")
    public String getBusinessDepartment() {
        return businessDepartment;
    }

    public void setBusinessDepartment(String businessDepartment) {
        this.businessDepartment = businessDepartment;
    }

    @Basic
    @Column(name = "profit_center")
    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
        this.profitCenter = profitCenter;
    }

    @Basic
    @Column(name = "trace_begin_date")
    public Timestamp getTraceBeginDate() {
        return traceBeginDate;
    }

    public void setTraceBeginDate(Timestamp traceBeginDate) {
        this.traceBeginDate = traceBeginDate;
    }

    @Basic
    @Column(name = "trace_end_date")
    public Timestamp getTraceEndDate() {
        return traceEndDate;
    }

    public void setTraceEndDate(Timestamp traceEndDate) {
        this.traceEndDate = traceEndDate;
    }

    @Basic
    @Column(name = "tally_begin_date")
    public Timestamp getTallyBeginDate() {
        return tallyBeginDate;
    }

    public void setTallyBeginDate(Timestamp tallyBeginDate) {
        this.tallyBeginDate = tallyBeginDate;
    }

    @Basic
    @Column(name = "tally_end_date")
    public Timestamp getTallyEndDate() {
        return tallyEndDate;
    }

    public void setTallyEndDate(Timestamp tallyEndDate) {
        this.tallyEndDate = tallyEndDate;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevenueSaleDataEntity that = (RevenueSaleDataEntity) o;
        return sharedCount == that.sharedCount &&
                shareCount == that.shareCount &&
                Objects.equals(id, that.id) &&
                Objects.equals(systemBusinessTypeId, that.systemBusinessTypeId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(productGroupId, that.productGroupId) &&
                Objects.equals(productGroupItemId, that.productGroupItemId) &&
                Objects.equals(traceId, that.traceId) &&
                Objects.equals(traceAmount, that.traceAmount) &&
                Objects.equals(calculatedAmount, that.calculatedAmount) &&
                Objects.equals(calculatAmount, that.calculatAmount) &&
                Objects.equals(payType, that.payType) &&
                Objects.equals(businessDepartment, that.businessDepartment) &&
                Objects.equals(profitCenter, that.profitCenter) &&
                Objects.equals(traceBeginDate, that.traceBeginDate) &&
                Objects.equals(traceEndDate, that.traceEndDate) &&
                Objects.equals(tallyBeginDate, that.tallyBeginDate) &&
                Objects.equals(tallyEndDate, that.tallyEndDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, systemBusinessTypeId, status, productGroupId, productGroupItemId, traceId, traceAmount, calculatedAmount, calculatAmount, sharedCount, shareCount, payType, businessDepartment, profitCenter, traceBeginDate, traceEndDate, tallyBeginDate, tallyEndDate, createDate, updateDate);
    }
}
