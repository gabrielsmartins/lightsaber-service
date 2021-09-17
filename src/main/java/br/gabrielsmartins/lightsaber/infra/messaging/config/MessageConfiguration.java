package br.gabrielsmartins.lightsaber.infra.messaging.config;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.JmsProperties.AcknowledgeMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import br.gabrielsmartins.lightsaber.infra.messaging.converter.LightsaberMessageConverter;

@Configuration
public class MessageConfiguration {

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		var factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(jacksonJmsMessageConverter());
		factory.setSessionAcknowledgeMode(AcknowledgeMode.AUTO.getMode());
		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		var converter = new LightsaberMessageConverter();
		converter.setTargetType(MessageType.TEXT);
		return converter;
	}

}
