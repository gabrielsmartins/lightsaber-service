package br.gabrielsmartins.lightsaber.infra.persistence.entity.enums;

import java.util.stream.Stream;

import br.gabrielsmartins.lightsaber.domain.enums.LightsaberStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberStatusData {
	
	READY('R',LightsaberStatus.READY),
	MAINTENANCE('M',LightsaberStatus.MAINTENANCE),
	DEPRACATED('D',LightsaberStatus.DEPRECATED);
	
	private final Character code;
	private final LightsaberStatus source;
	
	
	public static LightsaberStatusData fromValue(Character code) {
		return Stream.of(LightsaberStatusData.values())
				     .filter(s -> s.getCode().equals(code))
				     .findFirst()
				     .orElse(null);
	}

	public static LightsaberStatusData fromValue(LightsaberStatus source) {
		return Stream.of(LightsaberStatusData.values())
				     .filter(s -> s.getSource().equals(source))
				     .findFirst()
				     .orElse(null);
	}
}
