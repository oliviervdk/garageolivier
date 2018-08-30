package be.vdab.garageolivier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.garageolivier.entities.Technieker;

public interface TechniekersRepository extends JpaRepository<Technieker, Long> {
}
