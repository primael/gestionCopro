package fr.nimroad.gestcopro.app.solr.service;

import java.util.List;

import fr.nimroad.gestcopro.app.solr.model.DTSearch;

public interface SearchService {

	static SearchService getInstance(){
		return SearchServiceImpl.INSTANCE;
	}

	List<DTSearch> findByFull(String searchTerm);
}
