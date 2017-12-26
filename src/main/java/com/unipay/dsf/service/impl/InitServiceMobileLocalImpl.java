package com.unipay.dsf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.unipay.dsf.dao.impl.MobileLocalDao;
import com.unipay.dsf.service.InitService;

/**
 * Filename:InitServiceMobileLocalImpl.java
 * Description: 程序初始化Redis数据加载服务接口实现
 * @author litong
 * @date 2017年3月9日 下午4:31:35
 */
@Service
public class InitServiceMobileLocalImpl implements InitService {
	@Autowired
	private MobileLocalDao rmd ;
	@Value("${redis.schema.mobileLocal}")
	private String key;
	@Override
	public void init() {
		System.out.println("清空数据库:"+rmd.flushDB()+"-------------------");
		System.out.println("插入数据库-------------------");
		rmd.upload(key, rmd.getAllMobileLocal());
	}

}
