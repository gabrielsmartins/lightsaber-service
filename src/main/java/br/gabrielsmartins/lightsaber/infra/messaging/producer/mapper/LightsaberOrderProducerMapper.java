package br.gabrielsmartins.lightsaber.infra.messaging.producer.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.infra.messaging.producer.message.LightsaberProducerMessage;

@Component
public class LightsaberOrderProducerMapper {
	
	public LightsaberProducerMessage mapToMessage(Lightsaber lightsaber) {
		final var mapper = new ModelMapper();
		return mapper.map(lightsaber, LightsaberProducerMessage.class);
	}

}
