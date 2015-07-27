package fr.nimroad.gestcopro.app.model.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.codehaus.jackson.annotate.JsonProperty;

import fr.nimroad.gestcopro.app.model.entite.definition.SearchableCommuneDefinition;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "COMMUNE_SEQ", sequenceName = "SEQ_COMMUNE", allocationSize = 1)
@NamedQueries({
	@NamedQuery(name="commune.by.codePostal.and.codeInsee", 
			query="select commune from Commune commune where commune.codePostal=:codePostal and commune.codeInsee=:codeInsee")
})
public class Commune implements Dto<Integer>, SearchableCommuneDefinition {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COMMUNE_SEQ")
	@Column(name="c_uid")
	@JsonProperty
	private Integer id;
	
	@JsonProperty
	private String codeInsee;
	
	@JsonProperty
	private String article;
	
	@JsonProperty
	private String nom;
	
	@JsonProperty
	private String codePostal;
	
	private String libelleRecherche;
	
}
