package fr.nimroad.gestcopro.app.solr.repository;

import java.util.Collection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import fr.nimroad.gestcopro.app.solr.definition.SearchableCoproprietaireDefinition;
import fr.nimroad.gestcopro.app.solr.model.Coproprietaire;

@Repository
public interface CoproprietaireRepository extends SolrCrudRepository<Coproprietaire, Long> {

	/**
	 * @Query(fields = { SearchableCoproprietaireDefinition.ID_FIELD_NAME,
			SearchableCoproprietaireDefinition.FIRSTNAME_FIELD_NAME,
			SearchableCoproprietaireDefinition.FIXE_FIELD_NAME, SearchableCoproprietaireDefinition.LOCATION_FIELD_NAME,
			SearchableCoproprietaireDefinition.NAME_FIELD_NAME })
	 * @param names
	 * @param page
	 * @return
	 */
	@Highlight(postfix = "<b>", prefix = "</b>")
	HighlightPage<Coproprietaire> findByNameContainsOrPrenomContains(Collection<String> names, Collection<String> prenoms,Pageable page);
	
	@Facet(fields = { SearchableCoproprietaireDefinition.NAME_FIELD_NAME })
	FacetPage<Coproprietaire> findByNameStartsWith(Collection<String> nameFragments, Pageable pagebale);
	
}
