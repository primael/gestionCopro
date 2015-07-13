package fr.nimroad.gestcopro.app.model.entite.definition;


public interface SearchableCoproprietaireDefinition extends SearchableDefinition {

	String ID_FIELD_NAME = "IDX_COPROPRIETAIRE_ID";
	String NAME_FIELD_NAME = "NOM";
	String FIRSTNAME_FIELD_NAME = "PRENOM";
	String MOBILE_FIELD_NAME = "MOBILE";
	String FIXE_FIELD_NAME = "FIXE";
	String MAIL_FIELD_NAME = "EMAIL";
	String ADRESSE_FIELD_NAME = "ADRESSE";
	
	String NAME_TRI_FIELD = "NOM_TRI";
	String FIRSTNAME_TRI_FIELD = "PRENOM_TRI";
	String MOBILE_TRI_FIELD = "MOBILE_TRI";
	String FIXE_TRI_FIELD = "FIXE_TRI";
	String MAIL_TRI_FIELD = "EMAIL_TRI";
	String ADRESSE_TRI_FIELD = "ADRESSE_TRI";
	
	String URN = "COPROPRIETAIRE";
}
