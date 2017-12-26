package com.unipay.dsf.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Filename:BaseDto.java
 * Description: 
 * @author litong
 * @date 2017年3月6日 下午4:40:49
 */
@Component
public class BaseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3399798359378817070L;
	private String key;
	private String value;
	@JSONField(ordinal = 50)
	private String reqSeq;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getReqSeq() {
		return reqSeq;
	}
	public void setReqSeq(String reqSeq) {
		this.reqSeq = reqSeq;
	}
}
