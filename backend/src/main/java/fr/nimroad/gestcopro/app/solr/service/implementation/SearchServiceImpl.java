package fr.nimroad.gestcopro.app.solr.service.implementation;

import java.util.List;

import lombok.SneakyThrows;
import fr.nimroad.gestcopro.app.model.entite.definition.SearchableCoproprietaireDefinition;
import fr.nimroad.gestcopro.app.model.entite.definition.SearchableResidenceDefinition;
import fr.nimroad.gestcopro.app.solr.service.SearchSolrService;
import fr.nimroad.gestcopro.app.solr.util.QuerySolrHelper;
import fr.nimroad.gestcopro.app.solr.util.SolrHandler;
import fr.nimroad.gestcopro.utils.model.entite.Dto;

public enum SearchServiceImpl implements SearchSolrService {

	INSTANCE;
	
	@Override
	@SneakyThrows
	public List<Dto<?>> findByFull(String searchTerm) {
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		querySolrHelper.addOrFilterQuery(searchTerm,
			SearchableCoproprietaireDefinition.CONTENT, SearchableResidenceDefinition.CONTENT
		);

		querySolrHelper.addCore("COPROPRIETAIRE", "RESIDENCE");
		return SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build());
	}

}
