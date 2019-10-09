package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.*;

import java.util.List;

public interface DataTemplateService {

	public DataResponse<List<DataTemplateVo>> list(DataTemplateQueryVo dataTemplateQueryVo);

	public DataResponse add(DataTemplateVo dataTemplateVo);

	public DataResponse update(DataTemplateVo dataTemplateVo);

	public DataResponse delete(String id);

	public DataResponse<DataTemplateVo> detail(String id);


}
