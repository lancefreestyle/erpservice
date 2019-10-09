package com.capgemini.cn.erp.vo;

import java.util.List;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
public class ReconciliationRuleVo {

    private String id;

    private String ruleCode;

    private String description;

    private String sysCode;

    private String sysName;

    private String templateCode;

    private String templateName;

    private List<ReconciliationRuleItemVo> itemVos;

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

    public List<ReconciliationRuleItemVo> getItemVos() {
        return itemVos;
    }

    public void setItemVos(List<ReconciliationRuleItemVo> itemVos) {
        this.itemVos = itemVos;
    }
}
