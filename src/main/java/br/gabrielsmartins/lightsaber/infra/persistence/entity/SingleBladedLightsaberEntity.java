package br.gabrielsmartins.lightsaber.infra.persistence.entity;

import java.time.LocalDate;
import java.util.UUID;

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
@Table(name = "tbl_single_bladed_ligthsaber")
@Entity
public class SingleBladedLightsaberEntity extends LightsaberEntity{

	@Column(name = "due_date", columnDefinition = "date", nullable = false)
	private LocalDate dueDate;
	
	@Column(name = "manufacturer_id", columnDefinition = "char(36)", nullable = false)
	private UUID manufacturerId;
}
