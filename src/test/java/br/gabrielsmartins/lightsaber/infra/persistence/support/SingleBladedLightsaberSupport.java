package br.gabrielsmartins.lightsaber.infra.persistence.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.SingleBladedLightsaberEntity;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberStatusData;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberTypeData;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SingleBladedLightsaberSupport {

	public static SingleBladedLightsaberEntity.SingleBladedLightsaberEntityBuilder<?, ?> defaultSingleBladedLightsaberEntity(){
		return SingleBladedLightsaberEntity.builder()
				.withId(1L)
				.withCreatedAt(LocalDateTime.now())
				.withDescription("Red lightsaber")
				.withSerialNumber(UUID.randomUUID())
				.withType(LightsaberTypeData.SINGLE_BLADED)
				.withStatus(LightsaberStatusData.READY)
				.withDueDate(LocalDate.now())
				.withManufacturerId(UUID.randomUUID());
	}
	
}
