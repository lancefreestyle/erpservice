package com.capgemini.cn.erp.vo;

import java.util.List;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
public class ProductGroupVo {

    private String id;

    private String productGroupName;

    private String description;

    private List<ProductGroupItemVo> itemVos;

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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductGroupItemVo> getItemVos() {
        return itemVos;
    }

    public void setItemVos(List<ProductGroupItemVo> itemvos) {
        this.itemVos = itemvos;
    }
}
