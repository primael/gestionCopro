package fr.nimroad.gestcopro.app.model.entite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import fr.nimroad.gestcopro.app.model.entite.definition.SearchableResidenceDefinition;

@Getter
@Setter
@ToString
public class Residence implements Dto<Long> , SearchableResidenceDefinition {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;

}
