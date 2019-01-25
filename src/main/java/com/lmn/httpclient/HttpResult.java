package com.lmn.httpclient;

public class HttpResult {
	// 响应的状态码
	private Integer code;
	// 响应的响应体
	private String body;

	public HttpResult() {
		// TODO Auto-generated constructor stub
	}

	public HttpResult(Integer code, String body) {
		this.code = code;
		this.body = body;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}