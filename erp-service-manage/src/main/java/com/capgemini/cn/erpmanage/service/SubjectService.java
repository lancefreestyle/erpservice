package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.AmountCalculationQueryVo;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erp.vo.SubjectDeleteVo;
import com.capgemini.cn.erp.vo.SubjectQueryVo;
import com.capgemini.cn.erp.vo.SubjectVo;

import java.util.List;

/**
 * @author jikzhang
 */
public interface SubjectService {

	DataResponse<List<SubjectVo>> list(SubjectQueryVo queryVo);
	
	DataResponse<List<KeyValueVo>> getSubjects(SubjectQueryVo queryVo);

	DataResponse<SubjectVo> detail(SubjectQueryVo queryVo);

	DataResponse add(SubjectVo vo);

	DataResponse update(SubjectVo vo);

	DataResponse delete(SubjectDeleteVo deleteVo);
}
