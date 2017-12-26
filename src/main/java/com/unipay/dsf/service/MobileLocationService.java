package com.unipay.dsf.service;

/**
 * Filename:MobileLocationService.java
 * Description: 号码归属地查询
 * @author litong
 * @date 2017年3月9日 下午4:29:12
 */
public interface MobileLocationService {

	/**
	 * @param mobileNo：手机号11位：例如：13681197865
	 * @param reqSeq：流水24位不重复编码，例如：201703211212120000000000
	 * @param appId：请求应用编号6位由服务端分配，例如：000001
	 * @return
	 */
	public String checkMobileLocal(String mobileNo,String reqSeq,String appId);
}
