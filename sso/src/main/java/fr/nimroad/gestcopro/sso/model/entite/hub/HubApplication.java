package fr.nimroad.gestcopro.sso.model.entite.hub;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class HubApplication {

	@Id
	private Long idn;
	
	/**
	 * Nom de l'application.
	 */
	private String nom;
	
	/**
	 * Image encod�e en base64.
	 */
	private String icone;
	
	/**
	 * Lien d'acc�s � l'application.
	 */
	private String link;
}
