package com.capgemini.cn.erp.vo;

import java.io.Serializable;

public class ConditionItemVo implements Serializable {

    private String id;

    private String andOr;

    private String calculationId;

    private String compareValue;

    private String judgment;

    private String leftBrackets;

    private String rightBrackets;

    private String sequence;

    private String sourceColumn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAndOr() {
        return andOr;
    }

    public void setAndOr(String andOr) {
        this.andOr = andOr;
    }

    public String getCalculationId() {
        return calculationId;
    }

    public void setCalculationId(String calculationId) {
        this.calculationId = calculationId;
    }

    public String getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }

    public String getJudgment() {
        return judgment;
    }

    public void setJudgment(String judgment) {
        this.judgment = judgment;
    }

    public String getLeftBrackets() {
        return leftBrackets;
    }

    public void setLeftBrackets(String leftBrackets) {
        this.leftBrackets = leftBrackets;
    }

    public String getRightBrackets() {
        return rightBrackets;
    }

    public void setRightBrackets(String rightBrackets) {
        this.rightBrackets = rightBrackets;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSourceColumn() {
        return sourceColumn;
    }

    public void setSourceColumn(String sourceColumn) {
        this.sourceColumn = sourceColumn;
    }
}
