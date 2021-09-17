package br.gabrielsmartins.lightsaber.infra.messaging.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.domain.LightsaberPublisher;
import br.gabrielsmartins.lightsaber.infra.messaging.config.MessageProperties;
import br.gabrielsmartins.lightsaber.infra.messaging.producer.mapper.LightsaberOrderProducerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class LightsaberMessagePublisher implements LightsaberPublisher {
	
	private final JmsTemplate template;
	private final LightsaberOrderProducerMapper mapper;
	private final MessageProperties messageProperties;

	@Override
	public void publish(Lightsaber lightsaber) {
		var destination = messageProperties.getOutput();
		var message = this.mapper.mapToMessage(lightsaber);
		log.info("Sending message: {} to destination: {}", message, destination);
		this.template.convertAndSend(destination, message);
		log.info("Message sent sucessfully: {}", message);
	}

}
