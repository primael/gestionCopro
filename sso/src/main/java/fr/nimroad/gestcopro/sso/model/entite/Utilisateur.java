package fr.nimroad.gestcopro.sso.model.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.nimroad.gestcopro.utils.model.entite.Dto;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "UTILISATEUR_SEQ", sequenceName = "SEQ_UTILISATEUR", allocationSize = 1)
@NamedQueries({
	@NamedQuery(name="utilisateur.by.identifiant", query="select utilisateur from Utilisateur utilisateur where utilisateur.identifiant=:identifiant")
})
@JsonIgnoreProperties({"hashPassword", "salt"})
public class Utilisateur implements Dto<Long> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UTILISATEUR_SEQ")
	@JsonProperty
	private Long id;
	
	@Column(nullable=false, unique=true)
	@JsonProperty
	private String identifiant;
	
	@Column(nullable=false, length=32)
	private String hashPassword;
	
	@Column(nullable=false, length=32)
	private String salt;
	
	private List<Profil> profil;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String nom;
	
	@Column(nullable=false)
	private String prenom;
	
	@Transient
	@JsonProperty
	private transient String password;
	
	@Transient
	private int permission = 4;

}
