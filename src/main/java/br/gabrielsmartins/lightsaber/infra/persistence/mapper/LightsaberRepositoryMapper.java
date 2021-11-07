package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.LightsaberEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LightsaberRepositoryMapper {

	private final LightsaberRepositoryMapperFactory factory;

	@SuppressWarnings("unchecked")
	public LightsaberEntity mapToEntity(Lightsaber lightsaber) {
		ILightsaberRepositoryMapper<Lightsaber, LightsaberEntity> mapper = (ILightsaberRepositoryMapper<Lightsaber, LightsaberEntity>) this.factory
				.createMapper(lightsaber);
		return mapper.mapToEntity(lightsaber);

	}

	@SuppressWarnings("unchecked")
	public Lightsaber mapToDomain(LightsaberEntity lightsaberEntity) {
		ILightsaberRepositoryMapper<Lightsaber, LightsaberEntity> mapper = (ILightsaberRepositoryMapper<Lightsaber, LightsaberEntity>) this.factory
				.createMapper(lightsaberEntity);
		return mapper.mapToDomain(lightsaberEntity);
	}

}
