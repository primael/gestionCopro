package fr.nimroad.gestcopro.app.model.dao.implementation;

import javax.persistence.Query;

import fr.nimroad.gestcopro.app.model.dao.TypeVoieDao;
import fr.nimroad.gestcopro.app.model.entite.TypeVoie;
import fr.nimroad.gestcopro.utils.model.dao.GenericDaoImpl;

public class TypeVoieDaoImplementation extends GenericDaoImpl<TypeVoie, Integer> implements TypeVoieDao {

	private TypeVoieDaoImplementation(String persistenceUnitName){
		super(persistenceUnitName);
	}
	
	private static class TypeVoieDaoHolder {
		private final static TypeVoieDao INSTANCE = new TypeVoieDaoImplementation("gestcopro");
	}
	
	public static TypeVoieDao getInstance(){
		return TypeVoieDaoHolder.INSTANCE;
	}

	@Override
	public TypeVoie findByLibelle(String libelle) {
		Query findByLibelleQuery = this.getEntityManager().createNamedQuery("typevoie.by.libelle");
		findByLibelleQuery.setParameter("libelle", libelle);
		return (TypeVoie) findByLibelleQuery.getSingleResult();
	}

	@Override
	public TypeVoie findByAbbreviation(String abbreviation) {
		
		//Cas particulier de SEN (peut-être sentier ou sente)
		if("SEN".equals(abbreviation)){
			return null;
		}
		Query findByLibelleQuery = this.getEntityManager().createNamedQuery("typevoie.by.abbreviation");
		findByLibelleQuery.setParameter("abbreviation", abbreviation);
		return (TypeVoie) findByLibelleQuery.getSingleResult();
	}
}
