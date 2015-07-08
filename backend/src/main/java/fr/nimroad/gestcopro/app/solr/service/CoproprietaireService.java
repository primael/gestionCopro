package fr.nimroad.gestcopro.app.solr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;

import fr.nimroad.gestcopro.app.solr.model.Coproprietaire;

public interface CoproprietaireService {

	int DEFAULT_PAGE_SIZE = 3;
	
	Page<Coproprietaire> findByName(String searchTerm, Pageable pageable);
	
	Coproprietaire findById(Long id);
	
	FacetPage<Coproprietaire> autocompleteNameFragment(String fragment, Pageable pageable);
}
