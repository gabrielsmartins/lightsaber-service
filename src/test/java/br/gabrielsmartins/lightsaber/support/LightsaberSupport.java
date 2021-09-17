package br.gabrielsmartins.lightsaber.support;

import java.time.LocalDateTime;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberStatus;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LightsaberSupport {

	public static Lightsaber.LightsaberBuilder defaultLightsaber(){
		return Lightsaber.builder()
				.withId(1L)
				.withCreatedAt(LocalDateTime.now())
				.withDescription("Red lightsaber")
				.withSerialNumber(UUID.randomUUID())
				.withType(LightsaberType.AUTOMATIC)
				.withStatus(LightsaberStatus.READY);
	}
	
}
