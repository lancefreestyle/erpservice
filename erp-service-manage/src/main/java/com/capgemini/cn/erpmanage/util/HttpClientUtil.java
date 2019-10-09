package com.capgemini.cn.erpmanage.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpClientUtil {
	private static int CONNECT_TIME_OUT = 10000;

	public static String doPostFrom(String url, Map<String, Object> paramMap) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		String result = "";
		// 创建httpClient实例
		httpClient = HttpClients.createDefault();
		// 创建httpPost远程连接实例
		HttpPost httpPost = new HttpPost(url);
		// 配置请求参数实例
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
				.setConnectionRequestTimeout(35000)// 设置连接请求超时时间
				.setSocketTimeout(60000)// 设置读取数据连接超时时间
				.build();
		// 为httpPost实例设置配置
		httpPost.setConfig(requestConfig);
		// 设置请求头
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
		// 封装post请求参数
		if (null != paramMap && paramMap.size() > 0) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			// 循环遍历，获取迭代器
			for (Map.Entry<String, Object> mapEntry : paramMap.entrySet()) {
				nvps.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue().toString()));
			}
			// 为httpPost设置封装好的请求参数
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		try {
			// httpClient对象执行post请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpPost);
			// 从响应对象中获取响应内容
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}

	public static String doPostByJson(String url, String jsonStr) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		String result = "";
		// 创建httpClient实例
		httpClient = HttpClients.createDefault();
		// 创建httpPost远程连接实例
		HttpPost httpPost = new HttpPost(url);
		// 配置请求参数实例
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
				.setConnectionRequestTimeout(35000)// 设置连接请求超时时间
				.setSocketTimeout(60000)// 设置读取数据连接超时时间
				.build();
		// 为httpPost实例设置配置
		httpPost.setConfig(requestConfig);
		// 设置请求头
		httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
		// 构建消息实体
		StringEntity stringEntity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
		stringEntity.setContentEncoding("UTF-8");
		// 发送Json格式的数据请求
		stringEntity.setContentType("application/json");
		httpPost.setEntity(stringEntity);
		try {
			// httpClient对象执行post请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpPost);
			// 从响应对象中获取响应内容
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}

	// get
	public static int getStatusPostByJson(String url, String jsonStr, Map<String, String> headerMap) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		int result = 0;
		// 创建httpClient实例
		httpClient = HttpClients.createDefault();
		// 创建httpPost远程连接实例
		HttpPost httpPost = new HttpPost(url);
		// 配置请求参数实例
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
				.setConnectionRequestTimeout(35000)// 设置连接请求超时时间
				.setSocketTimeout(60000)// 设置读取数据连接超时时间
				.build();
		// 为httpPost实例设置配置
		httpPost.setConfig(requestConfig);
		// 设置请求头
		httpPost.addHeader("Content-Type", "application/json; charset=utf-8");

		// 设置请求头
		if (null != headerMap && headerMap.size() > 0) {
			// 循环遍历，获取迭代器
			for (Map.Entry<String, String> mapEntry : headerMap.entrySet()) {
				httpPost.addHeader(mapEntry.getKey(), mapEntry.getValue());
			}

		}

		// 构建消息实体
		StringEntity stringEntity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
		stringEntity.setContentEncoding("UTF-8");
		// 发送Json格式的数据请求
		stringEntity.setContentType("application/json");
		httpPost.setEntity(stringEntity);
		try {
			// httpClient对象执行post请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpPost);

			log.info("***httpstatus:{}", httpResponse.getStatusLine().getStatusCode());
			// 从响应对象中获取响应内容
			// HttpEntity entity = httpResponse.getEntity();
			result = httpResponse.getStatusLine().getStatusCode();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}

	public static String doPostByXml(String url, String xml) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		String result = "";
		// 创建httpClient实例
		httpClient = HttpClients.createDefault();
		// 创建httpPost远程连接实例
		HttpPost httpPost = new HttpPost(url);
		// 配置请求参数实例
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
				.setConnectionRequestTimeout(35000)// 设置连接请求超时时间
				.setSocketTimeout(60000)// 设置读取数据连接超时时间
				.build();
		// 为httpPost实例设置配置
		httpPost.setConfig(requestConfig);
		// 设置请求头
		httpPost.addHeader("Content-Type", "application/xml; charset=utf-8");
		// 构建消息实体
		StringEntity stringEntity = new StringEntity(xml, Charset.forName("UTF-8"));
		stringEntity.setContentEncoding("UTF-8");
		// 发送Json格式的数据请求
		stringEntity.setContentType("application/xml");
		httpPost.setEntity(stringEntity);
		try {
			// httpClient对象执行post请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpPost);
			// 从响应对象中获取响应内容
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}

	public static String httpGet(String url, Map<String, String> headerMap) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		String result = "";
		// 创建httpClient实例
		httpClient = HttpClients.createDefault();
		// 创建httpPost远程连接实例
		HttpGet httpGet = new HttpGet(url);
		// 配置请求参数实例
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 设置连接主机服务超时时间
				.setConnectionRequestTimeout(35000)// 设置连接请求超时时间
				.setSocketTimeout(60000)// 设置读取数据连接超时时间
				.build();
		// 为httpPost实例设置配置
		httpGet.setConfig(requestConfig);
		// 设置请求头
		if (null != headerMap && headerMap.size() > 0) {
			// 循环遍历，获取迭代器
			for (Map.Entry<String, String> mapEntry : headerMap.entrySet()) {
				httpGet.addHeader(mapEntry.getKey(), mapEntry.getValue());
			}

		}

		try {
			// httpClient对象执行post请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpGet);
			// 从响应对象中获取响应内容
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}

	public static String httpGetHeader(String url, Map<String, String> headerMap, String responseHeaderName)
			throws Exception {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		String result = "";
		// 创建httpClient实例
		httpClient = HttpClients.createDefault();
		// 创建httpPost远程连接实例
		HttpGet httpGet = new HttpGet(url);
		// 配置请求参数实例
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)// 设置连接主机服务超时时间
				.setConnectionRequestTimeout(5000)// 设置连接请求超时时间
				.setSocketTimeout(5000)// 设置读取数据连接超时时间
				.build();
		// 为httpPost实例设置配置
		httpGet.setConfig(requestConfig);
		// 设置请求头
		if (null != headerMap && headerMap.size() > 0) {
			// 循环遍历，获取迭代器
			for (Map.Entry<String, String> mapEntry : headerMap.entrySet()) {
				httpGet.addHeader(mapEntry.getKey(), mapEntry.getValue());
			}

		}

		try {
			// httpClient对象执行post请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpGet);
			// 从响应对象中获取响应内容
			result = httpResponse.getFirstHeader(responseHeaderName).getValue();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return result;
	}

	public static ResponseEntity doGet(String url, HttpHeaders requestHeaders) throws Exception {
		ResponseEntity responseEntity = null;
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {

			String result = "";
			// 创建httpClient实例
			httpClient = HttpClients.createDefault();
			// 创建httpPost远程连接实例
			HttpGet httpGet = new HttpGet(url);
			// 配置请求参数实例
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIME_OUT)// 设置连接主机服务超时时间
					.setConnectionRequestTimeout(CONNECT_TIME_OUT)// 设置连接请求超时时间
					.setSocketTimeout(CONNECT_TIME_OUT)// 设置读取数据连接超时时间
					.build();
			// 为httpPost实例设置配置
			httpGet.setConfig(requestConfig);
			// 设置请求头
			if (null != requestHeaders && requestHeaders.size() > 0) {
				// 循环遍历，获取迭代器
				for (Map.Entry<String, List<String>> mapEntry : requestHeaders.entrySet()) {
					String headerKey = mapEntry.getKey();
					List<String> headerValueList = mapEntry.getValue();
					if (headerValueList != null && headerValueList.size() > 0) {
						for (String headerValue : headerValueList) {
							httpGet.addHeader(headerKey, headerValue);
						}
					}

				}
			}

			// httpClient对象执行Get请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpGet);
			// 从响应对象中获取响应内容
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
			HttpHeaders warpResponseHeaders = new HttpHeaders();
			Header[] responseHeader = httpResponse.getAllHeaders();
			if (responseHeader != null) {
				for (Header header : responseHeader) {
					warpResponseHeaders.add(header.getName(), header.getValue());
				}
			}
			responseEntity = new ResponseEntity<>(result, warpResponseHeaders,
					HttpStatus.valueOf(httpResponse.getStatusLine().getStatusCode()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
		}

		return responseEntity;

	}

	public static ResponseEntity doPost(String url, HttpHeaders requestHeaders, String jsonStr,String contentType) throws Exception {
		ResponseEntity responseEntity = null;
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {

			String result = "";
			// 创建httpClient实例
			httpClient = HttpClients.createDefault();
			// 创建httpPost远程连接实例
			HttpPost httpPost = new HttpPost(url);
			// 配置请求参数实例
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIME_OUT)// 设置连接主机服务超时时间
					.setConnectionRequestTimeout(CONNECT_TIME_OUT)// 设置连接请求超时时间
					.setSocketTimeout(CONNECT_TIME_OUT)// 设置读取数据连接超时时间
					.build();
			// 为httpPost实例设置配置
			httpPost.setConfig(requestConfig);
			// 设置请求头
			if (null != requestHeaders && requestHeaders.size() > 0) {
				// 循环遍历，获取迭代器
				for (Map.Entry<String, List<String>> mapEntry : requestHeaders.entrySet()) {
					String headerKey = mapEntry.getKey();
					if(!"content-length".equals(headerKey.toLowerCase())) {
						List<String> headerValueList = mapEntry.getValue();
						if (headerValueList != null && headerValueList.size() > 0) {
							for (String headerValue : headerValueList) {
								httpPost.addHeader(headerKey, headerValue);
							}
						}
					}
				}
			}

			// 构建消息实体
			if(!StringUtils.isEmpty(jsonStr)) {
				StringEntity stringEntity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
				stringEntity.setContentEncoding("UTF-8");
				// 发送Json格式的数据请求
				stringEntity.setContentType(contentType);
				httpPost.setEntity(stringEntity);
			}

			// httpClient对象执行Get请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpPost);
			// 从响应对象中获取响应内容
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
			HttpHeaders warpResponseHeaders = new HttpHeaders();
			Header[] responseHeader = httpResponse.getAllHeaders();
			if (responseHeader != null) {
				for (Header header : responseHeader) {
					warpResponseHeaders.add(header.getName(), header.getValue());
				}
			}
			responseEntity = new ResponseEntity<>(result, warpResponseHeaders,
					HttpStatus.valueOf(httpResponse.getStatusLine().getStatusCode()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
		}

		return responseEntity;

	}

	public static ResponseEntity doDelete(String url, HttpHeaders requestHeaders, String jsonStr,String contentType) throws Exception {
		ResponseEntity responseEntity = null;
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {

			String result = "";
			// 创建httpClient实例
			httpClient = HttpClients.createDefault();
			// 创建httpPost远程连接实例
			LocalHttpDelete httpPost = new LocalHttpDelete(url);
			// 配置请求参数实例
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIME_OUT)// 设置连接主机服务超时时间
					.setConnectionRequestTimeout(CONNECT_TIME_OUT)// 设置连接请求超时时间
					.setSocketTimeout(CONNECT_TIME_OUT)// 设置读取数据连接超时时间
					.build();
			// 为httpPost实例设置配置
			httpPost.setConfig(requestConfig);
			// 设置请求头
			if (null != requestHeaders && requestHeaders.size() > 0) {
				// 循环遍历，获取迭代器
				for (Map.Entry<String, List<String>> mapEntry : requestHeaders.entrySet()) {
					String headerKey = mapEntry.getKey();
					if(!"content-length".equals(headerKey.toLowerCase())) {
						List<String> headerValueList = mapEntry.getValue();
						if (headerValueList != null && headerValueList.size() > 0) {
							for (String headerValue : headerValueList) {
								httpPost.addHeader(headerKey, headerValue);
							}
						}
					}
				}
			}

			// 构建消息实体
			if(!StringUtils.isEmpty(jsonStr)) {
				StringEntity stringEntity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
				stringEntity.setContentEncoding("UTF-8");
				// 发送Json格式的数据请求
				stringEntity.setContentType(contentType);
				httpPost.setEntity(stringEntity);
			}

			// httpClient对象执行Get请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpPost);
			// 从响应对象中获取响应内容
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
			HttpHeaders warpResponseHeaders = new HttpHeaders();
			Header[] responseHeader = httpResponse.getAllHeaders();
			if (responseHeader != null) {
				for (Header header : responseHeader) {
					warpResponseHeaders.add(header.getName(), header.getValue());
				}
			}
			responseEntity = new ResponseEntity<>(result, warpResponseHeaders,
					HttpStatus.valueOf(httpResponse.getStatusLine().getStatusCode()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
		}

		return responseEntity;

	}

	public static ResponseEntity doPut(String url, HttpHeaders requestHeaders, String jsonStr,String contentType) throws Exception {
		ResponseEntity responseEntity = null;
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {

			String result = "";
			// 创建httpClient实例
			httpClient = HttpClients.createDefault();
			// 创建httpPost远程连接实例
			HttpPut httpPost = new HttpPut(url);
			// 配置请求参数实例
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIME_OUT)// 设置连接主机服务超时时间
					.setConnectionRequestTimeout(CONNECT_TIME_OUT)// 设置连接请求超时时间
					.setSocketTimeout(CONNECT_TIME_OUT)// 设置读取数据连接超时时间
					.build();
			// 为httpPost实例设置配置
			httpPost.setConfig(requestConfig);
			// 设置请求头
			if (null != requestHeaders && requestHeaders.size() > 0) {
				// 循环遍历，获取迭代器
				for (Map.Entry<String, List<String>> mapEntry : requestHeaders.entrySet()) {
					String headerKey = mapEntry.getKey();
					if(!"content-length".equals(headerKey.toLowerCase())) {
						List<String> headerValueList = mapEntry.getValue();
						if (headerValueList != null && headerValueList.size() > 0) {
							for (String headerValue : headerValueList) {
								httpPost.addHeader(headerKey, headerValue);
							}
						}
					}
				}
			}

			// 构建消息实体
			if(!StringUtils.isEmpty(jsonStr)) {
				StringEntity stringEntity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
				stringEntity.setContentEncoding("UTF-8");
				// 发送Json格式的数据请求
				stringEntity.setContentType(contentType);
				httpPost.setEntity(stringEntity);
			}

			// httpClient对象执行Get请求,并返回响应参数对象
			httpResponse = httpClient.execute(httpPost);
			// 从响应对象中获取响应内容
			HttpEntity entity = httpResponse.getEntity();
			result = EntityUtils.toString(entity, "utf-8");
			HttpHeaders warpResponseHeaders = new HttpHeaders();
			Header[] responseHeader = httpResponse.getAllHeaders();
			if (responseHeader != null) {
				for (Header header : responseHeader) {
					warpResponseHeaders.add(header.getName(), header.getValue());
				}
			}
			responseEntity = new ResponseEntity<>(result, warpResponseHeaders,
					HttpStatus.valueOf(httpResponse.getStatusLine().getStatusCode()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			// 关闭资源
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					throw e;
				}
			}
		}

		return responseEntity;

	}

	public static void main(String[] args) {
		String url = "http://e-move.intolearn.com/api/material/deliveryInformation";
		HttpHeaders requestHeaders  = new HttpHeaders();
		requestHeaders.set("content-length", "500");
		requestHeaders.set("cookie", "sap-usercontext=sap-client=300; JSESSIONID=u_7jkYmcJUBxMpF6kvcipcatmCOLCr50lUgJcQO8");
		requestHeaders.set("source_sys_id", "SAP");
		requestHeaders.set("User-Agent", "PostmanRuntime/7.3.0");
		requestHeaders.set("Connection", "keep-alive");
		requestHeaders.set("Postman-Token", "69b8fbff-9f0b-481c-88b6-06a19b09471d");
		//requestHeaders.set("Host", "localhost:8080");
		requestHeaders.set("cache-control", "no-cache");
		requestHeaders.set("accept-encoding", "gzip, deflate");
		requestHeaders.set("accept", "application/json");
		requestHeaders.set("Content-Type", "application/json");
		String jsonStr = "{\r\n" +
				"	\"materialdatalist\": [{\r\n" +
				"		\"rsnum\": \"0000000118\",\r\n" +
				"		\"matnr\": \"100026\",\r\n" +
				"		\"menge\": \"1\",\r\n" +
				"		\"meins\": \"EA\",\r\n" +
				"		\"bwart\": \"\",\r\n" +
				"		\"zremd\": \"\"\r\n" +
				"	}]\r\n" +
				"}";
		try {
			ResponseEntity responseEntity = doPost(url,requestHeaders,jsonStr,"application/json");
			System.out.println("****responseEntity:"+responseEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
