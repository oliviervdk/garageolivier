package be.vdab.garageolivier.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Herstelling;

public interface HerstellingenRepository extends JpaRepository<Herstelling, Long> {

	List<Herstelling> findByAuto(Auto auto);
}
