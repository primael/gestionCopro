package fr.nimroad.gestcopro.sso.model.dao;

import fr.nimroad.gestcopro.sso.model.dao.implementation.UtilisateurDaoImplemation;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;

public interface UtilisateurDao {

	static UtilisateurDao getInstance(){
		return UtilisateurDaoImplemation.getInstance();
	}
	
	Utilisateur findByIdentifiant(String identifiant);
	
	Utilisateur save(Utilisateur utilisateur);
}
