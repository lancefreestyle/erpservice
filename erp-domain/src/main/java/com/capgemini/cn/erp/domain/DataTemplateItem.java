package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the data_template_item database table.
 *
 */
@Entity
@Table(name="data_template_item")
@NamedQuery(name="DataTemplateItem.findAll", query="SELECT d FROM DataTemplateItem d")
public class DataTemplateItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to DataTemplate
	@ManyToOne
	@JoinColumn(name="templateId")
	private DataTemplate dataTemplate;

	public DataTemplateItem() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFieldLength() {
		return this.fieldLength;
	}

	public void setFieldLength(String fieldLength) {
		this.fieldLength = fieldLength;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldTitle() {
		return this.fieldTitle;
	}

	public void setFieldTitle(String fieldTitle) {
		this.fieldTitle = fieldTitle;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getIsAssistAccount() {
		return this.isAssistAccount;
	}

	public void setIsAssistAccount(String isAssistAccount) {
		this.isAssistAccount = isAssistAccount;
	}

	public String getIsCompany() {
		return this.isCompany;
	}

	public void setIsCompany(String isCompany) {
		this.isCompany = isCompany;
	}

	public String getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public String getIsMandatory() {
		return this.isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

	public String getIsUnique() {
		return this.isUnique;
	}

	public void setIsUnique(String isUnique) {
		this.isUnique = isUnique;
	}

	public String getMapField() {
		return this.mapField;
	}

	public void setMapField(String mapField) {
		this.mapField = mapField;
	}

	public String getMaskFormat() {
		return this.maskFormat;
	}

	public void setMaskFormat(String maskFormat) {
		this.maskFormat = maskFormat;
	}

	public String getRowNo() {
		return this.rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public DataTemplate getDataTemplate() {
		return this.dataTemplate;
	}

	public void setDataTemplate(DataTemplate dataTemplate) {
		this.dataTemplate = dataTemplate;
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
