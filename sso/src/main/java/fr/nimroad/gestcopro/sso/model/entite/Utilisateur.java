package fr.nimroad.gestcopro.sso.model.entite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Utilisateur {
	
	private String identifiant;
	
	private String hashPassword;
	
	
}
