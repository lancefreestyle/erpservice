package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.CommonResponseVo;
import com.capgemini.cn.erp.vo.LoginRequestVo;
import com.capgemini.cn.erp.vo.LoginResponseVo;

import java.util.List;

public interface CommonService {

	public DataResponse<List<CommonResponseVo>> queryListByMapId(String mapCode);
	public DataResponse<List<CommonResponseVo>> queryMapList(String templatecode);
	public DataResponse<List<CommonResponseVo>> queryOriginFiledsByTemplateId(String templatecode);
	public DataResponse<List<CommonResponseVo>> zifulist();
	public DataResponse<List<CommonResponseVo>> pingzhenglist();
	public DataResponse<List<CommonResponseVo>> syslist();
	public DataResponse<List<CommonResponseVo>> templatelist();

}
