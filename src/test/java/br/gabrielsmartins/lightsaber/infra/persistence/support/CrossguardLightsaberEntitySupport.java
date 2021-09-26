package br.gabrielsmartins.lightsaber.infra.persistence.support;

import java.time.LocalDateTime;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.CrossguardLightsaberEntity;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberStatusData;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberTypeData;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CrossguardLightsaberEntitySupport {
	
	public static CrossguardLightsaberEntity.CrossguardLightsaberEntityBuilder<?, ?> defaultCrossguardLightsaberEntity(){
		return CrossguardLightsaberEntity.builder()
				.withId(2L)
				.withCreatedAt(LocalDateTime.now())
				.withDescription("Red lightsaber")
				.withSerialNumber(UUID.randomUUID())
				.withType(LightsaberTypeData.DOUBLE_BLADED)
				.withStatus(LightsaberStatusData.READY)
				.withModel("Foo");
	}

}
