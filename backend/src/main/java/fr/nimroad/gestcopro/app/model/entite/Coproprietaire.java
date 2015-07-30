package fr.nimroad.gestcopro.app.model.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import fr.nimroad.gestcopro.app.model.entite.definition.SearchableCoproprietaireDefinition;
import fr.nimroad.gestcopro.utils.model.entite.Dto;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "COPROPRIETAIRE_SEQ", sequenceName = "SEQ_COPROPRIETAIRE", allocationSize = 1)
public class Coproprietaire implements Dto<Long> , SearchableCoproprietaireDefinition {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COPROPRIETAIRE_SEQ")
	@Column(name="c_uid")
	@JsonProperty
	private Long id;
	
	@Column(nullable=false, name="nom")
	@JsonProperty
	private String name;
	
	@Column(nullable=false)
	@JsonProperty
	private String prenom;

	@JsonProperty
	private String mobile;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String fixe;
	
	@JsonProperty
	private Adresse adresse;

}
