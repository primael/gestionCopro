package fr.nimroad.gestcopro.app.model.service;

import java.util.List;

import fr.nimroad.gestcopro.app.model.entite.Residence;
import fr.nimroad.gestcopro.app.model.service.implementation.ResidenceServiceImplementation;

public interface ResidenceService {

	static ResidenceService getInstance(){
		return ResidenceServiceImplementation.INSTANCE;
	}
	
	List<Residence> getAll();
	
	Residence sauvegarder(Residence residence);
}
