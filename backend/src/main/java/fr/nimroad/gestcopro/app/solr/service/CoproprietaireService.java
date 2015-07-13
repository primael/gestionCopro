package fr.nimroad.gestcopro.app.solr.service;

import java.util.List;

import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;

public interface CoproprietaireService {

	static CoproprietaireService getInstance(){
		return CoproprietaireServiceImpl.INSTANCE;
	}

	Coproprietaire findById(Long id);
	
	List<Coproprietaire> findByNom(String searchTerm);
	
	List<Coproprietaire> findByNomOrPrenom(String searchTerm);
	
	List<Coproprietaire> findByFull(String searchTerm);
}
