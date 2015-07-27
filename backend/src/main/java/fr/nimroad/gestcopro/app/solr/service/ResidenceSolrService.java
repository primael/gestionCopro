package fr.nimroad.gestcopro.app.solr.service;

import fr.nimroad.gestcopro.app.model.entite.Residence;
import fr.nimroad.gestcopro.app.solr.service.implementation.ResidenceSolrServiceImpl;

public interface ResidenceSolrService {

	static ResidenceSolrService getInstance(){
		return ResidenceSolrServiceImpl.INSTANCE;
	}
	
	void fullReindexation();
	
	void indexer(Residence residence);
}
