package be.vdab.garageolivier.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Herstelling;

public interface HerstellingenService {
	public Page<Herstelling> findByAuto(Auto auto, Pageable pageable);
	public void create(Herstelling herstelling);
	public Page<Herstelling> findAll(Pageable pageable);
}
