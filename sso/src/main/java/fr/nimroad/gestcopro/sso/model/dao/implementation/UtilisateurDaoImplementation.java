package fr.nimroad.gestcopro.sso.model.dao.implementation;

import java.util.HashMap;
import java.util.Map;

import fr.nimroad.gestcopro.sso.model.dao.UtilisateurDao;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;

public enum UtilisateurDaoImplementation implements UtilisateurDao {

	INSTANCE;
	
	@Override
	public Utilisateur findByIdentifiant(String identifiant) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("identifiant", identifiant);
		
		Utilisateur toReturn = null;
		
		try{
			toReturn = this.findOneWhithNamedQuery("utilisateur.by.identifiant", parameters);
		} catch(Exception exception){
			//Renvoie null
		}
		
		return toReturn;
	}
}
