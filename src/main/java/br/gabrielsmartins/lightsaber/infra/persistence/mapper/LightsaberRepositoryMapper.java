package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import java.util.LinkedList;

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
	
	public Iterable<LightsaberEntity> mapToEntity(final Iterable<Lightsaber> lightsabers) {
		final var mapper = new ModelMapper();
		var lightsaberEntities = new LinkedList<LightsaberEntity>();
		lightsabers.forEach(l -> lightsaberEntities.add(mapper.map(l, LightsaberEntity.class)));
		return lightsaberEntities;
	}
	
	public Iterable<Lightsaber> mapToDomain(final Iterable<LightsaberEntity> lightsaberEntities) {
		final var mapper = new ModelMapper();
		var lightsabers = new LinkedList<Lightsaber>();
		lightsaberEntities.forEach(l -> lightsabers.add(mapper.map(l, Lightsaber.class)));
		return lightsabers;
	}

}
