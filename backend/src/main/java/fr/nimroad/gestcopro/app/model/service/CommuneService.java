package fr.nimroad.gestcopro.app.model.service;

import fr.nimroad.gestcopro.app.model.entite.Commune;
import fr.nimroad.gestcopro.app.model.service.implementation.CommuneServiceImplementation;

public interface CommuneService {

	static CommuneService getInstance(){
		return CommuneServiceImplementation.INSTANCE;
	}
	
	public Commune getCommune(Commune commune);
}
