package com.capgemini.cn.erpmanage.service.impl;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.capgemini.cn.erp.domain.QSysUser;
import com.capgemini.cn.erp.domain.SysUser;
import com.capgemini.cn.erpmanage.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.erp.vo.LoginRequestVo;
import com.capgemini.cn.erp.vo.LoginResponseVo;
import com.capgemini.cn.erpmanage.service.LoginService;
import com.capgemini.cn.erpmanage.util.MD5;
import com.querydsl.jpa.impl.JPAQuery;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

	@PersistenceContext(unitName = "baseEntityManagerFactory")
	private EntityManager em;

	private QSysUser qSysUser = QSysUser.sysUser;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ServerProperties serverProperties;

	@Override
	public DataResponse<LoginResponseVo> login(LoginRequestVo loginRequestVo) {
		// TODO Auto-generated method stub
		DataResponse<LoginResponseVo> dataResponse = new DataResponse<LoginResponseVo>();
		if (StringUtils.isEmpty(loginRequestVo.getUsername()) || StringUtils.isEmpty(loginRequestVo.getPassword())) {
			dataResponse.setDataStatus(DataStatus.BUSINESS_ERROR);
			dataResponse.setNotes("用户名或密码不能为空！");
			return dataResponse;
		}
		SysUser user = new JPAQuery<SysUser>(em).from(qSysUser)
				.where(qSysUser.username.eq(loginRequestVo.getUsername())).fetchOne();
		if (null == user) {
			dataResponse.setDataStatus(DataStatus.BUSINESS_ERROR);
			dataResponse.setNotes("用户名或者密码错误！");
			log.warn("{}用户名不存在！", loginRequestVo.getUsername());
			return dataResponse;
		}

		if (!validatePassword(loginRequestVo.getPassword(), user.getPassword())) {
			dataResponse.setDataStatus(DataStatus.BUSINESS_ERROR);
			dataResponse.setNotes("用户名或者密码错误！");
			log.warn("{}用户名或者密码错误！", loginRequestVo.getUsername());
			return dataResponse;
		} else {
			LoginResponseVo vo = new LoginResponseVo();
			vo.setUserId(user.getId());
			vo.setUserName(user.getUsername());
			final String userIdentity = jwtTokenUtil.generateToken(user.getId());
			vo.setUserId(userIdentity);
			dataResponse.setResponse(vo);
			return dataResponse;
		}
	}


	private boolean validatePassword(String plainPassword, String password) {
		plainPassword = MD5.md5crypt(plainPassword);
		return plainPassword.equals(password);
	}

}
