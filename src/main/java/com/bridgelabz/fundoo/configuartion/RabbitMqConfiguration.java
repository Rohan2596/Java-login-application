package com.bridgelabz.fundoo.configuartion;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

	@Value("${fundoo.rabbitmq.queue}")
	String queueName;

	@Value("${fundoo.rabbitmq.exchange}")
	String exchange;

	@Value("${fundoo.rabbitmq.routingkey}")
	private String routingkey;
	
	@Value("${elastic.rabbitmq.queue}")
	String queueName1;


	@Value("${elastic.rabbitmq.routingkey}")
	private String routingkey1;
	
	
	

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	@Bean
	DirectExchange exchange1() {
		return new DirectExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	Queue queue1() {
		return new Queue(queueName1, false);
	}
	
	@Bean
	Binding binding1(Queue queue1, DirectExchange exchange1) {
		return BindingBuilder.bind(queue1).to(exchange1).with(routingkey1);
	}
}