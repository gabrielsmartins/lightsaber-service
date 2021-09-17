package br.gabrielsmartins.lightsaber.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.domain.enums.LightsaberStatus;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Data
@EqualsAndHashCode(of = "id")
public class Lightsaber {
	
	private Long id;
	private UUID serialNumber;
	private String description;
	private LightsaberType type;
	private LocalDateTime createdAt;
	private LightsaberStatus status;

}
