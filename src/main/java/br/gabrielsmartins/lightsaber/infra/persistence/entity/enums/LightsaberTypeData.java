package br.gabrielsmartins.lightsaber.infra.persistence.entity.enums;

import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberTypeData {

	SINGLE_BLADED("SB","SINGLE BLADED"),
	DOUBLE_BLADED("DB","DOUBLE BLADED"),
	CROSSGUARD("CG","CROSSGUARD");
	
	private final String code;
	private final String description;
	
	public static LightsaberTypeData fromValue(String code) {
		return Stream.of(LightsaberTypeData.values())
				      .filter(type -> type.getCode().equals(code))
				      .findFirst()
				      .orElse(null);
	}
	
}
