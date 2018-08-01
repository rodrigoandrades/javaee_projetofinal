package com.javaee.rodrigoandrades.projeto_final.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaee.rodrigoandrades.projeto_final.config.RabbitMQConfig;
import com.javaee.rodrigoandrades.projeto_final.domain.Venda;

@Service
public class VendaService {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void solicitaVenda(Venda venda) {
		this.rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_MESSAGES, venda);
	}
}
