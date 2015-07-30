package fr.nimroad.gestcopro.app.model.dao.implementation;

import fr.nimroad.gestcopro.app.model.dao.ResidenceDao;
import fr.nimroad.gestcopro.app.model.entite.Residence;
import fr.nimroad.gestcopro.utils.model.dao.GenericDaoImpl;

public class ResidenceDaoImplementation extends GenericDaoImpl<Residence, Long> implements ResidenceDao {

	private ResidenceDaoImplementation(String persistenceUnitName){
		super(persistenceUnitName);
	}
	
	private static class ResidenceDaoHolder {
		private final static ResidenceDao INSTANCE = new ResidenceDaoImplementation("gestcopro");
	}
	
	public static ResidenceDao getInstance(){
		return ResidenceDaoHolder.INSTANCE;
	}

}
