package fr.nimroad.gestcopro.app.model.service;

import java.util.List;

import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.app.model.service.implementation.CoproprietaireServiceImplementation;

public interface CoproprietaireService {

	static CoproprietaireService getInstance(){
		return CoproprietaireServiceImplementation.INSTANCE;
	}
	
	List<Coproprietaire> getAll();
}
