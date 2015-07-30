package fr.nimroad.gestcopro.app.model.dao.implementation;

import fr.nimroad.gestcopro.app.model.dao.CoproprietaireDao;
import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.utils.model.dao.GenericDaoImpl;

public class CoproprietaireDaoImplementation extends GenericDaoImpl<Coproprietaire, Long> implements CoproprietaireDao {

	private CoproprietaireDaoImplementation(String persistenceUnitName){
		super(persistenceUnitName);
	}
	
	private static class CoproprietaireDaoHolder {
		private final static CoproprietaireDao INSTANCE = new CoproprietaireDaoImplementation("gestcopro");
	}
	
	public static CoproprietaireDao getInstance(){
		return CoproprietaireDaoHolder.INSTANCE;
	}
}
