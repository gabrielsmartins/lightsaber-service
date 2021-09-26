package br.gabrielsmartins.lightsaber.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder(setterPrefix = "with")
public class DoubleBladedLightsaber extends Lightsaber {
	
	private Double minEnergyLevel;
	private Double maxEnergyLevel;

}
