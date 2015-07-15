package fr.nimroad.gestcopro.app.solr.service;

import java.util.List;

import fr.nimroad.gestcopro.app.model.entite.Dto;
import fr.nimroad.gestcopro.app.solr.service.implementation.SearchServiceImpl;

public interface SearchSolrService {

	static SearchSolrService getInstance(){
		return SearchServiceImpl.INSTANCE;
	}

	List<Dto> findByFull(String searchTerm);
}
