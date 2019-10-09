package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.SystemBusinessTypeEntity;

import java.util.List;

public interface SourceSystemService {

    DataResponse<List<SystemBusinessTypeEntity>> alllist();

    DataResponse<List<SourceSystemVo>> getConditions(SourceSystemVo queryVo);


}
