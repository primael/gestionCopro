package fr.nimroad.gestcopro.app.model.dao;

import java.util.List;

import fr.nimroad.gestcopro.app.model.dao.implementation.AdresseDaoImplementation;
import fr.nimroad.gestcopro.app.model.entite.Adresse;

public interface AdresseDao {

	static AdresseDao getInstance(){
		return AdresseDaoImplementation.getInstance();
	}
	
	Adresse save(Adresse adresse);
	
	List<Adresse> getAll();
}
