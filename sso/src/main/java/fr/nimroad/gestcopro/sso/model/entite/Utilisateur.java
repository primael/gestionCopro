package fr.nimroad.gestcopro.sso.model.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Utilisateur {
	
	@Id
	private String identifiant;
	
	private String hashPassword;
	
	private List<Profil> profil;
}
