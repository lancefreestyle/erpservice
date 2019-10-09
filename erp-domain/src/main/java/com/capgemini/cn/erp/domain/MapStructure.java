package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the map_structure database table.
 *
 */
@Entity
@Table(name="map_structure")
@NamedQuery(name="MapStructure.findAll", query="SELECT m FROM MapStructure m")
public class MapStructure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String name;

	private String templateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to MapValue
	@OneToMany(mappedBy="mapStructure")
	private List<MapValue> mapValues;

	public MapStructure() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<MapValue> getMapValues() {
		return this.mapValues;
	}

	public void setMapValues(List<MapValue> mapValues) {
		this.mapValues = mapValues;
	}

	public MapValue addMapValue(MapValue mapValue) {
		getMapValues().add(mapValue);
		mapValue.setMapStructure(this);

		return mapValue;
	}

	public MapValue removeMapValue(MapValue mapValue) {
		getMapValues().remove(mapValue);
		mapValue.setMapStructure(null);

		return mapValue;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
}
