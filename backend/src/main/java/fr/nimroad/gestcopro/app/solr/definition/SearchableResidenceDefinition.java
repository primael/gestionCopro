package fr.nimroad.gestcopro.app.solr.definition;

import java.io.Serializable;

public interface SearchableResidenceDefinition extends Serializable {
	
	String ID_FIELD_NAME = "IDX_RESIDENCE_ID";
	String NAME_FIELD_NAME = "NOM";
	String ADRESSE_FIELD_NAME = "ADRESSE";
	
	String NAME_TRI_FIELD = "NOM_TRI";
	String ADRESSE_TRI_FIELD = "ADRESSE_TRI";
	
	String URI = "URI";
	String FULL_RESULT = "FULL_RESULT";
	String URN = "RESIDENCE";
}
