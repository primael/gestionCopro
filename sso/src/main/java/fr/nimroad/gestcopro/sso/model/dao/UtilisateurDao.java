package fr.nimroad.gestcopro.sso.model.dao;

import fr.nimroad.gestcopro.sso.model.dao.implementation.UtilisateurDaoImplementation;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.utils.model.dao.DataAccessObject;

public interface UtilisateurDao extends DataAccessObject<Long, Utilisateur>{

	static UtilisateurDao getInstance(){
		return UtilisateurDaoImplementation.INSTANCE;
	}
	
	Utilisateur findByIdentifiant(String identifiant);
	
	//Utilisateur save(Utilisateur utilisateur);
}
