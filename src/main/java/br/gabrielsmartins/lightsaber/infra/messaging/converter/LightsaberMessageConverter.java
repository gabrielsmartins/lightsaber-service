package br.gabrielsmartins.lightsaber.infra.messaging.converter;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConversionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.gabrielsmartins.lightsaber.infra.messaging.consumer.message.LightsaberConsumerMessage;

public class LightsaberMessageConverter extends MappingJackson2MessageConverter {
	
	private final ObjectMapper mapper;
	
	public LightsaberMessageConverter() {
		this.mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
	}
	
	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		try {
			if(message instanceof TextMessage) {
				var body = ((TextMessage) message).getBody(String.class);
				return mapper.readValue(body, LightsaberConsumerMessage.class);
			}
			throw new MessageConversionException("Invalid content message");
		} catch (JsonProcessingException | JMSException e) {
			throw new MessageConversionException("Invalid content message", e);
		}
	}

	@Override
	protected TextMessage mapToTextMessage(Object object, Session session, ObjectWriter objectWriter)throws JMSException, IOException {
		var content = this.mapper.writeValueAsString(object);
		return session.createTextMessage(content);
	}
	
	
}
