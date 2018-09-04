package be.vdab.garageolivier.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Herstelling;

public interface HerstellingenRepository extends JpaRepository<Herstelling, Long> {

	@Override
	@EntityGraph("Herstelling.metTechnieker")
	Page<Herstelling> findAll (Pageable pageable);
	
	@EntityGraph("Herstelling.metTechnieker")
	Page<Herstelling> findByAuto(Auto auto, Pageable pageable);
}
