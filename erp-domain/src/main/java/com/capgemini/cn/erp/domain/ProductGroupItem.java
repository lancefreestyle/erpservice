package com.capgemini.cn.erp.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
@Entity
@Table(name="product_group_item")
@NamedQuery(name="ProductGroupItem.findAll", query="SELECT p FROM ProductGroupItem p")
public class ProductGroupItem {

    @Id
    private String id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_number")
    private String productNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name="product_group_id")
    private ProductGroup productGroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
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

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
}
