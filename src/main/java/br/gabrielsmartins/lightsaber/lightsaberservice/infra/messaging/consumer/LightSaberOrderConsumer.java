package br.gabrielsmartins.lightsaber.lightsaberservice.infra.messaging.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LightSaberOrderConsumer {
	
	@JmsListener(destination = "${app.messaging.input.queue.order}")
	public void consume(String message) {
		log.info("Receving message: {}", message);
	}

}
