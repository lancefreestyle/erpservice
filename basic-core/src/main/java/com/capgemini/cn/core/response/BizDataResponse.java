package com.capgemini.cn.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BizDataResponse<D> extends BaseResponse<D> {

    /**
     * 响应接口动作，对应每个REST接口方法级别{@link org.springframework.web.bind.annotation.RequestMapping}中定义的value值
     */
    private String action;

    /**
     * 响应接口地址，对应每个REST接口类级别{@link org.springframework.web.bind.annotation.RequestMapping}中定义的value值
     */
    private String controller;

    public BizDataResponse() {
    }

    public BizDataResponse(DataStatus dataStatus, String notes, D response) {
        super(dataStatus, notes, response);
    }

    public BizDataResponse(DataStatus dataStatus, D response) {
        super(dataStatus, response);
    }

    /**
     * 状态编码
     */
    @JsonProperty(value = "returnCode", required = true)
    public String getDataStatusCode() {
        return super.getDataStatus().code();
    }

    @JsonProperty(value = "returnCode")
    public void setDataStatusCode(String dataStatus) {
        // 只是用作JSON转对象序列时临时接手，该方法无任何实际使用场景
    }

    @JsonProperty(value = "returnMsg", required = true)
    @Override
    public String getNotes() {
        return super.getNotes();
    }

    @JsonProperty(value = "returnMsg")
    @Override
    public void setNotes(String notes) {
        super.setNotes(notes);
    }

    @JsonProperty(value = "content", required = true)
    @Override
    public D getResponse() {
        return super.getResponse();
    }

    @JsonProperty(value = "content")
    @Override
    public void setResponse(D response) {
        super.setResponse(response);
    }

    /**
     * 响应接口动作，对应每个REST接口方法级别{@link org.springframework.web.bind.annotation.RequestMapping}中定义的value值
     */
    public String getAction() {
        return action;
    }

    /**
     * 响应接口动作，对应每个REST接口方法级别{@link org.springframework.web.bind.annotation.RequestMapping}中定义的value值
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 响应接口地址，对应每个REST接口类级别{@link org.springframework.web.bind.annotation.RequestMapping}中定义的value值
     */
    public String getController() {
        return controller;
    }

    /**
     * 响应接口地址，对应每个REST接口类级别{@link org.springframework.web.bind.annotation.RequestMapping}中定义的value值
     */
    public void setController(String controller) {
        this.controller = controller;
    }
}
