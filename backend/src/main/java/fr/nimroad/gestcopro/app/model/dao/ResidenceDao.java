package fr.nimroad.gestcopro.app.model.dao;

import java.util.List;

import fr.nimroad.gestcopro.app.model.dao.implementation.ResidenceDaoImplementation;
import fr.nimroad.gestcopro.app.model.entite.Residence;

public interface ResidenceDao {

	static ResidenceDao getInstance(){
		return ResidenceDaoImplementation.getInstance();
	}
	
	List<Residence> getAll();
	
	Residence save(Residence residence);
}
