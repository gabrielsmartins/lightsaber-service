package br.gabrielsmartins.lightsaber.application;

import static br.gabrielsmartins.lightsaber.domain.support.SingleBladedLightsaberSupport.defaultSingleBladedLightsaber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.domain.LightsaberPublisher;
import br.gabrielsmartins.lightsaber.domain.LightsaberRepository;

public class DefaultProcessLightsaberServiceTest {
	
	private DefaultProcessLightsaberService service;
	private LightsaberRepository repository;
	private LightsaberPublisher publisher;
	
	@BeforeEach
	public void setup() {
		this.repository = mock(LightsaberRepository.class);
		this.publisher = mock(LightsaberPublisher.class);
		this.service = new DefaultProcessLightsaberService(repository, publisher);
	}
	
	@Test
	@DisplayName("Given Light saber When Process Then Save And Send Notification")
	public void givenLightsaberWhenProcessThenSaveAndSendNotification() {
		var lightsaber = defaultSingleBladedLightsaber().build();
		
		when(this.repository.save(any(Lightsaber.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
		
		var processedLightsaber = this.service.process(lightsaber);
		
		verify(publisher, times(1)).publish(any(Lightsaber.class));
		assertThat(processedLightsaber).isNotNull();
	}

}
