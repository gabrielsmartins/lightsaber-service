package br.gabrielsmartins.lightsaber.infra.persistence.mapper;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import br.gabrielsmartins.lightsaber.domain.Lightsaber;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.LightsaberEntity;

@Component
public class LightsaberRepositoryMapperFactory {

	private final Map<Class<?>[], ILightsaberRepositoryMapper<?,?>> mappersMap;
	
	public LightsaberRepositoryMapperFactory(List<ILightsaberRepositoryMapper<?,?>> mappers) {
		this.mappersMap = build(mappers);
	}
	
	public ILightsaberRepositoryMapper<?, ?> createMapper(Lightsaber lightsaber){
		 return this.mappersMap.entrySet()
		                .stream()
		                .filter(it -> Stream.of(it.getKey())
		                		             .anyMatch(c -> c.isAssignableFrom(lightsaber.getClass())))
		                .findAny()
		                .map(Map.Entry::getValue)
		                .orElseThrow(() -> new IllegalArgumentException("Was not possible to determine a mapper for " + lightsaber.getClass()));
	}

	public ILightsaberRepositoryMapper<?, ?> createMapper(LightsaberEntity lightsaberEntity){
		return this.mappersMap.entrySet()
                .stream()
                .filter(it -> Stream.of(it.getKey())
                		             .anyMatch(c -> c.isAssignableFrom(lightsaberEntity.getClass())))
                .findAny()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new IllegalArgumentException("Was not possible to determine a mapper for " + lightsaberEntity.getClass()));
	}
	
	private Map<Class<?>[], ILightsaberRepositoryMapper<?, ?>> build(List<ILightsaberRepositoryMapper<?, ?>> mappers) {
		 return mappers.stream()
		       .collect(Collectors.toMap(this::getKey, Function.identity()));
	}
	
	public Class<?>[] getKey(ILightsaberRepositoryMapper<?, ?> mapper){
		var clazz = mapper.getClass();
		ParameterizedType type = (ParameterizedType) clazz.getGenericInterfaces()[0];
		return Stream.of(type.getActualTypeArguments())
								      .map(it -> (Class<?>) it)
								      .collect(Collectors.toList())
								      .toArray(new Class[0]);
	}
	
	
}
