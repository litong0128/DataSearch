package com.unipay.dsf.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Filename:RedisBaseDao.java Description:
 * 
 * @author litong
 * @date 2017年3月6日 下午4:41:37
 * @param <K>
 * @param <V>
 */

public class BaseDao {
	// 注解得到操作模板
	@Autowired
	protected RedisTemplate<String, ?> redisTemplate;
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;

	// 得到序列化对象
	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}

	// 把字符串序列化
	protected byte[] serialize(String string) {
		return getRedisSerializer().serialize(string);
	}

	// 反序列化
	protected String deserialize(byte[] bytes) {
		return getRedisSerializer().deserialize(bytes);
	}

	/*
	 * // 根据对象得到hash的Map<byte[],byte[]>
	 * 
	 * @SuppressWarnings("unchecked") protected Map<byte[], byte[]>
	 * getHashes(Object obj) { Map<byte[], byte[]> hashes = new HashMap<byte[],
	 * byte[]>(); Class clazz = obj.getClass(); Field[] fields =
	 * clazz.getDeclaredFields(); for (Field field : fields) { String name =
	 * field.getName(); byte[] nameByte = serialize(name); // Method method =
	 * null; String value = null; byte[] valueByte = null; try { method =
	 * clazz.getMethod(name, null); value = (String) method.invoke(obj, null); }
	 * catch (Exception e) { e.printStackTrace(); } valueByte =
	 * serialize(value); // hashes.put(nameByte, valueByte); } return hashes; }
	 */

	/**
	 * @param method
	 * @return 查询所有对象
	 */
	public List<Object> findAll(String method) {
		return sqlSessionTemplate.selectList(method);
	}

	/**
	 * @param redisMapTable
	 * @param hashMap
	 * 加载对象map到redis数据库
	 */
	public void upload(String redisMapTable, HashMap<Object, Object> hashMap) {
		HashOperations<String, Object, Object> hash = (HashOperations<String, Object, Object>) redisTemplate.opsForHash();
		hash.putAll(redisMapTable, hashMap);
	}

	/**
	 * @param key
	 * @return 
	 * 从redis中获取对象的map集合
	 */
	public HashMap<Object, Object> getObjectMap(String key) {
		HashOperations<String, Object, Object> hash = (HashOperations<String, Object, Object>) redisTemplate.opsForHash();
		return (HashMap<Object, Object>) hash.entries(key);
	}

	/**
	 * @return
	 * 清空数据库数据
	 */
	public String flushDB() {
		return (String) redisTemplate.execute(new RedisCallback<Object>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}

}
