package com.unipay.dsf.dao.impl;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.unipay.dsf.dao.BaseDao;
import com.unipay.dsf.dto.MobileLocal;

/**
 * Filename:RedisMobileLocalDao.java
 * Description: 
 * @author litong
 * @date 2017年3月8日 上午10:08:37
 * @param <K>
 * @param <V>
 */
@Repository
public class MobileLocalDao extends BaseDao {
	@Autowired
	MobileLocal mobileLocal;
	
	@Autowired
	private HashMap<Object,Object> mobileLocalMap;
	
	@Value("${redis.schema.mobileLocal}")
	private String schema;
	
	/**
	 * @param key
	 * @return
	 * 查询返回手机号归属对象
	 * @throws Exception 
	 */
	public MobileLocal getMobileLocal(String key) throws Exception {

		//return (MobileLocal) getObjectMap(mobileLocalKey).get(key);
		@SuppressWarnings("unchecked")
		ValueOperations<String, Object> value = (ValueOperations<String, Object>) super.redisTemplate.opsForValue();
		try {
			mobileLocal = (MobileLocal) value.get(key);
		}catch (Exception e){
			e.printStackTrace(); 
            throw new Exception("查询redis失败", e);
		}
		return mobileLocal;
	}
	
	/**
	 * @return
	 * 初始化查询所有号码归属
	 */
	public HashMap<Object,Object> getAllMobileLocal(){
		@SuppressWarnings("unchecked")
		ValueOperations<String, Object> value = (ValueOperations<String, Object>) super.redisTemplate.opsForValue();
		for(Object mobileLocal : super.sqlSessionTemplate.selectList("mobileLocalFindAll")) {
			//mobileLocalMap.put(((MobileLocal) mobileLocal).getMobileNo(),mobileLocal);
			//将原来的插入map换成一行一行插入,并设置失效时间
			//value.set(schema+"."+((MobileLocal) mobileLocal).getMobileNo(), mobileLocal);
			value.set(schema+"."+((MobileLocal) mobileLocal).getMobileNo(), mobileLocal,9999,TimeUnit.DAYS);
		}
		return mobileLocalMap;
	}
	
	/**
	 * @param key
	 * @return
	 * vertica查询：根据手机号查询号段
	 */
	public MobileLocal getMobileLocalByDB(String key){
		return super.sqlSessionTemplate.selectOne("mobileLocalFindByKey",key);
	}
	
}
