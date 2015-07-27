package fr.nimroad.gestcopro.app.model.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonProperty;

import fr.nimroad.gestcopro.app.model.entite.definition.SearchableTypeVoieDefinition;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "TYPEVOIE_SEQ", sequenceName = "SEQ_TYPEVOIE", allocationSize = 1)
@NamedQueries({
	@NamedQuery(
			name="typevoie.by.libelle",
			query="SELECT typeVoie FROM TypeVoie typeVoie where typeVoie.libelle=:libelle"),
	@NamedQuery(
			name="typevoie.by.abbreviation",
			query="SELECT typeVoie FROM TypeVoie typeVoie where typeVoie.abbreviation=:abbreviation"),
})
public class TypeVoie implements Dto<Integer>, SearchableTypeVoieDefinition {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TYPEVOIE_SEQ")
	@Column(name="tv_uid")
	@JsonProperty
	private Integer id;
	
	private String abbreviation;
	
	private String libelle;
}
