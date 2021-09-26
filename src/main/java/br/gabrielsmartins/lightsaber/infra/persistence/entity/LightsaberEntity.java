package br.gabrielsmartins.lightsaber.infra.persistence.entity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberStatusData;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberTypeData;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.converter.LightsaberStatusDataConverter;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.converter.LightsaberTypeDataConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Setter
@SuperBuilder(setterPrefix = "with")
@Table(name = "tbl_ligthsaber")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class LightsaberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint", nullable = false)
	protected Long id;

	@Column(name = "serial_number", columnDefinition = "char(36)", nullable = false)
	protected UUID serialNumber;

	@Column(name = "description", columnDefinition = "varchar(256)", nullable = false)
	protected String description;

	@Column(name = "type", columnDefinition = "char(1)", nullable = false)
	@Convert(converter = LightsaberTypeDataConverter.class)
	protected LightsaberTypeData type;

	@Column(name = "created_at", columnDefinition = "timestamp", nullable = false)
	protected LocalDateTime createdAt;

	@Column(name = "status", columnDefinition = "char(1)", nullable = false)
	@Convert(converter = LightsaberStatusDataConverter.class)
	protected LightsaberStatusData status;

	@Getter(value = AccessLevel.NONE)
	@Builder.Default
	protected final Map<LocalDateTime, LightsaberStatusData> history = new LinkedHashMap<>();

	public Map<LocalDateTime, LightsaberStatusData> getHistory() {
		return Collections.unmodifiableMap(this.history);
	}

}
