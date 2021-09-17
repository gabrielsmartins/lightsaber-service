package br.gabrielsmartins.lightsaber.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LightsaberStatus {
	
	READY("READY"),
	MAINTENANCE("MAINTENANCE"),
	DEPRACATED("DEPRECATED");
	
	private final String description;

}
