package be.vdab.garageolivier.services;

import java.util.List;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Herstelling;

public interface HerstellingenService {
	List<Herstelling> findByAuto(Auto auto);
	public void create(Herstelling herstelling);
	public List<Herstelling> findAll();
}
