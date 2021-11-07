package br.gabrielsmartins.lightsaber.domain.support;

import java.time.LocalDateTime;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.domain.DoubleBladedLightsaber;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberStatus;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DoubleBladedLightsaberSupport {
	
	public static DoubleBladedLightsaber.DoubleBladedLightsaberBuilder<?, ?> defaultDoubleBladedLightsaber(){
		return DoubleBladedLightsaber.builder()
				.withId(2L)
				.withCreatedAt(LocalDateTime.now())
				.withDescription("Red lightsaber")
				.withSerialNumber(UUID.randomUUID())
				.withType(LightsaberType.DOUBLE_BLADED)
				.withStatus(LightsaberStatus.READY)
				.withMinEnergyLevel(5.00)
				.withMaxEnergyLevel(10.00);
	}

}
