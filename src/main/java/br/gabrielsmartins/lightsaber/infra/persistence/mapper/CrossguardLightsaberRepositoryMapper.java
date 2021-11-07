package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.CrossguardLightsaber;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.CrossguardLightsaberEntity;

@Component
public class CrossguardLightsaberRepositoryMapper implements ILightsaberRepositoryMapper<CrossguardLightsaber, CrossguardLightsaberEntity> {

	@Override
	public CrossguardLightsaberEntity mapToEntity(CrossguardLightsaber lightsaber) {
		var mapper = new ModelMapper();
		return mapper.map(lightsaber, CrossguardLightsaberEntity.class);
	}

	@Override
	public CrossguardLightsaber mapToDomain(CrossguardLightsaberEntity lightsaberEntity) {
		var mapper = new ModelMapper();
		return mapper.map(lightsaberEntity, CrossguardLightsaber.class);
	}

}
