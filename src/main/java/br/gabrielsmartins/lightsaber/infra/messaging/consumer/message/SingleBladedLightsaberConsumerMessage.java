package br.gabrielsmartins.lightsaber.infra.messaging.consumer.message;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(setterPrefix = "with")
@ToString
@Getter
@Setter
public class SingleBladedLightsaberConsumerMessage extends LightsaberConsumerMessage {

	@JsonProperty("due_data")
	private LocalDate dueDate;
	
	@JsonProperty("manufacturer_id")
	private UUID manufacturerId;
}
