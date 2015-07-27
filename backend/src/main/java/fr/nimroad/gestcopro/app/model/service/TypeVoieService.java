package fr.nimroad.gestcopro.app.model.service;

import fr.nimroad.gestcopro.app.model.entite.TypeVoie;
import fr.nimroad.gestcopro.app.model.service.implementation.TypeVoieServiceImplementation;

public interface TypeVoieService {

	static TypeVoieService getInstance(){
		return TypeVoieServiceImplementation.INSTANCE;
	}
	
	public TypeVoie getTypeVoie(TypeVoie typeVoie);
}
