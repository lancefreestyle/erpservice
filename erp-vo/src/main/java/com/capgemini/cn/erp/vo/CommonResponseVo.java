package com.capgemini.cn.erp.vo;

import java.io.Serializable;

public class CommonResponseVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
