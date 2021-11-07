package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.LightsaberEntity;

public interface ILightsaberRepositoryMapper<S extends Lightsaber, T extends LightsaberEntity> {
	
    T mapToEntity(S lightsaber);
	
    S mapToDomain(T lightsaberEntity);
	

}
