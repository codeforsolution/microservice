package com.codeforsolution.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringDataRedisApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;


	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("email","sanjeet@gmail.com");
		Object value = redisTemplate.opsForValue().get("email");
		int a = 1;

	}

}
