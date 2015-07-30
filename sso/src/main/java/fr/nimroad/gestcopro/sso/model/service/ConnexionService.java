package fr.nimroad.gestcopro.sso.model.service;

import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.service.implementation.ConnexionServiceImplementation;

public interface ConnexionService {

	static ConnexionService getInstance(){
		return ConnexionServiceImplementation.INSTANCE;
	}
	
	boolean connected(String identifiant, String password);
	
	Utilisateur createUSer(String identifiant, String password, String email);
}
