package br.gabrielsmartins.lightsaber.infra.messaging.consumer;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.application.ProcessLightsaberService;
import br.gabrielsmartins.lightsaber.infra.messaging.consumer.mapper.LightsaberOrderConsumerMapper;
import br.gabrielsmartins.lightsaber.infra.messaging.consumer.message.LightsaberConsumerMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class LightSaberConsumer {

	private final ProcessLightsaberService service;
	private final LightsaberOrderConsumerMapper mapper;

	@JmsListener(destination = "${app.messaging.input}")
	public void consume(@Headers Map<String, Object> headers, @Payload LightsaberConsumerMessage message) {
		log.info("Receiving message: {},{}", headers,message);
		final var lightsaber = this.mapper.mapToDomain(message);
		log.info("Processing lightsaber: {}", lightsaber);
		final var processedLightsaber = this.service.process(lightsaber);
		log.info("Lightsaber processed sucessfully: {}", processedLightsaber);
	}

}
