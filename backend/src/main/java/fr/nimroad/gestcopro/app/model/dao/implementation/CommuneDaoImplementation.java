package fr.nimroad.gestcopro.app.model.dao.implementation;

import javax.persistence.Query;

import fr.nimroad.gestcopro.app.model.dao.CommuneDao;
import fr.nimroad.gestcopro.app.model.entite.Commune;
import fr.nimroad.gestcopro.utils.model.dao.GenericDaoImpl;

public class CommuneDaoImplementation extends GenericDaoImpl<Commune, Integer> implements CommuneDao {

	private CommuneDaoImplementation(String persistenceUnitName){
		super(persistenceUnitName);
	}
	
	private static class CommuneDaoHolder{
		private final static CommuneDao INSTANCE = new CommuneDaoImplementation("gestcopro");
	}
	
	public static CommuneDao getInstance(){
		return CommuneDaoHolder.INSTANCE;
	}

	@Override
	public Commune findByCodePostalEtCodeInsee(String codePostal, String codeInsee) {
		Query findByCodePostalEtCodeInseeQuery = this.getEntityManager().createNamedQuery("commune.by.codePostal.and.codeInsee");
		findByCodePostalEtCodeInseeQuery.setParameter("codePostal", codePostal);
		findByCodePostalEtCodeInseeQuery.setParameter("codeInsee", codeInsee);
		return (Commune) findByCodePostalEtCodeInseeQuery.getSingleResult();
	}
}
