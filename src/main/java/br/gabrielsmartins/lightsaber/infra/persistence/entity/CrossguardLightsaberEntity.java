package br.gabrielsmartins.lightsaber.infra.persistence.entity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@ToString
@Getter
@Setter
@SuperBuilder(setterPrefix = "with")
@Table(name = "tbl_crossguard_ligthsaber")
@Entity
public class CrossguardLightsaberEntity extends LightsaberEntity  {
	
	private String model;
	@Getter(value = AccessLevel.NONE)
	private final List<CrossguardLightsaberSpecificationEntity> specifications = new LinkedList<>();
	
	public List<CrossguardLightsaberSpecificationEntity> getSpecifications() {
		return Collections.unmodifiableList(specifications);
	}
	
	public Integer addSpecification(CrossguardLightsaberSpecificationEntity specification) {
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
	public static class CrossguardLightsaberSpecificationEntity {
		
		private CrossguardLightsaberEntity lightsaber;
		private String code;
		private String description;
		private Integer priority;

	}

}
