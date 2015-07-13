package fr.nimroad.gestcopro.app.model.entite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import fr.nimroad.gestcopro.app.model.entite.definition.SearchableCoproprietaireDefinition;

@Getter
@Setter
@ToString
public class Coproprietaire implements Dto<Long> , SearchableCoproprietaireDefinition {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String prenom;

	private String mobile;
	
	private String email;
	
	private String fixe;

}
