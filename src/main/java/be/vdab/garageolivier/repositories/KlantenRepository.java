package be.vdab.garageolivier.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import be.vdab.garageolivier.entities.Klant;

public interface KlantenRepository extends JpaRepository<Klant, Long>{
	
	Page<Klant>findByNaamContaining(@Param("naam")String naam, Pageable pageable);
}
