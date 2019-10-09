package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "accounting_share_rule", schema = "ubr_service_db1", catalog = "")
public class AccountingShareRuleEntity {
    private String id;
    private String ruleTitleId;
    private String ruleTypeId;
    private String shareType;
    private Timestamp beginDate;
    private Timestamp endDate;
    private Integer dateFreq;
    private String freqType;
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
    @Column(name = "share_type")
    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
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
    @Column(name = "date_freq")
    public Integer getDateFreq() {
        return dateFreq;
    }

    public void setDateFreq(Integer dateFreq) {
        this.dateFreq = dateFreq;
    }

    @Basic
    @Column(name = "freq_type")
    public String getFreqType() {
        return freqType;
    }

    public void setFreqType(String freqType) {
        this.freqType = freqType;
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
        AccountingShareRuleEntity that = (AccountingShareRuleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ruleTitleId, that.ruleTitleId) &&
                Objects.equals(ruleTypeId, that.ruleTypeId) &&
                Objects.equals(shareType, that.shareType) &&
                Objects.equals(beginDate, that.beginDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(dateFreq, that.dateFreq) &&
                Objects.equals(freqType, that.freqType) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ruleTitleId, ruleTypeId, shareType, beginDate, endDate, dateFreq, freqType, createDate, updateDate);
    }
}
