package fr.nimroad.gestcopro.app.model.dao.implementation;

import fr.nimroad.gestcopro.app.model.dao.GenericDaoImpl;
import fr.nimroad.gestcopro.app.model.dao.ResidenceDao;
import fr.nimroad.gestcopro.app.model.entite.Residence;

public class ResidenceDaoImplementation extends GenericDaoImpl<Residence, Long> implements ResidenceDao {

	private ResidenceDaoImplementation(){}
	
	private static class ResidenceDaoHolder {
		private final static ResidenceDao INSTANCE = new ResidenceDaoImplementation();
	}
	
	public static ResidenceDao getInstance(){
		return ResidenceDaoHolder.INSTANCE;
	}

}
