package br.gabrielsmartins.lightsaber.infra.messaging.consumer.mapper;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberStatus;
import br.gabrielsmartins.lightsaber.infra.messaging.consumer.message.LightsaberConsumerMessage;

@Component
public class LightsaberOrderConsumerMapper {
	
	public Lightsaber mapToDomain(LightsaberConsumerMessage message) {
		final var mapper = new ModelMapper();
		 var lightsaber = mapper.map(message, Lightsaber.class);
		 lightsaber.setCreatedAt(LocalDateTime.now());
		 lightsaber.setStatus(LightsaberStatus.READY);
		 return lightsaber;
	}

}
