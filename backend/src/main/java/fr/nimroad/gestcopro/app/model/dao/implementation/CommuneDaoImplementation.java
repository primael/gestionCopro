package fr.nimroad.gestcopro.app.model.dao.implementation;

import javax.persistence.Query;

import fr.nimroad.gestcopro.app.model.dao.CommuneDao;
import fr.nimroad.gestcopro.app.model.dao.GenericDaoImpl;
import fr.nimroad.gestcopro.app.model.entite.Commune;

public class CommuneDaoImplementation extends GenericDaoImpl<Commune, Integer> implements CommuneDao {

	private CommuneDaoImplementation(){}
	
	private static class CommuneDaoHolder{
		private final static CommuneDao INSTANCE = new CommuneDaoImplementation();
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
