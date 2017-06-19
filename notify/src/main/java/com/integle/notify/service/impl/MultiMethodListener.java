package com.integle.notify.service.impl;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.integle.notify.beans.Bar;
import com.integle.notify.beans.Order;

/**
 * 多方法监听器
 */
@Component
@RabbitListener(bindings=@QueueBinding(
		key="multi.method",
		exchange = @Exchange(value = "integle.exchange"), 
		value = @Queue))
public class MultiMethodListener {

	@RabbitHandler
	public void process(Order order) {
		System.out.println("这是订单监听");
		System.out.println(order);
	}
	
	@RabbitHandler
	public void process(Bar bar) {
		System.out.println("这是bar监听");
		System.out.println(bar);
	}
}
