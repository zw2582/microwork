package com.integle.notify.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.integle.notify.beans.Order;

/**
 * 订单监听器
 */
@Component
public class OrderListener {

	@RabbitListener(bindings=@QueueBinding(
			exchange = @Exchange(value = "integle.exchange"), 
			value = @Queue,
			key="info"))
	public void process(Order message) {
		System.out.println(message);
	}
}
