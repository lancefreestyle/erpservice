package com.capgemini.cn.erpmanage.service;

import java.util.List;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.ConditionDeleteVo;
import com.capgemini.cn.erp.vo.ConditionQueryVo;
import com.capgemini.cn.erp.vo.ConditionVo;
import com.capgemini.cn.erp.vo.KeyValueVo;

/**
 * @author jikzhang
 */
public interface ConditionService {
	
    DataResponse<List<ConditionVo>> list(ConditionQueryVo queryVo);
    
    DataResponse<List<KeyValueVo>> getConditions(ConditionQueryVo queryVo);

    DataResponse<ConditionVo> detail(ConditionQueryVo queryVo);

    DataResponse add(ConditionVo vo);

    DataResponse update(ConditionVo vo);

    DataResponse delete(ConditionDeleteVo deleteVo);
}
