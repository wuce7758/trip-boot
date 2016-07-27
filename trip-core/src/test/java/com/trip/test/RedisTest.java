package com.trip.test;

import com.trip.component.cache.RedisCache;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisTest extends BaseTest {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private RedisCache redisService;

    @Test
    public void testStringRedisTemplate(){
        template.opsForValue().set("name", "biezhi.me");

        String name = template.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void testRedis(){
        redisService.set("name", "aaaa");
        System.out.println(redisService.get("name"));

    }

}