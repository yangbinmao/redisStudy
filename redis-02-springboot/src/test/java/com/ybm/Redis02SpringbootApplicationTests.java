package com.ybm;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybm.pojo.User;
import com.ybm.utils.RedisUitl;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class Redis02SpringbootApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUitl redisUitl;

	@Test
	void contextLoads() {
		//redisTemplate  操作不同的数据类型，api和我们指令是一样的
		// opsForValue   操作字符串 类似String
		// opsForList 	操作list 类似list
		redisTemplate.opsForValue().set("name","admin");
		System.out.println(redisTemplate.opsForValue().get("name"));

		//除了基本操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务，和基本的crud



		//对redis数据库操作都在 以下获取方式
		//		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		//		connection.flushDb();
	}


	@Test
	public void test() throws JsonProcessingException {
		//真实的开发一般都是使用json来传递对象
		User user = new User("ybm",2);
		User user1 = new User("代仪",2);
		//所有对象必须要序列化
		String jsonUser = new ObjectMapper().writeValueAsString(user1);
		redisTemplate.opsForValue().set("user",user1);
		User user2 = (User) JSONUtil.convertToStrict(redisTemplate.opsForValue().get("user"), User.class);
		System.out.println(user2);
	}

	@Test
	public void test2(){
		redisUitl.set("name","代仪");
		System.out.println(redisUitl.get("name"));
	}
}
