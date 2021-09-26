package br.gabrielsmartins.lightsaber.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder(setterPrefix = "with")
public class CrossguardLightsaber extends Lightsaber {

	private String model;
	@Getter(value = AccessLevel.NONE)
	private final List<CrossguardLightsaberSpecification> specifications = new LinkedList<>();
	
	public List<CrossguardLightsaberSpecification> getSpecifications() {
		return Collections.unmodifiableList(specifications);
	}
	
	public Integer addSpecification(CrossguardLightsaberSpecification specification) {
		specification.setLightsaber(this);
		this.specifications.add(specification);
		return this.specifications.size();
	}
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	@Builder(setterPrefix = "with")
	public static class CrossguardLightsaberSpecification {
		
		private CrossguardLightsaber lightsaber;
		private String code;
		private String description;
		private Integer priority;

	}

	
}
