package fr.nimroad.gestcopro.app.model.dao.implementation;

import fr.nimroad.gestcopro.app.model.dao.CoproprietaireDao;
import fr.nimroad.gestcopro.app.model.dao.GenericDaoImpl;
import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;

public class CoproprietaireDaoImplementation extends GenericDaoImpl<Coproprietaire, Long> implements CoproprietaireDao {

	private CoproprietaireDaoImplementation(){}
	
	private static class CoproprietaireDaoHolder {
		private final static CoproprietaireDao INSTANCE = new CoproprietaireDaoImplementation();
	}
	
	public static CoproprietaireDao getInstance(){
		return CoproprietaireDaoHolder.INSTANCE;
	}
}
