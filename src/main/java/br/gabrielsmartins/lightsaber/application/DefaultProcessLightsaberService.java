package br.gabrielsmartins.lightsaber.application;

import org.springframework.stereotype.Service;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.domain.LightsaberPublisher;
import br.gabrielsmartins.lightsaber.domain.LightsaberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultProcessLightsaberService implements ProcessLightsaberService {
	
	private final LightsaberRepository repository;
	private final LightsaberPublisher publisher;

	@Override
	public Lightsaber process(Lightsaber lightsaber) {
		final var savedLightsaber = this.repository.save(lightsaber);
		this.publisher.publish(savedLightsaber);
		return savedLightsaber;
	}

	

	
}
