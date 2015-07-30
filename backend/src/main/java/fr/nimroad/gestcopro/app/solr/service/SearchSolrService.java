package fr.nimroad.gestcopro.app.solr.service;

import java.util.List;

import fr.nimroad.gestcopro.app.solr.service.implementation.SearchServiceImpl;
import fr.nimroad.gestcopro.utils.model.entite.Dto;

public interface SearchSolrService {

	static SearchSolrService getInstance(){
		return SearchServiceImpl.INSTANCE;
	}

	List<Dto<?>> findByFull(String searchTerm);
}
