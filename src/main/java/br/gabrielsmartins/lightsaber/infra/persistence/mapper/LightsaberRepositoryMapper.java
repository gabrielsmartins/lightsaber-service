package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.LightsaberEntity;

@Component
public class LightsaberRepositoryMapper {
	
	public LightsaberEntity mapToEntity(final Lightsaber lightsaber) {
		final var mapper = new ModelMapper();
		return mapper.map(lightsaber, LightsaberEntity.class);
	}
	
	public Lightsaber mapToDomain(final LightsaberEntity lightsaberEntity) {
		final var mapper = new ModelMapper();
		return mapper.map(lightsaberEntity,  Lightsaber.class);
	}
	

}
