package br.gabrielsmartins.lightsaber.infra.persistence.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder(setterPrefix = "with")
@Table(name = "tbl_crossguard_ligthsaber")
@Entity
public class CrossguardLightsaberEntity extends LightsaberEntity  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "model", columnDefinition = "varchar(256)", nullable = false)
	private String model;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "id.lightsaber")
	@Getter(value = AccessLevel.NONE)
	private final List<CrossguardLightsaberSpecificationEntity> specifications = new LinkedList<>();
	
	public List<CrossguardLightsaberSpecificationEntity> getSpecifications() {
		return Collections.unmodifiableList(specifications);
	}
	
	public Integer addSpecification(CrossguardLightsaberSpecificationEntity specification) {
		specification.getId().setLightsaber(this);
		this.specifications.add(specification);
		return this.specifications.size();
	}
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	@Builder(setterPrefix = "with")
	@EqualsAndHashCode(of = "id")
	@Table(name = "tbl_lightsaber_crossguard_specification")
	@Entity
	public static class CrossguardLightsaberSpecificationEntity implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@EmbeddedId
		private CrossguardLightsaberSpecificationEntityId id;
		
		@Column(name = "description", columnDefinition = "varchar(256)", nullable = false)
		private String description;
		
		@Column(name = "priority", columnDefinition = "int", nullable = false)
		private Integer priority;
		
		
		@NoArgsConstructor
		@AllArgsConstructor
		@Getter
		@Setter
		@ToString(exclude = "lightsaber")
		@Builder(setterPrefix = "with")
		@Embeddable
		public static class CrossguardLightsaberSpecificationEntityId implements Serializable{
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "id", referencedColumnName = "id", columnDefinition = "bigint", nullable = false)
			private CrossguardLightsaberEntity lightsaber;
			
			@Column(name = "code", columnDefinition = "varchar(50)", nullable = false)
			private String code;
		}
		
	}

}
