package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.AccountingShareRuleVo;

import java.util.List;

public interface AccountingShareRuleService {

    List<AccountingShareRuleVo> selectList();

    DataResponse<String> delete(String id);

    DataResponse<String> save(AccountingShareRuleVo accountingShareRuleVo);
}
