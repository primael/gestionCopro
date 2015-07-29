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
	 * Image encodée en base64.
	 */
	private String icone;
	
	/**
	 * Lien d'accès à l'application.
	 */
	private String link;
}
