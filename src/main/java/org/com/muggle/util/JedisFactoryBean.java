package org.com.muggle.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class JedisFactoryBean {
	private Jedis jedis;

	public JedisFactoryBean() {
		if (jedis == null) {
			this.jedis = new Jedis("localhost");
		}
	}

	public void set(String key, String value) {
		jedis.set(key, value);
	}

	public String get(String key) {
		return jedis.get(key);
	}

	public void setex(String key, int seconds, String value) {
		jedis.setex(key, seconds, value);
	}

	public void append(String key, String appendContent) {
		jedis.append(key, appendContent);
	}
	
	
	public void hset(String key,String field,String value){
		jedis.hset(key, field, value);
	}
	
	public void hmset(String key,Map<String,String> value){
		jedis.hmset(key, value);
	}
	
	public String hget(String key,String field) {
		return jedis.hget(key,field);
	}
}