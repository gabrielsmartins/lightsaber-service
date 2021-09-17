package br.gabrielsmartins.lightsaber.infra.messaging.consumer.message;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@ToString
@Getter
@Setter
/*@JsonTypeInfo(
        use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.EXISTING_PROPERTY,
        property="type")*/
public class LightsaberConsumerMessage {

	@JsonProperty(value = "serial_number")
	private UUID serialNumber;
	
	@JsonProperty(value = "description")
	private String description;
	
	@JsonProperty(value = "type")
	private String type;
	
	
}
