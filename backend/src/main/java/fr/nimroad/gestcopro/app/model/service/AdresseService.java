package fr.nimroad.gestcopro.app.model.service;

import fr.nimroad.gestcopro.app.model.entite.Adresse;
import fr.nimroad.gestcopro.app.model.service.implementation.AdresseServiceImplementation;

public interface AdresseService {

	static AdresseService getInstance(){
		return AdresseServiceImplementation.INSTANCE;
	}
	
	Adresse sauvegarder(final Adresse adresse);
}
