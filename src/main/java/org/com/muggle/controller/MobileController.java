package org.com.muggle.controller;

import org.com.muggle.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Category getProducts() {
		Category c = new Category();
		c.setId("id");
		c.setName("name");
		c.setDesc("desc");
		return c;
	}
}
