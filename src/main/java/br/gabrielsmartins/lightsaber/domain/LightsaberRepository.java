package br.gabrielsmartins.lightsaber.domain;

import java.util.Optional;
import java.util.UUID;

public interface LightsaberRepository {

	Lightsaber save(Lightsaber lightsaber);
	
	Iterable<Lightsaber> saveAll(Iterable<Lightsaber> lightsabers);
	
	Optional<Lightsaber> findById(UUID id);

}
