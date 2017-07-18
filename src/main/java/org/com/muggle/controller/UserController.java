package org.com.muggle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.com.muggle.model.Product;
import org.com.muggle.model.User;
import org.com.muggle.repository.ProductRepository;
import org.com.muggle.repository.SolrProductRepository;
import org.com.muggle.service.ConsumerService;
import org.com.muggle.service.IUserService;
import org.com.muggle.service.ProducerService;
import org.com.muggle.util.JedisFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	Logger myLogger = Logger.getLogger("UserController");

	@Resource
	private IUserService userService;

	@Resource
	private JedisFactoryBean jedisFactory;

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	// destnation queue
	@Resource(name = "muggleQueueDestination")
	private ActiveMQQueue muggleQueueDestination;

	// queue producer
	@Resource(name = "producerService")
	private ProducerService producer;

	// queue consumer
	@Resource(name = "consumerService")
	private ConsumerService consumer;
	
	// solrProductRepository
	@Autowired
	private SolrProductRepository solrProductRepository;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		myLogger.info("invoke user controller test log function");
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		this.testCustomizeJedis(model);
		this.testRedisTemplateImp(model);
		this.testActiveMqTemplateImp();
		this.testSolr(model);
		return "showUser";
	}

	private void testCustomizeJedis(Model model) {
		jedisFactory.set("key", "I am ");
		jedisFactory.append("key", "a redis connector");

		// jedisFactory.setex("key-time", 5, "5 seconds lost");
		jedisFactory.set("key1", "value1");

		Map<String, String> map = new HashMap<String, String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		jedisFactory.hmset("key-map", map);
		model.addAttribute("redisValue", jedisFactory.hget("key-map", "k2"));
	}

	private void testRedisTemplateImp(Model model) {
		String key = "redisTemplate";
		String value = "redisTemplate-value";
		redisTemplate.opsForValue().set(key, value);
		model.addAttribute("redistempleate", redisTemplate.opsForValue().get(key));
	}

	private void testActiveMqTemplateImp() {
		for (int i = 0; i < 10; i++) {
			producer.sendMessage("i=" + i);
			myLogger.info("put a value into the queue" + i);
		}
	}

	
	private void testSolr(Model model){
		Product product =solrProductRepository.findOne("GB18030TEST");
		model.addAttribute("product", product);
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(HttpServletRequest request, Model model) {
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
