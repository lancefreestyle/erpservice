package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rule_title", schema = "ubr_service_db1", catalog = "")
public class RuleTitleEntity {
    private String id;
    private String systemBusinessTypeId;
    private String dataTemplateId;
    private Timestamp beginDate;
    private Timestamp endDate;
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

    @Basic
    @Column(name = "system_business_type_id")
    public String getSystemBusinessTypeId() {
        return systemBusinessTypeId;
    }

    public void setSystemBusinessTypeId(String systemBusinessTypeId) {
        this.systemBusinessTypeId = systemBusinessTypeId;
    }

    @Basic
    @Column(name = "data_template_id")
    public String getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(String dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }

    @Basic
    @Column(name = "begin_date")
    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
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
        RuleTitleEntity that = (RuleTitleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(systemBusinessTypeId, that.systemBusinessTypeId) &&
                Objects.equals(dataTemplateId, that.dataTemplateId) &&
                Objects.equals(beginDate, that.beginDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, systemBusinessTypeId, dataTemplateId, beginDate, endDate, createDate, updateDate);
    }
}
