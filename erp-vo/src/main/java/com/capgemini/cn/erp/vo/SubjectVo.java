package com.capgemini.cn.erp.vo;

import java.io.Serializable;
import java.util.List;

public class SubjectVo implements Serializable {

    private String id;

    private String code;

    private String description;

    private boolean enabled = true;

    private String name;

    private String sysCode;

    private String sysName;

    private String templateCode;

    private String templateName;

    private List<SubjectItemVo> items;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

	public List<SubjectItemVo> getItems() {
		return items;
	}

	public void setItems(List<SubjectItemVo> items) {
		this.items = items;
	}
}
