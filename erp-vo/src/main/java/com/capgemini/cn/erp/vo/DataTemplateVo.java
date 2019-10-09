package com.capgemini.cn.erp.vo;

import java.io.Serializable;
import java.util.List;

public class DataTemplateVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;

	private String allowDuplicateImport;

	private String autoComputer;

	private String autoCreditImport;

	private String islock;

	private String sysCode;

	private String sysName;

	private String templateCode;

	private String templateName;

	//bi-directional many-to-one association to DataTemplateItem
	private List<DataTemplateItemVo> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAllowDuplicateImport() {
		return allowDuplicateImport;
	}

	public void setAllowDuplicateImport(String allowDuplicateImport) {
		this.allowDuplicateImport = allowDuplicateImport;
	}

	public String getAutoComputer() {
		return autoComputer;
	}

	public void setAutoComputer(String autoComputer) {
		this.autoComputer = autoComputer;
	}

	public String getAutoCreditImport() {
		return autoCreditImport;
	}

	public void setAutoCreditImport(String autoCreditImport) {
		this.autoCreditImport = autoCreditImport;
	}

	public String getIslock() {
		return islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
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

	public List<DataTemplateItemVo> getItems() {
		return items;
	}

	public void setItems(List<DataTemplateItemVo> items) {
		this.items = items;
	}
}
