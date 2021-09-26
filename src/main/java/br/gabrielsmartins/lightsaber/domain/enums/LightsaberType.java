package br.gabrielsmartins.lightsaber.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberType {

	SINGLE_BLADED("SB","SINGLE BLADED"),
	DOUBLE_BLADED("DB","DOUBLE BLADED"),
	CROSSGUARD("CG","CROSSGUARD");
	
	private final String prefix;
	private final String description;
	
}
