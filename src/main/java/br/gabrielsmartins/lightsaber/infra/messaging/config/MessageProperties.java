package br.gabrielsmartins.lightsaber.infra.messaging.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties(prefix = "app.messaging")
@Getter
@Setter
@ToString
public class MessageProperties {
	
	private String input;
	private String output;
	

	
}
