package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.RuleTypeEntity;
import com.capgemini.cn.erp.domain.SystemBusinessTypeEntity;
import com.capgemini.cn.erp.vo.SourceSystemVo;

import java.util.List;

public interface RuleTypeService {

    DataResponse<List<RuleTypeEntity>> allList();




}
