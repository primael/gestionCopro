package fr.nimroad.gestcopro.app.model.service.implementation;

import java.util.List;

import fr.nimroad.gestcopro.app.model.dao.ResidenceDao;
import fr.nimroad.gestcopro.app.model.entite.Residence;
import fr.nimroad.gestcopro.app.model.service.AdresseService;
import fr.nimroad.gestcopro.app.model.service.ResidenceService;

public enum ResidenceServiceImplementation implements ResidenceService {

	INSTANCE;
	
	private final ResidenceDao residenceDao = ResidenceDao.getInstance();
	private final AdresseService adresseService = AdresseService.getInstance();

	@Override
	public List<Residence> getAll() {
		return this.residenceDao.getAll();
	}

	@Override
	public Residence sauvegarder(Residence residence) {
		residence.setAdresse(adresseService.sauvegarder(residence.getAdresse()));
		return residenceDao.save(residence);
	}
	
}
