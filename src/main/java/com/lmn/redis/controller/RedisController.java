package com.lmn.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmn.redis.service.RedisServiceImpl;

@RestController
public class RedisController {

	@Autowired
	private RedisServiceImpl redisServiceImpl;

	@GetMapping("/getHelloWorld")
	public String getHelloWorld(Integer userId) {
		long beginTime = System.currentTimeMillis();
		String userInfo = redisServiceImpl.getRedisCache(userId);
		long time = System.currentTimeMillis() - beginTime;
		System.out.println(time);
		return userInfo;
	}
}
