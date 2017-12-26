package com.unipay.dsf.dto;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * Filename:MobileLocal.java
 * Description: 
 * @author litong
 * @date 2017年3月6日 下午4:41:26
 */
@Component
public class MobileLocal extends BaseDto{
	private static final long serialVersionUID = -1410743134158658845L;
	@JSONField(ordinal = 1)
	private String mobileNo;
	@JSONField(ordinal = 5)
	private String areaCode;
	@JSONField(ordinal = 4)
	private String cityName;
	@JSONField(ordinal = 2)
	private String vendorType;
	@JSONField(ordinal = 3)
	private String provName;
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
