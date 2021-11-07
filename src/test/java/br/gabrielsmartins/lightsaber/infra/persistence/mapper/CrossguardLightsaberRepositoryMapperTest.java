package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import static br.gabrielsmartins.lightsaber.domain.support.CrossguardLightsaberSupport.defaultCrossguardLightsaber;
import static br.gabrielsmartins.lightsaber.infra.persistence.entity.support.CrossguardLightsaberEntitySupport.defaultCrossguardLightsaberEntity;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrossguardLightsaberRepositoryMapperTest {

	private CrossguardLightsaberRepositoryMapper mapper;
	
	@BeforeEach
	public void setup() {
		this.mapper = new CrossguardLightsaberRepositoryMapper();
	}
	
	@Test
	@DisplayName("Given Lightsaber When Map Then Return Lightsaber Entity")
	public void givenLightsaberWhenMapThenReturnLightsaberEntity() {
		
		var lightsaber = defaultCrossguardLightsaber().build();
		
		var lightsaberEntity = this.mapper.mapToEntity(lightsaber);
		
		assertThat(lightsaberEntity).hasNoNullFieldsOrProperties();
		assertThat(lightsaberEntity.getId()).isEqualTo(lightsaber.getId());
		assertThat(lightsaberEntity.getSerialNumber()).isEqualTo(lightsaber.getSerialNumber());
		assertThat(lightsaberEntity.getType().getSource()).isEqualTo(lightsaber.getType());
		assertThat(lightsaberEntity.getStatus().getSource()).isEqualTo(lightsaber.getStatus());
		assertThat(lightsaberEntity.getDescription()).isEqualTo(lightsaber.getDescription());
		assertThat(lightsaberEntity.getCreatedAt()).isEqualTo(lightsaber.getCreatedAt());
		assertThat(lightsaberEntity.getHistory().size()).isEqualTo(lightsaber.getHistory().size());
		assertThat(lightsaberEntity.getSpecifications().size()).isEqualTo(lightsaber.getSpecifications().size());
	}

	
	@Test
	@DisplayName("Given Lightsaber Entity When Map Then Return Lightsaber")
	public void givenLightsaberEntityWhenMapThenReturnLightsaber() {
		
		var lightsaberEntity = defaultCrossguardLightsaberEntity().build();
		
		var lightsaber = this.mapper.mapToDomain(lightsaberEntity);
		
		assertThat(lightsaber).hasNoNullFieldsOrProperties();
		assertThat(lightsaber.getId()).isEqualTo(lightsaberEntity.getId());
		assertThat(lightsaber.getSerialNumber()).isEqualTo(lightsaberEntity.getSerialNumber());
		assertThat(lightsaber.getType()).isEqualTo(lightsaberEntity.getType().getSource());
		assertThat(lightsaber.getStatus()).isEqualTo(lightsaberEntity.getStatus().getSource());
		assertThat(lightsaber.getDescription()).isEqualTo(lightsaberEntity.getDescription());
		assertThat(lightsaber.getCreatedAt()).isEqualTo(lightsaberEntity.getCreatedAt());
		assertThat(lightsaber.getHistory().size()).isEqualTo(lightsaberEntity.getHistory().size());
		assertThat(lightsaber.getSpecifications().size()).isEqualTo(lightsaberEntity.getSpecifications().size());
	}
	
}
