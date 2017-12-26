package com.unipay.dsf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipay.dsf.dao.impl.MobileLocalDao;
import com.unipay.dsf.service.InitService;

/**
 * Filename:InitServiceImpl.java
 * Description: 程序初始化Redis数据加载服务接口实现
 * @author litong
 * @date 2017年3月9日 下午4:31:35
 */
@Service
public class InitServiceImpl implements InitService {
	

	@Autowired
	private MobileLocalDao rmd ;
	@Override
	public void init() {
		System.out.println("实现InitService接口方法，程序启动自动加载数据到redis！");
	}
}
