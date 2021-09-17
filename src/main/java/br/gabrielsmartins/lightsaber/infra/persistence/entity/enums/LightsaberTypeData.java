package br.gabrielsmartins.lightsaber.infra.persistence.entity.enums;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberTypeData {

	MANUAL('M',"MANUAL"),
	SEMIAUTOMATIC('S',"SEMIAUTOMATIC"),
	AUTOMATIC('A',"AUTOMATIC");
	
	private final Character code;
	private final String description;
	
	public static LightsaberTypeData fromValue(Character code) {
		return Stream.of(LightsaberTypeData.values())
				      .filter(type -> type.getCode().equals(code))
				      .findFirst()
				      .orElse(null);
	}
	
}
