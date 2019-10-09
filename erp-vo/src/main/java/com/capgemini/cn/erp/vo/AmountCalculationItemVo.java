package com.capgemini.cn.erp.vo;

import java.io.Serializable;

public class AmountCalculationItemVo implements Serializable {

    private String id;

    private String constantValue;

    private String operator;

    private String sourceColumnLower;

    private String sourceColumnUpper;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSourceColumnLower() {
        return sourceColumnLower;
    }

    public void setSourceColumnLower(String sourceColumnLower) {
        this.sourceColumnLower = sourceColumnLower;
    }

    public String getSourceColumnUpper() {
        return sourceColumnUpper;
    }

    public void setSourceColumnUpper(String sourceColumnUpper) {
        this.sourceColumnUpper = sourceColumnUpper;
    }
}
