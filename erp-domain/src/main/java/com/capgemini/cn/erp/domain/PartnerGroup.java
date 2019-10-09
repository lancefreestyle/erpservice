package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
@Entity
@Table(name="partner_group")
@NamedQuery(name="PartnerGroup.findAll", query="SELECT p FROM PartnerGroup p")
public class PartnerGroup {

    @Id
    private String id;

    @Column(name="partner_group_name")
    private String partnerGroupName;

    private String Description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @OneToMany(mappedBy="partnerGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartnerGroupItem> partnerGroupItem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartnerGroupName() {
        return partnerGroupName;
    }

    public void setPartnerGroupName(String partnerGroupName) {
        this.partnerGroupName = partnerGroupName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public List<PartnerGroupItem> getPartnerGroupItem() {
        return partnerGroupItem;
    }

    public void setPartnerGroupItem(List<PartnerGroupItem> partnerGroupItem) {
        this.partnerGroupItem = partnerGroupItem;
    }

    public PartnerGroupItem addPartnerGroupItem(PartnerGroupItem partnerGroupItem) {
        getPartnerGroupItem().add(partnerGroupItem);
        partnerGroupItem.setPartnerGroup(this);
        return partnerGroupItem;
    }
}
