package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
@Entity
@Table(name="reconciliation_rule")
@NamedQuery(name="ReconciliationRule.findAll", query="SELECT r FROM ReconciliationRule r")
public class ReconciliationRule {

    @Id
    private String id;

    @Column(name="rule_code")
    private String ruleCode;

    private String description;

    @Column(name="sys_code")
    private String sysCode;

    @Column(name="sys_name")
    private String sysName;

    @Column(name="template_code")
    private String templateCode;

    @Column(name="template_name")
    private String templateName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @OneToMany(mappedBy="reconciliationRule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReconciliationRuleItem> reconciliationRuleItem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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

    public List<ReconciliationRuleItem> getReconciliationRuleItem() {
        return reconciliationRuleItem;
    }

    public void setReconciliationRuleItem(List<ReconciliationRuleItem> reconciliationRuleItem) {
        this.reconciliationRuleItem = reconciliationRuleItem;
    }

    public ReconciliationRuleItem addReconciliationRuleItem(ReconciliationRuleItem reconciliationRuleItem) {
        getReconciliationRuleItem().add(reconciliationRuleItem);
        reconciliationRuleItem.setReconciliationRule(this);
        return reconciliationRuleItem;
    }
}
