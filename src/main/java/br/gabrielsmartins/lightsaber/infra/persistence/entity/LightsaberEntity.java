package br.gabrielsmartins.lightsaber.infra.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberStatusData;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.LightsaberTypeData;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.converter.LightsaberStatusDataConverter;
import br.gabrielsmartins.lightsaber.infra.persistence.entity.enums.converter.LightsaberTypeDataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "tbl_ligthsaber")
@Entity
public class LightsaberEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "bigint", nullable = false)
	private Long id;
	
	@Column(name = "serial_number", columnDefinition = "char(36)", nullable = false)
	private UUID serialNumber;
	
	@Column(name = "description", columnDefinition = "varchar(256)", nullable = false)
	private String description;
	
	@Column(name = "type", columnDefinition = "char(1)", nullable = false)
	@Convert(converter = LightsaberTypeDataConverter.class)
	private LightsaberTypeData type;
	
	@Column(name = "created_at", columnDefinition = "timestamp", nullable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "status", columnDefinition = "char(1)", nullable = false)
	@Convert(converter = LightsaberStatusDataConverter.class)
	private LightsaberStatusData status;

}
