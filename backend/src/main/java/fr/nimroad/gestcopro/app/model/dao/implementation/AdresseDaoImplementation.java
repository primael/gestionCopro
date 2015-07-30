package fr.nimroad.gestcopro.app.model.dao.implementation;

import fr.nimroad.gestcopro.app.model.dao.AdresseDao;
import fr.nimroad.gestcopro.app.model.entite.Adresse;
import fr.nimroad.gestcopro.utils.model.dao.GenericDaoImpl;

public class AdresseDaoImplementation extends GenericDaoImpl<Adresse, Long> implements AdresseDao {

	private AdresseDaoImplementation(String persistenceUnitName){
		super(persistenceUnitName);
	}
	
	private static class AdresseDaoHolder{
		private final static AdresseDao INSTANCE = new AdresseDaoImplementation("gestcopro");
	}
	
	public static AdresseDao getInstance(){
		return AdresseDaoHolder.INSTANCE;
	}

}
