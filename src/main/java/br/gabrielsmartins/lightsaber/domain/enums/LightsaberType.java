package br.gabrielsmartins.lightsaber.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberType {

	MANUAL("MANUAL"),
	SEMIAUTOMATIC("SEMIAUTOMATIC"),
	AUTOMATIC("AUTOMATIC");
	
	private final String description;
	
}
