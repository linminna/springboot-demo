package com.lmn.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl {

	@Autowired
	private RedisKeyValueTemplate keyValueTemplate;

	@Cacheable(cacheNames = "userCache", keyGenerator = "accountKeyGenerator")
	public String getRedisCache(Integer userId) {
		String result = "";
		System.out.println("开始查询.....");
		try {
			Thread.sleep(3 * 1000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = "1686217";
		System.out.println("查询结束......");
		return result;
	}

}
