package fr.nimroad.gestcopro.app.model.dao.implementation;

import fr.nimroad.gestcopro.app.model.dao.AdresseDao;
import fr.nimroad.gestcopro.app.model.dao.GenericDaoImpl;
import fr.nimroad.gestcopro.app.model.entite.Adresse;

public class AdresseDaoImplementation extends GenericDaoImpl<Adresse, Long> implements AdresseDao {

private AdresseDaoImplementation(){}
	
	private static class AdresseDaoHolder{
		private final static AdresseDao INSTANCE = new AdresseDaoImplementation();
	}
	
	public static AdresseDao getInstance(){
		return AdresseDaoHolder.INSTANCE;
	}

}
