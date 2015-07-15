package fr.nimroad.gestcopro.app.model.dao;

import java.util.List;

import fr.nimroad.gestcopro.app.model.dao.implementation.CoproprietaireDaoImplementation;
import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;

public interface CoproprietaireDao {

	static CoproprietaireDao getInstance(){
		return CoproprietaireDaoImplementation.getInstance();
	}
	
	List<Coproprietaire> getAll();
}
