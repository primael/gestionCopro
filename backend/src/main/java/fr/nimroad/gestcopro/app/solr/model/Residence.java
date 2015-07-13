package fr.nimroad.gestcopro.app.solr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import fr.nimroad.gestcopro.app.solr.definition.SearchableResidenceDefinition;

@Getter
@Setter
@ToString
public class Residence extends DTSearch implements SearchableResidenceDefinition {

	private Long id;
	
	private String name;

}
