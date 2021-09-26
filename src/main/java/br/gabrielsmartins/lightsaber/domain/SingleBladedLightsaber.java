package br.gabrielsmartins.lightsaber.domain;

import java.time.LocalDate;
import java.util.UUID;

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
public class SingleBladedLightsaber extends Lightsaber {
	
	private LocalDate dueDate;
	private UUID manufacturerId;
	

}
