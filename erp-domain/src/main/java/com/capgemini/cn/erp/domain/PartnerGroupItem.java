package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
@Entity
@Table(name="partner_group_item")
@NamedQuery(name="PartnerGroupItem.findAll", query="SELECT p FROM PartnerGroupItem p")
public class PartnerGroupItem {

    @Id
    private String id;

    @Column(name="partner_name")
    private String partnerName;

    @Column(name="partner_number")

    private String partnerNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name="partner_group_id")
    private PartnerGroup partnerGroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerNumber() {
        return partnerNumber;
    }

    public void setPartnerNumber(String partnerNumber) {
        this.partnerNumber = partnerNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public PartnerGroup getPartnerGroup() {
        return partnerGroup;
    }

    public void setPartnerGroup(PartnerGroup partnerGroup) {
        this.partnerGroup = partnerGroup;
    }
}
