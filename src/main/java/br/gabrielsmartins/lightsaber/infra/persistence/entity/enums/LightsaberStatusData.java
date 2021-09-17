package br.gabrielsmartins.lightsaber.infra.persistence.entity.enums;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberStatusData {
	
	READY('R',"READY"),
	MAINTENANCE('M',"MAINTENANCE"),
	DEPRACATED('D',"DEPRECATED");
	
	private final Character code;
	private final String description;
	
	
	public static LightsaberStatusData fromValue(Character code) {
		return Stream.of(LightsaberStatusData.values())
				     .filter(s -> s.getCode().equals(code))
				     .findFirst()
				     .orElse(null);
	}

}
