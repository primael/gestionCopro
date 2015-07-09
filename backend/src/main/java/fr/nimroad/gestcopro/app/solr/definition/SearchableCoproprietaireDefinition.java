package fr.nimroad.gestcopro.app.solr.definition;

import java.io.Serializable;

public interface SearchableCoproprietaireDefinition extends Serializable {

	String ID_FIELD_NAME = "IDX_COPROPRIETAIRE_ID";
	String NAME_FIELD_NAME = "NOM";
	String FIRSTNAME_FIELD_NAME = "PRENOM";
	String MOBILE_FIELD_NAME = "MOBILE";
	String FIXE_FIELD_NAME = "FIXE";
	String MAIL_FIELD_NAME = "MAIL";
	//String LOCATION_FIELD_NAME = "adresse";
	
	String NAME_TRI_FIELD = "NOM_TRI";
	String FIRSTNAME_TRI_FIELD = "PRENOM_TRI";
}
