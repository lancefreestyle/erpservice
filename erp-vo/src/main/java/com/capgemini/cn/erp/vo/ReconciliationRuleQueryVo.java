package com.capgemini.cn.erp.vo;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
public class ReconciliationRuleQueryVo {

    private String ruleCode;

    private Integer page;

    private Integer size;

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
