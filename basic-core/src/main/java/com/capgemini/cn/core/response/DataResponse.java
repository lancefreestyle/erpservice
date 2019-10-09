package com.capgemini.cn.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DataResponse<D> extends BizDataResponse<D> {

    public DataResponse() {
    }

    public DataResponse(DataStatus dataStatus, String notes, D response) {
        super(dataStatus, notes, response);
    }

    public DataResponse(DataStatus dataStatus, D response) {
        super(dataStatus, response);
    }
}
