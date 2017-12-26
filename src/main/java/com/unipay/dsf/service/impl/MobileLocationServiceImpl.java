package com.unipay.dsf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.unipay.dsf.dao.impl.MobileLocalDao;
import com.unipay.dsf.dto.MobileLocal;
import com.unipay.dsf.service.MobileLocationService;



/**
 * Filename:MobileLocationServiceImpl.java
 * Description: 
 * @author litong
 * @date 2017年3月8日 下午2:54:46
 */
@Service("mobileLocationService")
public class MobileLocationServiceImpl implements MobileLocationService{

	@Autowired
	private MobileLocalDao rmd ;
	@Autowired
	private MobileLocal mobileLocal;
	
	@Value("${redis.schema.mobileLocal}")
	private String schema;
	
	@Override
	public String checkMobileLocal(String mobileNo,String reqSeq,String appId) {
		System.out.println("welcome to my service mobilelocation is a start...");
		try {
			mobileLocal = rmd.getMobileLocal(schema+"."+mobileNo.substring(0,7));
		} catch (Exception e) {
			e.printStackTrace();
			mobileLocal = rmd.getMobileLocalByDB(mobileNo.substring(0,7));
		}
		
		if(mobileLocal==null){
			System.out.println("result为空返回：********************************************");
			String result="{\"mobileNo\":\""+mobileNo+"\",\"vendorType\":\"null\",\"provName\":\"null\",\"cityName\":\"null\",\"areaCode\":\"null\",\"reqSeq\":\""+reqSeq+"\"}";
			return result;
		}
		mobileLocal.setMobileNo((String) mobileNo);
		mobileLocal.setReqSeq(reqSeq);
		String result = JSONObject.toJSONString(mobileLocal);
		return result;
	}



}
