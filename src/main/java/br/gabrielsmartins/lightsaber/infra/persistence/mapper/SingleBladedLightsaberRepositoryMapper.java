package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.SingleBladedLightsaber;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.SingleBladedLightsaberEntity;

@Component
public class SingleBladedLightsaberRepositoryMapper implements ILightsaberRepositoryMapper<SingleBladedLightsaber, SingleBladedLightsaberEntity> {

	@Override
	public SingleBladedLightsaberEntity mapToEntity(SingleBladedLightsaber lightsaber) {
		var mapper = new ModelMapper();
		return mapper.map(lightsaber, SingleBladedLightsaberEntity.class);
	}

	@Override
	public SingleBladedLightsaber mapToDomain(SingleBladedLightsaberEntity lightsaberEntity) {
		var mapper = new ModelMapper();
		return mapper.map(lightsaberEntity, SingleBladedLightsaber.class);
	}

}
