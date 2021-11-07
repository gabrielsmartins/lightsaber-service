package br.gabrielsmartins.lightsaber.domain;

import static br.gabrielsmartins.lightsaber.domain.support.CrossguardLightsaberSupport.defaultCrossguardLightsaber;
import static br.gabrielsmartins.lightsaber.domain.support.CrossguardLightsaberSupport.defaultSpecification;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrossguardLightsaberTest {

	@Test
	@DisplayName("Given Specification When Add Then Return Specifications Size")
	public void givenSpecificationWhenAddThenReturnSpecificationsSize() {
		var lightsaber = defaultCrossguardLightsaber().build();
		
		var specification = defaultSpecification().build();
		Integer specificationsSize = lightsaber.addSpecification(specification);
		
		assertThat(specificationsSize).isEqualTo(1);
		assertThat(lightsaber.getSpecifications().size()).isEqualTo(1);
		assertThat(specification.getLightsaber()).isEqualTo(lightsaber);
	}
	
}
