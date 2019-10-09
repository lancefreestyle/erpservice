package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rule_type", schema = "ubr_service_db1", catalog = "")
public class RuleTypeEntity {
    private String id;
    private String ruleTypeName;
    private String ruleTypeDesc;
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
    @Column(name = "rule_type_name")
    public String getRuleTypeName() {
        return ruleTypeName;
    }

    public void setRuleTypeName(String ruleTypeName) {
        this.ruleTypeName = ruleTypeName;
    }

    @Basic
    @Column(name = "rule_type_desc")
    public String getRuleTypeDesc() {
        return ruleTypeDesc;
    }

    public void setRuleTypeDesc(String ruleTypeDesc) {
        this.ruleTypeDesc = ruleTypeDesc;
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
        RuleTypeEntity that = (RuleTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ruleTypeName, that.ruleTypeName) &&
                Objects.equals(ruleTypeDesc, that.ruleTypeDesc) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ruleTypeName, ruleTypeDesc, createDate, updateDate);
    }
}
