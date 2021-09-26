package br.gabrielsmartins.lightsaber.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberStatus {
	
	READY('R',"READY"),
	MAINTENANCE('M',"MAINTENANCE"),
	DEPRECATED('D',"DEPRECATED");
	
	private final Character prefix;
	private final String description;

}
