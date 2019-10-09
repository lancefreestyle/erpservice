package com.capgemini.cn.erpmanage.filter;

import com.capgemini.cn.core.response.BaseResponse;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.erpmanage.config.WebFilterConfiguration;
import com.capgemini.cn.erpmanage.constant.HttpAuthHeaders;
import com.capgemini.cn.erpmanage.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    @Autowired
    private WebFilterConfiguration webFilterConfiguration;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	/**
	 * UTF-8字符编码常量
	 */
	public static final String CHARACTER_ENCODING_UTF8 = "UTF-8";

	/**
	 * HTTP传输JSON内容类型
	 */
	private static final String HTTP_CONTENT_TYPE_JSON = "application/json; charset=utf-8";

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();



	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// 获取当前请求地址
		final String requestURL = request.getRequestURI();
		//log.info("当前请求URL是：{}", requestURL);

		final String userIdentity = request.getHeader(HttpAuthHeaders.USER_IDENTITY);

        final String requestMethod = request.getMethod().toLowerCase();
        // 获取白名单列表
        final List<String> whiteList = this.webFilterConfiguration.getWhiteList();

        // 遍历白名单判断当前请求是否在白名单中
        boolean isInWhiteList = false;
        for (String whiteListStr : whiteList) {
            if (requestURL.startsWith(whiteListStr)) {
                isInWhiteList = true;
                break;
            }
        }

		if (isInWhiteList) {
			chain.doFilter(request, response);
		} else {
			// 如果请求方法的值是Options类型则有可能是前端框架发起的跨域校验请求，故设置为不做校验
            if (HttpMethod.OPTIONS.toString().toLowerCase().equals(requestMethod)) {
            	response.setHeader("Access-Control-Allow-Origin","*");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
                response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            	chain.doFilter(request, response);
            	return;
            }
			if (!StringUtils.isEmpty(userIdentity)) {
				boolean match = false;
				try {
					match = jwtTokenUtil.validateToken(userIdentity);
				} catch (Exception ex) {
				}
				if (!match) {
					handleErrorResponse(response);
				}else {
                    chain.doFilter(request, response);
                }

			}else {
				handleErrorResponse(response);
			}

		}

	}

	private void handleErrorResponse(HttpServletResponse response) {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.setCharacterEncoding(CHARACTER_ENCODING_UTF8);
		response.setContentType(HTTP_CONTENT_TYPE_JSON);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			BaseResponse baseResponse = new DataResponse(DataStatus.ILLEGAL_REQUEST, "认证失败", "");
			final String jsonStr = OBJECT_MAPPER.writeValueAsString(baseResponse);
			out.write(jsonStr);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	@Override
	public void destroy() {
	}
}
