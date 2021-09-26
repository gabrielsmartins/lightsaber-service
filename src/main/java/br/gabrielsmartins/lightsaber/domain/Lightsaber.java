package br.gabrielsmartins.lightsaber.domain;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import br.gabrielsmartins.lightsaber.domain.enums.LightsaberStatus;
import br.gabrielsmartins.lightsaber.domain.enums.LightsaberType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;



@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Setter
@SuperBuilder(setterPrefix = "with")
public abstract class Lightsaber {
	
	protected Long id;
	protected UUID serialNumber;
	protected String description;
	protected LightsaberType type;
	protected LocalDateTime createdAt;
	protected LightsaberStatus status;
	
	@Getter(value = AccessLevel.NONE)
	@Builder.Default
	protected final Map<LocalDateTime, LightsaberStatus> history = new LinkedHashMap<>();
	
	public Map<LocalDateTime, LightsaberStatus> getHistory(){
		return Collections.unmodifiableMap(this.history);
	}
	

}
