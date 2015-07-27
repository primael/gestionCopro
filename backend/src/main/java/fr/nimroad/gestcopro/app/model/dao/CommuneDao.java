package fr.nimroad.gestcopro.app.model.dao;

import java.util.List;

import fr.nimroad.gestcopro.app.model.dao.implementation.CommuneDaoImplementation;
import fr.nimroad.gestcopro.app.model.entite.Commune;

public interface CommuneDao {

	static CommuneDao getInstance(){
		return CommuneDaoImplementation.getInstance();
	}
	
	Commune save(Commune commune);
	
	List<Commune> getAll();
	
	Commune findByCodePostalEtCodeInsee(String codePostal, String codeInsee);
}
