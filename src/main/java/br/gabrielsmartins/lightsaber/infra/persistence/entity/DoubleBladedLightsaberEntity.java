package br.gabrielsmartins.lightsaber.infra.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
@Table(name = "tbl_double_bladed_ligthsaber")
@Entity
public class DoubleBladedLightsaberEntity extends LightsaberEntity {

	@Column(name = "min_energy_level", columnDefinition = "decimal(17,2)", nullable = false)
	private Double minEnergyLevel;
	
	@Column(name = "max_energy_level", columnDefinition = "decimal(17,2)", nullable = false)
	private Double maxEnergyLevel;
}
