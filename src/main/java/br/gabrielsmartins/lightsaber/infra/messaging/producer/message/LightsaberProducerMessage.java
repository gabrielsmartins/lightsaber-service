package br.gabrielsmartins.lightsaber.infra.messaging.producer.message;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Getter
@Setter
@ToString
public class LightsaberProducerMessage {
	
	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "serial_number")
	private UUID serialNumber;
	
	@JsonProperty(value = "description")
	private String description;
	
	@JsonProperty(value = "type")
	private String type;
	
	@JsonProperty(value = "created_at")
	private LocalDateTime createdAt;
	
	@JsonProperty(value = "status")
	private String status;

}
