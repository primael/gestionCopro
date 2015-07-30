package fr.nimroad.gestcopro.app.model.entite;

import java.math.BigDecimal;

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

import fr.nimroad.gestcopro.app.model.entite.definition.SearchableAdresseDefinition;
import fr.nimroad.gestcopro.utils.model.entite.Dto;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "ADRESSE_SEQ", sequenceName = "SEQ_ADRESSE", allocationSize = 1)
public class Adresse implements Dto<Long> , SearchableAdresseDefinition {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ADRESSE_SEQ")
	@Column(name="c_uid")
	@JsonProperty
	private Long id;
	
	/**
	 * Mentions complémentaires (comme l'appartement, l'étage, l'escalier, ...)
	 */
	@JsonProperty
	private String mentionComplement;
	
	/**
	 * Le cas échéant du bâtiment ou de la résidence
	 */
	@JsonProperty
	private String complementAdresse;
	
	/**
	 * Numéro dans la voie (on peux avoir 1,2,3... mais aussi 11/15, 12-26...)
	 */
	@JsonProperty
	private String numero;
	
	/**
	 * Complément de numéro tel bis, ter, quater, etc.
	 */
	@JsonProperty
	private String complementNumero;
	
	/**
	 * rue, avenue, etc.
	 */
	@JsonProperty
	private TypeVoie typeVoie;
	
	/**
	 * Nom de la voie
	 */
	@JsonProperty
	private String nomVoie;

	@JsonProperty
	private String hameau;

	@JsonProperty
	private Integer numeroBoitePostale;
	
	@JsonProperty
	private Commune commune;
	
	@JsonProperty
	private BigDecimal lattitude;
	
	@JsonProperty
	private BigDecimal longitude;
}
