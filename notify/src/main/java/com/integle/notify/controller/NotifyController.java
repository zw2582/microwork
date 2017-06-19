package com.integle.notify.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integle.notify.beans.Bar;
import com.integle.notify.beans.Order;

@RestController
public class NotifyController {
	
	@Autowired
	RabbitTemplate rabbit;
	
	@RequestMapping("/send")
	public String send() throws IOException {
		MessageProperties properties = new MessageProperties();
		properties.setHeader("order_type", "custorm_order");
		
		Message message = new Message("hello world".getBytes(), properties);
//		rabbit.send("integle.exchange", "info", message);
		
		Order order = new Order(1, "O002231", 12.3f);
		rabbit.convertAndSend("integle.exchange", "info", order);
		return "ok";
	}
	
	@RequestMapping("/send-multi")
	public String sendMulti() {
		Order order = new Order(1, "O002231", 12.3f);
		rabbit.convertAndSend("integle.exchange", "multi.method", order);
		
		Bar bar = new Bar(3, "baba");
		rabbit.convertAndSend("integle.exchange", "multi.method", bar);
		return "ok";
	}
	
	@Bean
	Exchange exchange() {
		Exchange exchange = ExchangeBuilder.directExchange("integle.exchange").build();
		return exchange;
	}
	
}
