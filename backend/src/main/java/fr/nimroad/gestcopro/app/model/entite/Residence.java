package fr.nimroad.gestcopro.app.model.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import fr.nimroad.gestcopro.app.model.entite.definition.SearchableResidenceDefinition;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "RESIDENCE_SEQ", sequenceName = "SEQ_RESIDENCE", allocationSize = 1)
public class Residence implements Dto<Long> , SearchableResidenceDefinition {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESIDENCE_SEQ")
	@JsonProperty
	private Long id;
	
	@Column(nullable=false, name="nom")
	@JsonProperty
	private String name;
	
	@JsonProperty
	private Adresse adresse;

}
