package br.gabrielsmartins.lightsaber.infra.persistence.adapter;

import static br.gabrielsmartins.lightsaber.domain.support.SingleBladedLightsaberSupport.defaultSingleBladedLightsaber;
import static br.gabrielsmartins.lightsaber.infra.persistence.entity.support.SingleBladedLightsaberSupport.defaultSingleBladedLightsaberEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.LightsaberEntity;
import br.gabrielsmartins.lightsaber.infra.persistence.mapper.LightsaberRepositoryMapper;
import br.gabrielsmartins.lightsaber.infra.persistence.repository.LightsaberJpaRepository;
import lombok.RequiredArgsConstructor;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LightsaberRepositoryAdapterTest {

	private LightsaberRepositoryAdapter adapter;
	private final LightsaberRepositoryMapper mapper;
	private LightsaberJpaRepository repository;

	@BeforeEach
	public void setup() {
		this.repository = mock(LightsaberJpaRepository.class);
		this.adapter = new LightsaberRepositoryAdapter(repository, this.mapper);
	}
	
	@Test
	@DisplayName("Given Lightsaber When Save Then Return Saved Lightsaber")
	public void givenLightsaberWhenSaveThenReturnSavedLightsaber() {
		
		var lightsaber = defaultSingleBladedLightsaber().build();
		
		when(this.repository.saveAndFlush(any(LightsaberEntity.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
	
		var savedLightsaber = this.adapter.save(lightsaber);
		
		assertThat(savedLightsaber).isNotNull();
	}

	
	@Test
	@DisplayName("Given Lightsabers When Save Then Return Saved Lightsabers")
	public void givenLightsabersWhenSaveThenReturnSavedLightsabers() {
		
		var lightsaber = defaultSingleBladedLightsaber().build();
		
		when(this.repository.saveAll(any())).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
	
		var savedLightsabers = this.adapter.saveAll(List.of(lightsaber));
		
		assertThat(savedLightsabers).isNotEmpty();
	}
	
	@Test
	@DisplayName("Given Id When Exists Then Return Lightsaber")
	public void givenIdWhenExistsThenReturnLightsaber() {
		
		var lightsaberEntity = defaultSingleBladedLightsaberEntity().build();
		
		when(this.repository.findById(any(UUID.class))).thenReturn(Optional.of(lightsaberEntity));
	
	    var optionalLightsaber = this.adapter.findById(UUID.randomUUID());
		
		assertThat(optionalLightsaber).isPresent();
	}
}
