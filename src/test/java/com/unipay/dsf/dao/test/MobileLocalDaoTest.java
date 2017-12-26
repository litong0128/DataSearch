package com.unipay.dsf.dao.test;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.unipay.dsf.dao.impl.MobileLocalDao;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MobileLocalDaoTest {
	
	@Autowired
	private MobileLocalDao rmd ;

	@Autowired
	private HashMap<Object,Object> mobileLocalMap;
	@Test
	public void getAllTest(){
		
		//rmd.upload("mobileLocalMap",rmd.getAllMobileLocal());
		
		mobileLocalMap = rmd.getObjectMap("000001");
		System.out.println(JSONObject.toJSONString(mobileLocalMap.get("1368115")));
		
	}
}
