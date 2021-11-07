package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import static br.gabrielsmartins.lightsaber.domain.support.CrossguardLightsaberSupport.defaultCrossguardLightsaber;
import static br.gabrielsmartins.lightsaber.infra.persistence.entity.support.CrossguardLightsaberEntitySupport.defaultCrossguardLightsaberEntity;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.RequiredArgsConstructor;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LightsaberRepositoryMapperFactoryTest {

	private final LightsaberRepositoryMapperFactory factory;
	
	@Test
	@DisplayName("Given Lightsaber When Is Valid Then Return Mapper")
	public void givenLightsaberWhenIsValidThenReturnMapper() {
		
		var lightsaber = defaultCrossguardLightsaber().build();
		
		ILightsaberRepositoryMapper<?, ?> mapper = this.factory.createMapper(lightsaber);
		assertThat(mapper).isNotNull();
		assertThat(mapper).isInstanceOf(CrossguardLightsaberRepositoryMapper.class);
	}
	
	@Test
	@DisplayName("Given Lightsaber Entity When Is Valid Then Return Mapper")
	public void givenLightsaberEntityWhenIsValidThenReturnMapper() {
		
		var lightsaberEntity = defaultCrossguardLightsaberEntity().build();
		
		ILightsaberRepositoryMapper<?, ?> mapper = this.factory.createMapper(lightsaberEntity);
		assertThat(mapper).isNotNull();
		assertThat(mapper).isInstanceOf(CrossguardLightsaberRepositoryMapper.class);
	}
	
}
