package com.capgemini.cn.erp.vo;

import java.io.Serializable;

public class DataTemplateItemVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String description;

	private String fieldLength;

	private String fieldName;

	private String fieldTitle;

	private String fieldType;

	private String isAssistAccount;

	private String isCompany;

	private String isEnable;

	private String isMandatory;

	private String isUnique;

	private String mapField;

	private String maskFormat;

	private String rowNo;

	private String isPartner;

	private String isProduct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFieldLength() {
		return fieldLength;
	}

	public void setFieldLength(String fieldLength) {
		this.fieldLength = fieldLength;
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

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getIsAssistAccount() {
		return isAssistAccount;
	}

	public void setIsAssistAccount(String isAssistAccount) {
		this.isAssistAccount = isAssistAccount;
	}

	public String getIsCompany() {
		return isCompany;
	}

	public void setIsCompany(String isCompany) {
		this.isCompany = isCompany;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public String getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

	public String getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(String isUnique) {
		this.isUnique = isUnique;
	}

	public String getMapField() {
		return mapField;
	}

	public void setMapField(String mapField) {
		this.mapField = mapField;
	}

	public String getMaskFormat() {
		return maskFormat;
	}

	public void setMaskFormat(String maskFormat) {
		this.maskFormat = maskFormat;
	}

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getIsPartner() {
		return isPartner;
	}

	public void setIsPartner(String isPartner) {
		this.isPartner = isPartner;
	}

	public String getIsProduct() {
		return isProduct;
	}

	public void setIsProduct(String isProduct) {
		this.isProduct = isProduct;
	}
}
