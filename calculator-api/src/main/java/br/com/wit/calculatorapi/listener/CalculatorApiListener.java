package br.com.wit.calculatorapi.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.wit.calculatorapi.config.RabbitMQConfig;
import br.com.wit.calculatorapi.dto.OperacaoCalculatorDTO;
import br.com.wit.calculatorapi.service.OperacaoService;

@Component
public class CalculatorApiListener {
	
	private static final Logger log = LoggerFactory.getLogger(CalculatorApiListener.class);
	@Autowired
	private OperacaoService operacaoService;
	
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receive(Message message , @Header("token") String token) {
    	
    	String fileBody= new String(message.getBody());
    	
    	log.info("Message " + fileBody+ " token:"+token);
		try {
			ObjectMapper mapper = new ObjectMapper();
			OperacaoCalculatorDTO operacao = mapper.readValue(fileBody, OperacaoCalculatorDTO.class);
			operacaoService.calcular(operacao);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

