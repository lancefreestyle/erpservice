package com.capgemini.cn.erp.vo;

import java.util.List;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
public class PartnerGroupVo {

    private String id;

    private String partnerGroupName;

    private String description;

    private List<PartnerGroupItemVo> itemVos;

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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PartnerGroupItemVo> getItemVos() {
        return itemVos;
    }

    public void setItemVos(List<PartnerGroupItemVo> itemVos) {
        this.itemVos = itemVos;
    }
}
