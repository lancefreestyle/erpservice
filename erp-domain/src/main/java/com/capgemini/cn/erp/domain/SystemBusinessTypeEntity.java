package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "system_business_type", schema = "ubr_service_db1")
public class SystemBusinessTypeEntity {
    private String id;

    private SourceSystemEntity sourceSystemEntity;

    private BusinessTypeEntity businessTypeEntity;
    private Timestamp createDate;
    private Timestamp updateDate;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "source_system_id")
    public SourceSystemEntity getSourceSystemEntity() {
        return sourceSystemEntity;
    }

    public void setSourceSystemEntity(SourceSystemEntity sourceSystemEntity) {
        this.sourceSystemEntity = sourceSystemEntity;
    }
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "business_type_id")
    public BusinessTypeEntity getBusinessTypeEntity() {
        return businessTypeEntity;
    }

    public void setBusinessTypeEntity(BusinessTypeEntity businessTypeEntity) {
        this.businessTypeEntity = businessTypeEntity;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemBusinessTypeEntity that = (SystemBusinessTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sourceSystemEntity, that.sourceSystemEntity) &&
                Objects.equals(businessTypeEntity, that.businessTypeEntity) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceSystemEntity, businessTypeEntity, createDate, updateDate);
    }
}
