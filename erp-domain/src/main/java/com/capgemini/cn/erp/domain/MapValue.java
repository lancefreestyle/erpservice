package com.capgemini.cn.erp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the map_value database table.
 *
 */
@Entity
@Table(name="map_value")
@NamedQuery(name="MapValue.findAll", query="SELECT m FROM MapValue m")
public class MapValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	//bi-directional many-to-one association to MapStructure
	@ManyToOne
	@JoinColumn(name="structure_id")
	private MapStructure mapStructure;

	public MapValue() {
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

	public MapStructure getMapStructure() {
		return this.mapStructure;
	}

	public void setMapStructure(MapStructure mapStructure) {
		this.mapStructure = mapStructure;
	}

}
