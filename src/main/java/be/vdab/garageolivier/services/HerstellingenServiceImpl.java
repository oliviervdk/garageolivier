package be.vdab.garageolivier.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.garageolivier.entities.Auto;
import be.vdab.garageolivier.entities.Herstelling;
import be.vdab.garageolivier.repositories.HerstellingenRepository;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
class HerstellingenServiceImpl implements HerstellingenService {
	
	private final HerstellingenRepository herstellingenrepository;
	public HerstellingenServiceImpl(HerstellingenRepository herstellingenrepository) {
		this.herstellingenrepository = herstellingenrepository;
	}

	@Override
	public List<Herstelling> findByAuto(Auto auto) {
		return herstellingenrepository.findByAuto(auto);
	}

	@Override
	public void create(Herstelling herstelling) {
		herstellingenrepository.save(herstelling);
	}

	@Override
	public List<Herstelling> findAll() {
		return herstellingenrepository.findAll();
	}

}
