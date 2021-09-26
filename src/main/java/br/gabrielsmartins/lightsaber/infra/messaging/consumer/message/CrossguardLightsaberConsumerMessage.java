package br.gabrielsmartins.lightsaber.infra.messaging.consumer.message;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class CrossguardLightsaberConsumerMessage extends LightsaberConsumerMessage {
	
	@JsonProperty("model")
	private String model;
	
	@JsonProperty("specifications")
	private final List<CrossguardLightsaberSpecificationConsumerMessage> specifications = new LinkedList<>();
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	@Builder(setterPrefix = "with")
	public static class CrossguardLightsaberSpecificationConsumerMessage {
		
		@JsonProperty("code")
		private String code;
		
		@JsonProperty("description")
		private String description;
		
		@JsonProperty("priority")
		private Integer priority;
		
	}
	

}
