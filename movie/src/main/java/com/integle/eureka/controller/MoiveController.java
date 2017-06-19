package com.integle.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integle.eureka.entity.User;
import com.integle.eureka.feign.UserFeign;

@RestController
public class MoiveController {
	
	@Autowired
	private UserFeign userFeign;
	
	@RequestMapping("/user-hello")
	public String userHello() {
		String say = userFeign.say("nidaye");
		System.out.println(say);
		
		User user = new User();
		user.setId(23);
		user.setName("sdfsfd");
		System.out.println(userFeign.findUser(user));
		
		System.out.println(userFeign.go("shanghai", "pudong"));
		return userFeign.userHello();
	}
	

}
