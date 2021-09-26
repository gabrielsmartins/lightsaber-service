package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import static br.gabrielsmartins.lightsaber.infra.persistence.support.CrossguardLightsaberEntitySupport.defaultCrossguardLightsaberEntity;
import static br.gabrielsmartins.lightsaber.infra.persistence.support.DoubleBladedLightsaberSupport.defaultDoubleBladedLightsaberEntity;
import static br.gabrielsmartins.lightsaber.infra.persistence.support.SingleBladedLightsaberSupport.defaultSingleBladedLightsaberEntity;

import static br.gabrielsmartins.lightsaber.support.CrossguardLightsaberSupport.defaultCrossguardLightsaber;
import static br.gabrielsmartins.lightsaber.support.DoubleBladedLightsaberSupport.defaultDoubleBladedLightsaber;
import static br.gabrielsmartins.lightsaber.support.SingleBladedLightsaberSupport.defaultSingleBladedLightsaber;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.gabrielsmartins.lightsaber.domain.CrossguardLightsaber;
import br.gabrielsmartins.lightsaber.domain.DoubleBladedLightsaber;
import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.domain.SingleBladedLightsaber;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.CrossguardLightsaberEntity;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.DoubleBladedLightsaberEntity;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.LightsaberEntity;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.SingleBladedLightsaberEntity;

public class LightsaberRepositoryMapperTest {
	
	private LightsaberRepositoryMapper mapper;
	
	@BeforeEach
	public void setup() {
		this.mapper = new LightsaberRepositoryMapper();
	}

	@Test
	@DisplayName("Given Single Bladed Lightsaber When Map Then Return Single Bladed Lightsaber Entity")
	public void givenSingleBladedLightsaberWhenMapThenReturnSingleBladedLightsaberEntity() {
		
		var lightsaber = defaultSingleBladedLightsaber().build();
		
		var lightsaberEntity = this.mapper.mapToEntity(lightsaber);
		
		assertCommonAttributes(lightsaber, lightsaberEntity);
		assertThat(((SingleBladedLightsaberEntity) lightsaberEntity).getDueDate()).isEqualTo(lightsaber.getDueDate());
		assertThat(((SingleBladedLightsaberEntity) lightsaberEntity).getCreatedAt()).isEqualTo(lightsaber.getCreatedAt());
	}

	
	@Test
	@DisplayName("Given Single Bladed Lightsaber Entity When Map Then Return Single Bladed Lightsaber")
	public void givenSingleBladedLightsaberEntityWhenMapThenReturnSingleBladedLightsaber() {
		
		var lightsaberEntity = defaultSingleBladedLightsaberEntity().build();
		
		var lightsaber = this.mapper.mapToDomain(lightsaberEntity);
		
		assertCommonAttributes(lightsaber, lightsaberEntity);
		assertThat(((SingleBladedLightsaber) lightsaber).getDueDate()).isEqualTo(lightsaberEntity.getDueDate());
		assertThat(((SingleBladedLightsaber) lightsaber).getCreatedAt()).isEqualTo(lightsaberEntity.getCreatedAt());
	}
	
	
	@Test
	@DisplayName("Given Double Bladed Lightsaber When Map Then Return Double Bladed Lightsaber Entity")
	public void givenDoubleBladedLightsaberWhenMapThenReturnDoubleBladedLightsaberEntity() {
		
		var lightsaber = defaultDoubleBladedLightsaber().build();
		
		var lightsaberEntity = this.mapper.mapToEntity(lightsaber);
		
		assertCommonAttributes(lightsaber, lightsaberEntity);
		assertThat(((DoubleBladedLightsaberEntity) lightsaberEntity).getMinEnergyLevel()).isEqualTo(lightsaber.getMinEnergyLevel());
		assertThat(((DoubleBladedLightsaberEntity) lightsaberEntity).getMaxEnergyLevel()).isEqualTo(lightsaber.getMaxEnergyLevel());
	}
	
	
	@Test
	@DisplayName("Given Double Bladed Lightsaber Entity When Map Then Return Double Bladed Lightsaber")
	public void givenDoubleBladedLightsaberEntityWhenMapThenReturnDoubleBladedLightsaber() {
		
		var lightsaberEntity = defaultDoubleBladedLightsaberEntity().build();
		
		var lightsaber = this.mapper.mapToDomain(lightsaberEntity);
		
		assertCommonAttributes(lightsaber, lightsaberEntity);
		assertThat(((DoubleBladedLightsaber) lightsaber).getMinEnergyLevel()).isEqualTo(lightsaberEntity.getMinEnergyLevel());
		assertThat(((DoubleBladedLightsaber) lightsaber).getMaxEnergyLevel()).isEqualTo(lightsaberEntity.getMaxEnergyLevel());
	}
	
	@Test
	@DisplayName("Given Crossguard Lightsaber When Map Then Return Crossguard Lightsaber Entity")
	public void givenCrossguardLightsaberWhenMapThenReturnCrossguardLightsaberEntity() {
		
		var lightsaber = defaultCrossguardLightsaber().build();
		
		var lightsaberEntity = this.mapper.mapToEntity(lightsaber);
		
		assertCommonAttributes(lightsaber, lightsaberEntity);
		assertThat(((CrossguardLightsaberEntity) lightsaberEntity).getModel()).isEqualTo(lightsaber.getModel());
		assertThat(((CrossguardLightsaberEntity) lightsaberEntity).getSpecifications().size()).isEqualTo(lightsaber.getSpecifications().size());
	}
	
	
	@Test
	@DisplayName("Given Crossguard Lightsaber Entity When Map Then Return Crossguard Lightsaber")
	public void givenCrossguardLightsaberEntityWhenMapThenReturnCrossguardLightsaber() {
		
		var lightsaberEntity = defaultCrossguardLightsaberEntity().build();
		
		var lightsaber = this.mapper.mapToDomain(lightsaberEntity);
		
		assertCommonAttributes(lightsaber, lightsaberEntity);
		assertThat(((CrossguardLightsaber) lightsaber).getModel()).isEqualTo(lightsaberEntity.getModel());
		assertThat(((CrossguardLightsaber) lightsaber).getSpecifications().size()).isEqualTo(lightsaberEntity.getSpecifications().size());
	}
	
	private void assertCommonAttributes(Lightsaber lightsaber, LightsaberEntity lightsaberEntity) {
		assertThat(lightsaberEntity).hasNoNullFieldsOrProperties();
		assertThat(lightsaberEntity.getId()).isEqualTo(lightsaber.getId());
		assertThat(lightsaberEntity.getSerialNumber()).isEqualTo(lightsaber.getSerialNumber());
		assertThat(lightsaberEntity.getType()).isEqualTo(lightsaber.getType());
		assertThat(lightsaberEntity.getStatus()).isEqualTo(lightsaber.getStatus());
		assertThat(lightsaberEntity.getDescription()).isEqualTo(lightsaber.getDescription());
		assertThat(lightsaberEntity.getCreatedAt()).isEqualTo(lightsaber.getCreatedAt());
		assertThat(lightsaberEntity.getHistory().size()).isEqualTo(lightsaber.getHistory().size());
	}
}
