package br.gabrielsmartins.lightsaber.infra.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gabrielsmartins.lightsaber.infra.persistence.entity.LightsaberEntity;

@Repository
public interface LightsaberJpaRepository extends JpaRepository<LightsaberEntity, UUID> {

}
