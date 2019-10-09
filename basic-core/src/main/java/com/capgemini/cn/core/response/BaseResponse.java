package com.capgemini.cn.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.util.StringUtils;

@JsonSerialize
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BaseResponse<D> {

    /**
     * 业务状态，默认值为{@link DataStatus}.SUCCESS
     */
    @JsonProperty(value = "status", required = true)
    private DataStatus dataStatus = DataStatus.SUCCESS;

    /**
     * 接口返回消息，可用作弹出提示
     */
    private String notes = "";

    /**
     * 响应客户端的具体业务数据结构
     */
    private D response;

    /**
     * 分页信息，通常只会在返回列表数据时有值
     */
    private DataPage pages;

    /**
     * 默认构造函数
     */
    public BaseResponse() {
    }

    /**
     * 根据参数构造对象
     *
     * @param dataStatus 业务状态，默认值为{@link DataStatus}.SUCCESS
     * @param notes      接口返回消息，可用作弹出提示
     * @param response   响应客户端的具体业务数据结构
     */
    public BaseResponse(DataStatus dataStatus, String notes, D response) {
        this.dataStatus = dataStatus;
        this.notes = notes;
        this.response = response;
    }

    /**
     * 根据参数构造对象
     *
     * @param dataStatus 业务状态，默认值为{@link DataStatus}.SUCCESS
     * @param response   响应客户端的具体业务数据结构
     */
    public BaseResponse(DataStatus dataStatus, D response) {
        this.dataStatus = dataStatus;
        this.response = response;
    }

    /**
     * 业务状态，默认值为{@link DataStatus}.SUCCESS
     */
    public DataStatus getDataStatus() {
        return dataStatus;
    }

    /**
     * 业务状态，默认值为{@link DataStatus}.SUCCESS
     */
    public void setDataStatus(DataStatus dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 接口返回消息，可用作弹出提示<br/>
     * 如果属性值为空则优先返回dataStatus枚举对应的msg值
     */
    public String getNotes() {
        return StringUtils.isEmpty(notes) ? this.dataStatus.msg() : notes;
    }

    /**
     * 接口返回消息，可用作弹出提示
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 响应客户端的具体业务数据结构
     */
    public D getResponse() {
        return response;
    }

    /**
     * 响应客户端的具体业务数据结构
     */
    public void setResponse(D response) {
        this.response = response;
    }

    /**
     * 分页信息，通常只会在返回列表数据时有值
     */
    public DataPage getPages() {
        return pages;
    }

    /**
     * 分页信息，通常只会在返回列表数据时有值
     */
    public void setPages(DataPage pages) {
        this.pages = pages;
    }
}
