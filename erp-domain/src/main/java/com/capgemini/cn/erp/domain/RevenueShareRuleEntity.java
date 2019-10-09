package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "revenue_share_rule", schema = "ubr_service_db1", catalog = "")
public class RevenueShareRuleEntity {
    private String id;
    private String ruleTitleId;
    private String ruleTypeId;
    private String conditionRuleId;
    private String amountCalculationId;
    private String partnerGroupId;
    private String productGroupId;
    private Object settlementPeriod;
    private Object autoClear;
    private Object autoOffset;
    private String remark;
    private Timestamp beginDate;
    private Timestamp endDate;
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
    @Column(name = "rule_title_id")
    public String getRuleTitleId() {
        return ruleTitleId;
    }

    public void setRuleTitleId(String ruleTitleId) {
        this.ruleTitleId = ruleTitleId;
    }

    @Basic
    @Column(name = "rule_type_id")
    public String getRuleTypeId() {
        return ruleTypeId;
    }

    public void setRuleTypeId(String ruleTypeId) {
        this.ruleTypeId = ruleTypeId;
    }

    @Basic
    @Column(name = "condition_rule_id")
    public String getConditionRuleId() {
        return conditionRuleId;
    }

    public void setConditionRuleId(String conditionRuleId) {
        this.conditionRuleId = conditionRuleId;
    }

    @Basic
    @Column(name = "amount_calculation_id")
    public String getAmountCalculationId() {
        return amountCalculationId;
    }

    public void setAmountCalculationId(String amountCalculationId) {
        this.amountCalculationId = amountCalculationId;
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
    @Column(name = "settlement_period")
    public Object getSettlementPeriod() {
        return settlementPeriod;
    }

    public void setSettlementPeriod(Object settlementPeriod) {
        this.settlementPeriod = settlementPeriod;
    }

    @Basic
    @Column(name = "auto_clear")
    public Object getAutoClear() {
        return autoClear;
    }

    public void setAutoClear(Object autoClear) {
        this.autoClear = autoClear;
    }

    @Basic
    @Column(name = "auto_offset")
    public Object getAutoOffset() {
        return autoOffset;
    }

    public void setAutoOffset(Object autoOffset) {
        this.autoOffset = autoOffset;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "begin_date")
    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
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
        RevenueShareRuleEntity that = (RevenueShareRuleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ruleTitleId, that.ruleTitleId) &&
                Objects.equals(ruleTypeId, that.ruleTypeId) &&
                Objects.equals(conditionRuleId, that.conditionRuleId) &&
                Objects.equals(amountCalculationId, that.amountCalculationId) &&
                Objects.equals(partnerGroupId, that.partnerGroupId) &&
                Objects.equals(productGroupId, that.productGroupId) &&
                Objects.equals(settlementPeriod, that.settlementPeriod) &&
                Objects.equals(autoClear, that.autoClear) &&
                Objects.equals(autoOffset, that.autoOffset) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(beginDate, that.beginDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ruleTitleId, ruleTypeId, conditionRuleId, amountCalculationId, partnerGroupId, productGroupId, settlementPeriod, autoClear, autoOffset, remark, beginDate, endDate, createDate, updateDate);
    }
}
