package com.capgemini.cn.erp.vo;

import java.io.Serializable;
import java.util.List;

public class EngineSettingVo implements Serializable {

    private String id;

    private String name;

    private String description;

    private String enableDate;

    private String invalidDate;

    private String sysCode;

    private String sysName;

    private String templateCode;

    private String templateName;

    private List<EngineSettingItemVo> items;

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

    public String getEnableDate() {
        return enableDate;
    }

    public void setEnableDate(String enableDate) {
        this.enableDate = enableDate;
    }

    public String getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(String invalidDate) {
        this.invalidDate = invalidDate;
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

    public List<EngineSettingItemVo> getItems() {
        return items;
    }

    public void setItems(List<EngineSettingItemVo> items) {
        this.items = items;
    }
}
