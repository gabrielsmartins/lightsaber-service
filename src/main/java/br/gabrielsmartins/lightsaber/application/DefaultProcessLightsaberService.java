package br.gabrielsmartins.lightsaber.application;


import org.springframework.stereotype.Service;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.domain.LightsaberPublisher;
import br.gabrielsmartins.lightsaber.domain.LightsaberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultProcessLightsaberService implements ProcessLightsaberService {
	
	private final LightsaberRepository repository;
	private final LightsaberPublisher publisher;

	@Override
	public Lightsaber process(Lightsaber lightsaber) {
		log.info("Saving lightsaber: {}", lightsaber);
		final var savedLightsaber = this.repository.save(lightsaber);
		log.info("Lightsaber was saved sucessfully: {}", savedLightsaber);
		
		log.info("Publishing lightsaber confirmation ...");
		this.publisher.publish(savedLightsaber);
		log.info("Lightsaber confirmation published sucessfully");
		return savedLightsaber;
	}

	

	
}
