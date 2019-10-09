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
@Table(name="product_group")
@NamedQuery(name="ProductGroup.findAll", query="SELECT p FROM ProductGroup p")
public class ProductGroup {

    @Id
    private String id;

    @Column(name="product_group_name")
    private String productGroupName;

    private String Description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @OneToMany(mappedBy="productGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductGroupItem> productGroupItem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
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

    public List<ProductGroupItem> getProductGroupItem() {
        return productGroupItem;
    }

    public void setProductGroupItem(List<ProductGroupItem> productGroupItem) {
        this.productGroupItem = productGroupItem;
    }

    public ProductGroupItem addProductGroupItem(ProductGroupItem productGroupItem) {
        getProductGroupItem().add(productGroupItem);
        productGroupItem.setProductGroup(this);
        return productGroupItem;
    }
}
