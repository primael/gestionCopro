package fr.nimroad.gestcopro.sso.model.service;

import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.service.implementation.UtilisateurServiceImplementation;

public interface UtilisateurService {

	static UtilisateurService getInstance(){
		return UtilisateurServiceImplementation.INSTANCE;
	}
	
	Utilisateur getUtilisateur(String identifiant);
}
