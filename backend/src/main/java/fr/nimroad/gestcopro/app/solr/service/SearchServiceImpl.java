package fr.nimroad.gestcopro.app.solr.service;

import java.util.List;

import lombok.SneakyThrows;
import fr.nimroad.gestcopro.app.solr.definition.SearchableCoproprietaireDefinition;
import fr.nimroad.gestcopro.app.solr.definition.SearchableResidenceDefinition;
import fr.nimroad.gestcopro.app.solr.model.DTSearch;
import fr.nimroad.gestcopro.app.solr.util.QuerySolrHelper;
import fr.nimroad.gestcopro.app.solr.util.SolrHandler;

public enum SearchServiceImpl implements SearchService {

	INSTANCE;
	
	@Override
	@SneakyThrows
	public List<DTSearch> findByFull(String searchTerm) {
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		querySolrHelper.addOrFilterQuery(searchTerm,
				SearchableCoproprietaireDefinition.NAME_TRI_FIELD, SearchableCoproprietaireDefinition.ADRESSE_TRI_FIELD,				
				SearchableResidenceDefinition.ADRESSE_TRI_FIELD, SearchableResidenceDefinition.NAME_TRI_FIELD
				);

		querySolrHelper.addCore("COPROPRIETAIRE", "RESIDENCE");
		return SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build());
	}

}
