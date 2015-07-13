package fr.nimroad.gestcopro.app.solr.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import lombok.SneakyThrows;

import org.apache.commons.lang3.StringUtils;

import fr.nimroad.gestcopro.app.solr.definition.SearchableCoproprietaireDefinition;
import fr.nimroad.gestcopro.app.solr.mapper.CoproprietaireMapper;
import fr.nimroad.gestcopro.app.solr.model.Coproprietaire;
import fr.nimroad.gestcopro.app.solr.util.QuerySolrHelper;
import fr.nimroad.gestcopro.app.solr.util.SolrHandler;

public enum CoproprietaireServiceImpl implements CoproprietaireService {

	INSTANCE;
	
	private static final Pattern IGNORED_CHARS_PATTERN = Pattern
			.compile("\\p{Punct}");

	@Override
	public Coproprietaire findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	Collection<String> splitSearchTermAndRemoveIgnoredCharacters(String searchTerm) {
		String[] searchTerms = StringUtils.split(searchTerm, " ");
		List<String> result = new ArrayList<String>(searchTerms.length);
		for (String term : searchTerms) {
			if (StringUtils.isNotEmpty(term)) {
				result.add(IGNORED_CHARS_PATTERN.matcher(term).replaceAll(" "));
			}
		}
		System.out.println("result :" + result);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	@SneakyThrows
	public List<Coproprietaire> findByNom(String searchTerm) {
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		querySolrHelper.addFilterQuery(searchTerm,
				SearchableCoproprietaireDefinition.NAME_TRI_FIELD);

		return (List<Coproprietaire>) SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build(), new CoproprietaireMapper());
	}

	@Override
	@SneakyThrows
	@SuppressWarnings("unchecked")
	public List<Coproprietaire> findByNomOrPrenom(String searchTerm) {
		//Collection<String> terms = splitSearchTermAndRemoveIgnoredCharacters(searchTerm);
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		//for(String term : terms){
			querySolrHelper.addOrFilterQuery(searchTerm,
					SearchableCoproprietaireDefinition.NAME_TRI_FIELD, SearchableCoproprietaireDefinition.FIRSTNAME_TRI_FIELD);
		//}
		return (List<Coproprietaire>) SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build(), new CoproprietaireMapper());
	}

	@Override
	@SneakyThrows
	@SuppressWarnings("unchecked")
	public List<Coproprietaire> findByFull(String searchTerm) {
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		querySolrHelper.addOrFilterQuery(searchTerm,
				SearchableCoproprietaireDefinition.NAME_TRI_FIELD, SearchableCoproprietaireDefinition.FIRSTNAME_TRI_FIELD,
				SearchableCoproprietaireDefinition.ADRESSE_TRI_FIELD, SearchableCoproprietaireDefinition.FIXE_TRI_FIELD,
				SearchableCoproprietaireDefinition.MOBILE_FIELD_NAME, SearchableCoproprietaireDefinition.MAIL_TRI_FIELD);

		return (List<Coproprietaire>) SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build(), new CoproprietaireMapper());
	}
	
	

}
