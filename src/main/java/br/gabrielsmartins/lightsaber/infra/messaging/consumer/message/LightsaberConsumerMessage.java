package br.gabrielsmartins.lightsaber.infra.messaging.consumer.message;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
@JsonSubTypes({
	@Type(value = SingleBladedLightsaberConsumerMessage.class), 
})
@JsonTypeInfo(
        use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.EXISTING_PROPERTY,
        property="type")
public class LightsaberConsumerMessage {

	@JsonProperty(value = "serial_number")
	protected UUID serialNumber;
	
	@JsonProperty(value = "description")
	protected String description;
	
	@JsonProperty(value = "type")
	protected String type;
	
	
}
