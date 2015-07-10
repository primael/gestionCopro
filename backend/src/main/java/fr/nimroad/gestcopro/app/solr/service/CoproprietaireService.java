package fr.nimroad.gestcopro.app.solr.service;

import java.util.List;

import fr.nimroad.gestcopro.app.solr.model.Coproprietaire;

public interface CoproprietaireService {


	Coproprietaire findById(Long id);
	
	List<Coproprietaire> findByNom(String searchTerm);
	
	List<Coproprietaire> findByNomOrPrenom(String searchTerm);
	
	List<Coproprietaire> findByFull(String searchTerm);
}
