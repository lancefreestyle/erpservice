package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.ReconciliationRule;
import com.capgemini.cn.erp.vo.ReconciliationRuleQueryVo;
import com.capgemini.cn.erp.vo.ReconciliationRuleVo;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
public interface ReconciliationRuleService {

    DataResponse  list();

    DataResponse  queryByRuleCode(ReconciliationRuleQueryVo queryVo);

    DataResponse add(ReconciliationRuleVo vo);

    DataResponse delete(String id);
}
