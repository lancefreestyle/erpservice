package com.capgemini.cn.erpmanage.service;

import java.util.List;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erp.vo.SummaryDeleteVo;
import com.capgemini.cn.erp.vo.SummaryQueryVo;
import com.capgemini.cn.erp.vo.SummaryVo;

/**
 * @author jikzhang
 */
public interface SummaryService {

	DataResponse<List<SummaryVo>> list(SummaryQueryVo queryVo);
	
	DataResponse<List<KeyValueVo>> getSummarys(SummaryQueryVo queryVo);

	DataResponse<SummaryVo> detail(SummaryQueryVo queryVo);

	DataResponse add(SummaryVo vo);

	DataResponse update(SummaryVo vo);

	DataResponse delete(SummaryDeleteVo deleteVo);
}
