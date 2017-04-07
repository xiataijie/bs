package com.bs.common.bean;

public class PictureResultJson {
	
	private Integer error;
	private String url;
	private String message;
	
	public PictureResultJson(Integer state, String url) {
		this.url = url;
		this.error = state;
	}
	public PictureResultJson(Integer state, String url, String errorMessage) {
		this.url = url;
		this.error = state;
		this.message = errorMessage;
	}
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
