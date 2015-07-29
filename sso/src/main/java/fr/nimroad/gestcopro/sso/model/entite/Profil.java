package fr.nimroad.gestcopro.sso.model.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Profil {

	@Id
	private Integer id;
	
	private String libelle;
}
