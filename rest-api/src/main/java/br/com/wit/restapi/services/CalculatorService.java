package br.com.wit.restapi.services;

import java.math.BigDecimal;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.wit.restapi.config.RabbitMQConfig;
import br.com.wit.restapi.dto.OperacaoRestDTO;
import br.com.wit.restapi.enums.OperacaoEnum;

@Service
public class CalculatorService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public BigDecimal sum(BigDecimal a, BigDecimal b, String token) {

		Message message = getMessage(a, b, token, OperacaoEnum.SUM);

		return (BigDecimal) rabbitTemplate.convertSendAndReceive(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.ROUTING_KEY, message);
	}

	public BigDecimal subtract(BigDecimal a, BigDecimal b, String token) {
		Message message = getMessage(a, b, token, OperacaoEnum.SUBTRACT);

		return (BigDecimal) rabbitTemplate.convertSendAndReceive(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.ROUTING_KEY, message);
	}

	public BigDecimal multiply(BigDecimal a, BigDecimal b, String token) {
		Message message = getMessage(a, b, token, OperacaoEnum.MULTIPLY);

		return (BigDecimal) rabbitTemplate.convertSendAndReceive(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.ROUTING_KEY, message);
	}

	public BigDecimal divide(BigDecimal a, BigDecimal b, String token) {
		Message message = getMessage(a, b, token, OperacaoEnum.DIVIDE);

		return (BigDecimal) rabbitTemplate.convertSendAndReceive(RabbitMQConfig.EXCHANGE_NAME,
				RabbitMQConfig.ROUTING_KEY, message);

	}

	private Message getMessage(BigDecimal a, BigDecimal b, String token, OperacaoEnum operacao) {

		String json = getJsonOfOperacaoDto(a, b, operacao);

		return MessageBuilder.withBody(json.getBytes()).setHeader("token", token).build();
	}

	private String getJsonOfOperacaoDto(BigDecimal a, BigDecimal b, OperacaoEnum operacao) {
		try {
			OperacaoRestDTO operacaoDto = OperacaoRestDTO.builder().valueA(a).valueB(b).operacao(operacao).build();
			return new ObjectMapper().writeValueAsString(operacaoDto);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("erro ao converter objeto para json");
		}
	}

}
