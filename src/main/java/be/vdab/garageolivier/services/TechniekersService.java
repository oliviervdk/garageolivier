package be.vdab.garageolivier.services;

import java.util.List;

import be.vdab.garageolivier.entities.Technieker;

public interface TechniekersService {

	public List<Technieker> findAll();
	public void create(Technieker technieker);
}
