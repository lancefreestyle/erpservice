package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.LoginRequestVo;
import com.capgemini.cn.erp.vo.LoginResponseVo;

public interface LoginService {

	public DataResponse<LoginResponseVo> login(LoginRequestVo loginRequestVo);
}
