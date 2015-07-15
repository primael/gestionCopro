package fr.nimroad.gestcopro.app.model.service.implementation;

import java.util.List;

import fr.nimroad.gestcopro.app.model.dao.CoproprietaireDao;
import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.app.model.service.CoproprietaireService;

public enum CoproprietaireServiceImplementation implements CoproprietaireService {

	INSTANCE;
	
	private final CoproprietaireDao coproprietaireDao = CoproprietaireDao.getInstance();

	@Override
	public List<Coproprietaire> getAll() {
		return coproprietaireDao.getAll();
	}
	
}
