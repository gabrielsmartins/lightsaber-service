package br.gabrielsmartins.lightsaber.infra.persistence.support;

import java.time.LocalDateTime;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.DoubleBladedLightsaberEntity;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberStatusData;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberTypeData;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DoubleBladedLightsaberSupport {
	
	public static DoubleBladedLightsaberEntity.DoubleBladedLightsaberEntityBuilder<?, ?> defaultDoubleBladedLightsaberEntity(){
		return DoubleBladedLightsaberEntity.builder()
				.withId(2L)
				.withCreatedAt(LocalDateTime.now())
				.withDescription("Red lightsaber")
				.withSerialNumber(UUID.randomUUID())
				.withType(LightsaberTypeData.DOUBLE_BLADED)
				.withStatus(LightsaberStatusData.READY)
				.withMinEnergyLevel(5.00)
				.withMaxEnergyLevel(10.00);
	}

}
