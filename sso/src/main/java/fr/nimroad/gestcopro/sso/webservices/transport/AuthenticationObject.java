package fr.nimroad.gestcopro.sso.webservices.transport;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;

@Getter
@Setter
@ToString
public class AuthenticationObject {

	@JsonProperty
	private boolean auth;
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private Utilisateur user;
	
	@JsonProperty
	private UUID token;
}
