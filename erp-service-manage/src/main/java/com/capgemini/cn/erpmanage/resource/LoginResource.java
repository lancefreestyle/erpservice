package com.capgemini.cn.erpmanage.resource;

import com.capgemini.cn.erpmanage.constant.HttpAuthHeaders;
import com.capgemini.cn.erpmanage.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.cn.core.commons.BaseController;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.vo.LoginRequestVo;
import com.capgemini.cn.erp.vo.LoginResponseVo;
import com.capgemini.cn.erpmanage.service.LoginService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class LoginResource extends BaseController{

	@Autowired
	LoginService loginService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@ApiOperation(value = "登陆")
	@PostMapping(value = "login", consumes = "application/json", produces = "application/json")
	public DataResponse<LoginResponseVo> login(
			@ApiParam(value = "接收数据参数", required = true) @RequestBody LoginRequestVo loginRequestVo) {
		return loginService.login(loginRequestVo);
	}

	@ApiOperation(value = "test")
	@GetMapping(value = "test", produces = "application/json")
	public DataResponse<String> test(@RequestHeader(value = HttpAuthHeaders.USER_IDENTITY) String token) {
		String userId = jwtTokenUtil.getUsernameFromToken(token);
		log.info("userId:{}",userId);
		return new DataResponse<String>();
	}
}
