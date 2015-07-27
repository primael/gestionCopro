package fr.nimroad.gestcopro.app.model.service.implementation;

import fr.nimroad.gestcopro.app.model.dao.CommuneDao;
import fr.nimroad.gestcopro.app.model.entite.Commune;
import fr.nimroad.gestcopro.app.model.service.CommuneService;

public enum CommuneServiceImplementation implements CommuneService {

	INSTANCE;

	private CommuneDao communeDao = CommuneDao.getInstance();
	
	@Override
	public Commune getCommune(Commune commune) {		
		return communeDao.findByCodePostalEtCodeInsee(commune.getCodePostal(), commune.getCodeInsee());
	}
	
}
