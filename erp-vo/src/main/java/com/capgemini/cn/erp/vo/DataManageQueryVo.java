package com.capgemini.cn.erp.vo;

import java.io.Serializable;

public class DataManageQueryVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sysCode;
	private String templateCode;
	private Integer page;
	private Integer size;

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
