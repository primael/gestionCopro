package fr.nimroad.gestcopro.app.model.dao;

import java.util.List;

import fr.nimroad.gestcopro.app.model.dao.implementation.TypeVoieDaoImplementation;
import fr.nimroad.gestcopro.app.model.entite.TypeVoie;

public interface TypeVoieDao {

	static TypeVoieDao getInstance(){
		return TypeVoieDaoImplementation.getInstance();
	}
	
	TypeVoie save(TypeVoie typeVoie);
	
	List<TypeVoie> getAll();
	
	TypeVoie findByLibelle(String libelle);
	
	TypeVoie findByAbbreviation(String abbreviation);
}
