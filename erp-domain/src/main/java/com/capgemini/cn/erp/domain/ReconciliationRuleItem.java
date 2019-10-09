package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
@Entity
@Table(name="reconciliation_rule_item")
@NamedQuery(name="ReconciliationRuleItem.findAll", query="SELECT r FROM ReconciliationRuleItem r")
public class ReconciliationRuleItem {

    @Id
    private String id;

    @Column(name="field_name")
    private String fieldName;

    @Column(name="field_title")
    private String fieldTitle;

    @Column(name="filed_type")
    private String filedType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name="reconciliation_rule_id")
    private ReconciliationRule reconciliationRule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public void setFieldTitle(String fieldTitle) {
        this.fieldTitle = fieldTitle;
    }

    public String getFiledType() {
        return filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public ReconciliationRule getReconciliationRule() {
        return reconciliationRule;
    }

    public void setReconciliationRule(ReconciliationRule reconciliationRule) {
        this.reconciliationRule = reconciliationRule;
    }
}
