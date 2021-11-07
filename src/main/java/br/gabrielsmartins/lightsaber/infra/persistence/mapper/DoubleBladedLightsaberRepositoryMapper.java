package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.DoubleBladedLightsaber;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.DoubleBladedLightsaberEntity;

@Component
public class DoubleBladedLightsaberRepositoryMapper implements ILightsaberRepositoryMapper<DoubleBladedLightsaber, DoubleBladedLightsaberEntity> {

	@Override
	public DoubleBladedLightsaberEntity mapToEntity(DoubleBladedLightsaber lightsaber) {
		var mapper = new ModelMapper();
		return mapper.map(lightsaber, DoubleBladedLightsaberEntity.class);
	}

	@Override
	public DoubleBladedLightsaber mapToDomain(DoubleBladedLightsaberEntity lightsaberEntity) {
		var mapper = new ModelMapper();
		return mapper.map(lightsaberEntity, DoubleBladedLightsaber.class);
	}

}
