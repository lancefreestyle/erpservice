package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the summary_item database table.
 *
 */
@Entity
@Table(name="summary_item")
@NamedQuery(name="SummaryItem.findAll", query="SELECT s FROM SummaryItem s")
public class SummaryItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="constant_value")
	private String constantValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="mapping_structure_id")
	private String mappingStructureId;

	@Column(name="mapping_structure_name")
	private String mappingStructureName;

	@Column(name="mapping_value")
	private String mappingValue;

	@Column(name="source_type")
	private String sourceType;

	@Column(name="source_value")
	private String sourceValue;

	private String splice;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to Summary
	@ManyToOne
	@JoinColumn(name="summary_id")
	private Summary summary;

	public SummaryItem() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConstantValue() {
		return this.constantValue;
	}

	public void setConstantValue(String constantValue) {
		this.constantValue = constantValue;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMappingStructureId() {
		return this.mappingStructureId;
	}

	public void setMappingStructureId(String mappingStructureId) {
		this.mappingStructureId = mappingStructureId;
	}

	public String getMappingStructureName() {
		return this.mappingStructureName;
	}

	public void setMappingStructureName(String mappingStructureName) {
		this.mappingStructureName = mappingStructureName;
	}

	public String getMappingValue() {
		return this.mappingValue;
	}

	public void setMappingValue(String mappingValue) {
		this.mappingValue = mappingValue;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceValue() {
		return this.sourceValue;
	}

	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}

	public String getSplice() {
		return this.splice;
	}

	public void setSplice(String splice) {
		this.splice = splice;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Summary getSummary() {
		return this.summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

}
