package be.vdab.garageolivier.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.garageolivier.entities.Technieker;

public interface TechniekersService {

	public List<Technieker> findAll();
	public void create(Technieker technieker);
	public Page<Technieker> findAll(Pageable pageable);
}
