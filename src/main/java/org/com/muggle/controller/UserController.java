package org.com.muggle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.com.muggle.model.User;
import org.com.muggle.service.IUserService;
import org.com.muggle.util.JedisFactoryBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@Resource 
	private JedisFactoryBean jedisFactory;
	
	@Resource(name="redisTemplate")
	private RedisTemplate<String,String> redisTemplate;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		this.testCustomizeJedis(model);
		this.testRedisTemplateImp(model);
		return "showUser";
	}
	

	private void testCustomizeJedis(Model model){
		jedisFactory.set("key", "I am ");
		jedisFactory.append("key","a redis connector");
		
		//jedisFactory.setex("key-time", 5, "5 seconds lost");
		jedisFactory.set("key1", "value1");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		jedisFactory.hmset("key-map", map);
		model.addAttribute("redisValue", jedisFactory.hget("key-map", "k2"));
	}
	
	private void testRedisTemplateImp(Model model){
		String key = "redisTemplate";
		String value = "redisTemplate-value";
		redisTemplate.opsForValue().set(key, value);
		model.addAttribute("redistempleate", redisTemplate.opsForValue().get(key));
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(HttpServletRequest request,Model model){
		User newUser = new User();
		newUser.setAge(12);
		newUser.setId(6);
		newUser.setPassword("test");
		newUser.setUserName("test");
		this.userService.saveUser(newUser);
		User user = this.userService.getUserById(2);
		model.addAttribute("user", user);
		return "showUser";
	}
}
