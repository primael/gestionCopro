package fr.nimroad.gestcopro.app.solr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import fr.nimroad.gestcopro.app.solr.definition.SearchableCoproprietaireDefinition;

@Getter
@Setter
@ToString
@SolrDocument(solrCoreName="coproprietaire")
public class Coproprietaire implements SearchableCoproprietaireDefinition {

	@Id
	@Indexed
	private Long id;
	
	@Indexed(NAME_FIELD_NAME)
	private String name;
	
	@Indexed(FIRSTNAME_FIELD_NAME)
	private String prenom;
	
	@Indexed(MOBILE_FIELD_NAME)
	private String mobile;
	
	@Indexed(MAIL_FIELD_NAME)
	private String email;
	
	@Indexed(FIXE_FIELD_NAME)
	private String fixe;
	
	//@Indexed(LOCATION_FIELD_NAME)
	//private String location;

}
