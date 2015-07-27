package fr.nimroad.gestcopro.app.model.service.implementation;

import fr.nimroad.gestcopro.app.model.dao.TypeVoieDao;
import fr.nimroad.gestcopro.app.model.entite.TypeVoie;
import fr.nimroad.gestcopro.app.model.service.TypeVoieService;

public enum TypeVoieServiceImplementation implements TypeVoieService {

	INSTANCE;

	private TypeVoieDao typeVoieDao = TypeVoieDao.getInstance();
	
	@Override
	public TypeVoie getTypeVoie(TypeVoie typeVoie) {
		TypeVoie toReturn = null;
		if (typeVoie.getLibelle()!=null){
			toReturn = typeVoieDao.findByLibelle(typeVoie.getLibelle());
		} else if (typeVoie.getAbbreviation()!=null){
			toReturn = typeVoieDao.findByAbbreviation(typeVoie.getAbbreviation());
		}
		return toReturn;
	}
	
	
}
