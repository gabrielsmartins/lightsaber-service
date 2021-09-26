package br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberTypeData;

@Converter(autoApply = true)
public class LightsaberTypeDataConverter implements AttributeConverter<LightsaberTypeData, String> {

	@Override
	public String convertToDatabaseColumn(LightsaberTypeData type) {
		if (type == null)
			return null;
		return type.getCode();
	}

	@Override
	public LightsaberTypeData convertToEntityAttribute(String code) {
		return LightsaberTypeData.fromValue(code);
	}

}
