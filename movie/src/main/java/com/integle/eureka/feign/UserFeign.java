package com.integle.eureka.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.integle.eureka.entity.User;

@FeignClient("service-user")
public interface UserFeign {

	@RequestMapping(value="/index")
	public String userHello();
	
	@GetMapping("/say/{word}")
	public String say(@PathVariable("word") String word);
	
	@PostMapping("/user")
	public User findUser(User user);
	
	@GetMapping("/go")
	public String go(@RequestParam("provice") String provice, @RequestParam("city") String city);
}
