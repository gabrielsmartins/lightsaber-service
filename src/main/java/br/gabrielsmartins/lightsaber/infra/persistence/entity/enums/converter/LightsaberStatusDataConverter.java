package br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberStatusData;

@Converter(autoApply = true)
public class LightsaberStatusDataConverter implements AttributeConverter<LightsaberStatusData, Character> {

	@Override
	public Character convertToDatabaseColumn(LightsaberStatusData status) {
		if (status == null)
			return null;
		return status.getCode();
	}

	@Override
	public LightsaberStatusData convertToEntityAttribute(Character code) {
	    return LightsaberStatusData.fromValue(code);
	}

}
