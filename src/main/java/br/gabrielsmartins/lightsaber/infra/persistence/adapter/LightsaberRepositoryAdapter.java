package br.gabrielsmartins.lightsaber.infra.persistence.adapter;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.domain.LightsaberRepository;
import br.gabrielsmartins.lightsaber.infra.persistence.mapper.LightsaberRepositoryMapper;
import br.gabrielsmartins.lightsaber.infra.persistence.repository.LightsaberJpaRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LightsaberRepositoryAdapter implements LightsaberRepository {

	private final LightsaberJpaRepository repository;
	private final LightsaberRepositoryMapper mapper;
	
	@Override
	public Lightsaber save(Lightsaber lightsaber) {
		var lightsaberEntity = this.mapper.mapToEntity(lightsaber);
		var savedLightSaberEntity = this.repository.saveAndFlush(lightsaberEntity);
		lightsaber.setId(savedLightSaberEntity.getId());
		return this.mapper.mapToDomain(savedLightSaberEntity);
	}

	@Override
	public Iterable<Lightsaber> saveAll(Iterable<Lightsaber> lightsabers) {
		var lightsaberEntities = StreamSupport.stream(lightsabers.spliterator(), false)
								              .map(this.mapper::mapToEntity)
								              .collect(Collectors.toList());
		var savedLightsabers = this.repository.saveAll(lightsaberEntities);
		return savedLightsabers.stream()
				               .map(this.mapper::mapToDomain)
							   .collect(Collectors.toList());
	}

	@Override
	public Optional<Lightsaber> findById(UUID id) {
		return this.repository.findById(id)
							  .map(this.mapper::mapToDomain);
	}


}
