package br.gabrielsmartins.lightsaber.infra.persistence.entity.enums;

import java.util.stream.Stream;

import br.gabrielsmartins.lightsaber.domain.enums.LightsaberType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberTypeData {

	SINGLE_BLADED("SB",LightsaberType.SINGLE_BLADED),
	DOUBLE_BLADED("DB",LightsaberType.DOUBLE_BLADED),
	CROSSGUARD("CG",LightsaberType.CROSSGUARD);
	
	private final String code;
	private final LightsaberType source;
	
	public static LightsaberTypeData fromValue(String code) {
		return Stream.of(LightsaberTypeData.values())
				      .filter(type -> type.getCode().equals(code))
				      .findFirst()
				      .orElse(null);
	}
	
	public static LightsaberTypeData fromValue(LightsaberType source) {
		return Stream.of(LightsaberTypeData.values())
				      .filter(type -> type.getSource().equals(source))
				      .findFirst()
				      .orElse(null);
	}
}
