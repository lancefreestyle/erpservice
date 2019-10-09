package com.capgemini.cn.erp.vo;

import java.util.Date;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
public class ReconciliationRuleItemVo {

    private String id;

    private String fieldName;

    private String fieldTitle;

    private String filedType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public void setFieldTitle(String fieldTitle) {
        this.fieldTitle = fieldTitle;
    }

    public String getFiledType() {
        return filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }

}
