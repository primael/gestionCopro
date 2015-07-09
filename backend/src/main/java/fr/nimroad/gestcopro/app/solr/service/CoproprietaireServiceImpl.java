package fr.nimroad.gestcopro.app.solr.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.stereotype.Service;

import fr.nimroad.gestcopro.app.solr.model.Coproprietaire;
import fr.nimroad.gestcopro.app.solr.repository.CoproprietaireRepository;

@Service
public class CoproprietaireServiceImpl implements CoproprietaireService {

	private static final Pattern IGNORED_CHARS_PATTERN = Pattern.compile("\\p{Punct}");
	
	private CoproprietaireRepository coproprietaireRepository;
	
	@Override
	public Page<Coproprietaire> findByName(String searchTerm, Pageable pageable) {
		System.out.println("pageable: " + pageable);
		System.out.println("searchTerm: " + searchTerm);
		if(StringUtils.isBlank(searchTerm)) {
			return coproprietaireRepository.findAll(pageable);
		}
		return coproprietaireRepository.findByNameContainsOrPrenomContains(splitSearchTermAndRemoveIgnoredCharacters(searchTerm), splitSearchTermAndRemoveIgnoredCharacters(searchTerm),pageable);
	}

	@Override
	public Coproprietaire findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacetPage<Coproprietaire> autocompleteNameFragment(String fragment, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Collection<String> splitSearchTermAndRemoveIgnoredCharacters(String searchTerm) {
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

	@Autowired
	public void setRepository(CoproprietaireRepository coproprietaireRepository) {
		this.coproprietaireRepository = coproprietaireRepository;
	}

	@Override
	public List<Coproprietaire> findByNom(String searchTerm) {
		SolrQuery query = new SolrQuery();
		query.addFilterQuery("NOM_TRI:*"+searchTerm.toUpperCase()+"*");
		return null;
	}

	
}
