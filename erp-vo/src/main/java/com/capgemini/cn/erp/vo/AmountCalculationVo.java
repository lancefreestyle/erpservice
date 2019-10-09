package com.capgemini.cn.erp.vo;

import java.io.Serializable;
import java.util.List;

public class AmountCalculationVo implements Serializable {

    private String id;

    private String name;

    private String description;

    private boolean enabled = true;

    private String sysCode;

    private String sysName;

    private String templateCode;

    private String templateName;

    private List<AmountCalculationItemVo> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public List<AmountCalculationItemVo> getItems() {
        return items;
    }

    public void setItems(List<AmountCalculationItemVo> items) {
        this.items = items;
    }
}
