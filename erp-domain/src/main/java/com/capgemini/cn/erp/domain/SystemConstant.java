package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the system_constant database table.
 *
 */
@Entity
@Table(name="system_constant")
@NamedQuery(name="SystemConstant.findAll", query="SELECT s FROM SystemConstant s")
public class SystemConstant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String systemName;

	private String systemValue;

	public SystemConstant() {
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemValue() {
		return this.systemValue;
	}

	public void setSystemValue(String systemValue) {
		this.systemValue = systemValue;
	}

}
