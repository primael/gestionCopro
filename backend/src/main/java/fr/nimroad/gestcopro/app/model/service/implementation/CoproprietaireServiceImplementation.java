package fr.nimroad.gestcopro.app.model.service.implementation;

import java.util.List;

import fr.nimroad.gestcopro.app.model.dao.CoproprietaireDao;
import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.app.model.service.AdresseService;
import fr.nimroad.gestcopro.app.model.service.CoproprietaireService;

public enum CoproprietaireServiceImplementation implements CoproprietaireService {

	INSTANCE;

	private final CoproprietaireDao coproprietaireDao = CoproprietaireDao.getInstance();
	private final AdresseService adresseService = AdresseService.getInstance();

	@Override
	public List<Coproprietaire> getAll() {
		return coproprietaireDao.getAll();
	}

	@Override
	public Coproprietaire sauvegarder(Coproprietaire coproprietaire) {
		// Faire les contrôles minimales de vérification?
		
		//On doit d'abord sauver les objets sous-jacents
		coproprietaire.setAdresse(adresseService.sauvegarder(coproprietaire.getAdresse()));

		//Sauver le coproprietaire
		return coproprietaireDao.save(coproprietaire);
	}

}
