package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "revenue_share_data", schema = "ubr_service_db1", catalog = "")
public class RevenueShareDataEntity {
    private String id;
    private String revenueShareRuleId;
    private String partnerGroupId;
    private String productGroupId;
    private String partnerGroupItemId;
    private String productGroupItemId;
    private String traceId;
    private BigDecimal traceAmount;
    private BigDecimal settlementAmount;
    private String payType;
    private String batchId;
    private Timestamp importDate;
    private Timestamp traceDate;
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
    @Column(name = "revenue_share_rule_id")
    public String getRevenueShareRuleId() {
        return revenueShareRuleId;
    }

    public void setRevenueShareRuleId(String revenueShareRuleId) {
        this.revenueShareRuleId = revenueShareRuleId;
    }

    @Basic
    @Column(name = "partner_group_id")
    public String getPartnerGroupId() {
        return partnerGroupId;
    }

    public void setPartnerGroupId(String partnerGroupId) {
        this.partnerGroupId = partnerGroupId;
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
    @Column(name = "partner_group_item_id")
    public String getPartnerGroupItemId() {
        return partnerGroupItemId;
    }

    public void setPartnerGroupItemId(String partnerGroupItemId) {
        this.partnerGroupItemId = partnerGroupItemId;
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
    @Column(name = "settlement_amount")
    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
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
    @Column(name = "batch_id")
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    @Basic
    @Column(name = "import_date")
    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    @Basic
    @Column(name = "trace_date")
    public Timestamp getTraceDate() {
        return traceDate;
    }

    public void setTraceDate(Timestamp traceDate) {
        this.traceDate = traceDate;
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
        RevenueShareDataEntity that = (RevenueShareDataEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(revenueShareRuleId, that.revenueShareRuleId) &&
                Objects.equals(partnerGroupId, that.partnerGroupId) &&
                Objects.equals(productGroupId, that.productGroupId) &&
                Objects.equals(partnerGroupItemId, that.partnerGroupItemId) &&
                Objects.equals(productGroupItemId, that.productGroupItemId) &&
                Objects.equals(traceId, that.traceId) &&
                Objects.equals(traceAmount, that.traceAmount) &&
                Objects.equals(settlementAmount, that.settlementAmount) &&
                Objects.equals(payType, that.payType) &&
                Objects.equals(batchId, that.batchId) &&
                Objects.equals(importDate, that.importDate) &&
                Objects.equals(traceDate, that.traceDate) &&
                Objects.equals(settlementAmount, that.settlementAmount) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, revenueShareRuleId, partnerGroupId, productGroupId, partnerGroupItemId, productGroupItemId, traceId, traceAmount, settlementAmount, payType, batchId, importDate, traceDate, updateDate);
    }
}
