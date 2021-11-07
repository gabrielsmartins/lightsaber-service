package br.gabrielsmartins.lightsaber.domain.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.domain.SingleBladedLightsaber;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberStatus;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SingleBladedLightsaberSupport {

	public static SingleBladedLightsaber.SingleBladedLightsaberBuilder<?, ?> defaultSingleBladedLightsaber(){
		return SingleBladedLightsaber.builder()
				.withId(1L)
				.withCreatedAt(LocalDateTime.now())
				.withDescription("Red lightsaber")
				.withSerialNumber(UUID.randomUUID())
				.withType(LightsaberType.SINGLE_BLADED)
				.withStatus(LightsaberStatus.READY)
				.withDueDate(LocalDate.now())
				.withManufacturerId(UUID.randomUUID());
	}
	
}
