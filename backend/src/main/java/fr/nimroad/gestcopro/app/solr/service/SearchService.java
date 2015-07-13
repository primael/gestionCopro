package fr.nimroad.gestcopro.app.solr.service;

import java.util.List;

import fr.nimroad.gestcopro.app.model.entite.Dto;

public interface SearchService {

	static SearchService getInstance(){
		return SearchServiceImpl.INSTANCE;
	}

	List<Dto> findByFull(String searchTerm);
}
