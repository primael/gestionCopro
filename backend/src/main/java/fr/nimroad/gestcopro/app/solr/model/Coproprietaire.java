package fr.nimroad.gestcopro.app.solr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import fr.nimroad.gestcopro.app.solr.definition.SearchableCoproprietaireDefinition;

@Getter
@Setter
@ToString
public class Coproprietaire extends DTSearch implements SearchableCoproprietaireDefinition {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String prenom;

	private String mobile;
	
	private String email;
	
	private String fixe;

}
