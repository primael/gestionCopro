package fr.nimroad.gestcopro.sso.model.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import fr.nimroad.gestcopro.utils.model.entite.Dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "PROFIL_SEQ", sequenceName = "SEQ_PROFIL", allocationSize = 1)
public class Profil implements Dto<Integer>{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PROFIL_SEQ")
	private Integer id;
	
	private String libelle;
}
