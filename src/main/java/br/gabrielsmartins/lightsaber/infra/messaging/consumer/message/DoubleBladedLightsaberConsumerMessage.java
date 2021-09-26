package br.gabrielsmartins.lightsaber.infra.messaging.consumer.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(setterPrefix = "with")
@ToString
@Getter
@Setter
public class DoubleBladedLightsaberConsumerMessage extends LightsaberConsumerMessage {

	@JsonProperty("min_energy_level")
	private Double minEnergyLevel;
	
	@JsonProperty("max_energy_level")
	private Double maxEnergyLevel;
}
