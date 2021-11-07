package br.gabrielsmartins.lightsaber.domain.support;

import java.time.LocalDateTime;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.domain.CrossguardLightsaber;
import br.gabrielsmartins.lightsaber.domain.CrossguardLightsaber.CrossguardLightsaberSpecification;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberStatus;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CrossguardLightsaberSupport {
	
	public static CrossguardLightsaber.CrossguardLightsaberBuilder<?, ?> defaultCrossguardLightsaber(){
		return CrossguardLightsaber.builder()
				.withId(2L)
				.withCreatedAt(LocalDateTime.now())
				.withDescription("Red lightsaber")
				.withSerialNumber(UUID.randomUUID())
				.withType(LightsaberType.CROSSGUARD)
				.withStatus(LightsaberStatus.READY)
				.withModel("Foo");
	}

	public static CrossguardLightsaberSpecification.CrossguardLightsaberSpecificationBuilder defaultSpecification(){
		return CrossguardLightsaberSpecification.builder()
												.withCode("XXX")
												.withDescription("Foo")
												.withPriority(1);
	}
}
