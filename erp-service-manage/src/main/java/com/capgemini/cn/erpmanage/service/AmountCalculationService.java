package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.AmountCalculationDeleteVo;
import com.capgemini.cn.erp.vo.AmountCalculationQueryVo;
import com.capgemini.cn.erp.vo.AmountCalculationVo;
import com.capgemini.cn.erp.vo.ConditionQueryVo;
import com.capgemini.cn.erp.vo.KeyValueVo;

import java.util.List;

/**
 * @author jikzhang
 */
public interface AmountCalculationService {

	DataResponse<List<AmountCalculationVo>> list(AmountCalculationQueryVo queryVo);

	DataResponse<List<AmountCalculationVo>> listAll();

	DataResponse<List<KeyValueVo>> getCalculations(AmountCalculationQueryVo queryVo);

	DataResponse<AmountCalculationVo> detail(AmountCalculationQueryVo queryVo);

	DataResponse add(AmountCalculationVo vo);

	DataResponse update(AmountCalculationVo vo);

	DataResponse delete(AmountCalculationDeleteVo deleteVo);
}
