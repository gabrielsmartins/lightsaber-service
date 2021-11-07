package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import static br.gabrielsmartins.lightsaber.domain.support.SingleBladedLightsaberSupport.defaultSingleBladedLightsaber;
import static br.gabrielsmartins.lightsaber.infra.persistence.entity.support.SingleBladedLightsaberSupport.defaultSingleBladedLightsaberEntity;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SingleBladedLightsaberRepositoryMapperTest {

	private SingleBladedLightsaberRepositoryMapper mapper;
	
	@BeforeEach
	public void setup() {
		this.mapper = new SingleBladedLightsaberRepositoryMapper();
	}
	
	@Test
	@DisplayName("Given Lightsaber When Map Then Return Lightsaber Entity")
	public void givenLightsaberWhenMapThenReturnLightsaberEntity() {
		
		var lightsaber = defaultSingleBladedLightsaber().build();
		
		var lightsaberEntity = this.mapper.mapToEntity(lightsaber);
		
		assertThat(lightsaberEntity).hasNoNullFieldsOrProperties();
		assertThat(lightsaberEntity.getId()).isEqualTo(lightsaber.getId());
		assertThat(lightsaberEntity.getSerialNumber()).isEqualTo(lightsaber.getSerialNumber());
		assertThat(lightsaberEntity.getType().getSource()).isEqualTo(lightsaber.getType());
		assertThat(lightsaberEntity.getStatus().getSource()).isEqualTo(lightsaber.getStatus());
		assertThat(lightsaberEntity.getDescription()).isEqualTo(lightsaber.getDescription());
		assertThat(lightsaberEntity.getCreatedAt()).isEqualTo(lightsaber.getCreatedAt());
		assertThat(lightsaberEntity.getHistory().size()).isEqualTo(lightsaber.getHistory().size());
		assertThat(lightsaberEntity.getDueDate()).isEqualTo(lightsaber.getDueDate());
		assertThat(lightsaberEntity.getManufacturerId()).isEqualTo(lightsaber.getManufacturerId());
	}

	
	@Test
	@DisplayName("Given Lightsaber Entity When Map Then Return Lightsaber")
	public void givenLightsaberEntityWhenMapThenReturnLightsaber() {
		
		var lightsaberEntity = defaultSingleBladedLightsaberEntity().build();
		
		var lightsaber = this.mapper.mapToDomain(lightsaberEntity);
		
		assertThat(lightsaber).hasNoNullFieldsOrProperties();
		assertThat(lightsaber.getId()).isEqualTo(lightsaberEntity.getId());
		assertThat(lightsaber.getSerialNumber()).isEqualTo(lightsaberEntity.getSerialNumber());
		assertThat(lightsaber.getType()).isEqualTo(lightsaberEntity.getType().getSource());
		assertThat(lightsaber.getStatus()).isEqualTo(lightsaberEntity.getStatus().getSource());
		assertThat(lightsaber.getDescription()).isEqualTo(lightsaberEntity.getDescription());
		assertThat(lightsaber.getCreatedAt()).isEqualTo(lightsaberEntity.getCreatedAt());
		assertThat(lightsaber.getHistory().size()).isEqualTo(lightsaberEntity.getHistory().size());
		assertThat(lightsaber.getDueDate()).isEqualTo(lightsaberEntity.getDueDate());
		assertThat(lightsaber.getManufacturerId()).isEqualTo(lightsaberEntity.getManufacturerId());
	}
}
