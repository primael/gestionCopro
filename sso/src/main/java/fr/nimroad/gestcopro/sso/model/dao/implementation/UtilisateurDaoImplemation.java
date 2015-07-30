package fr.nimroad.gestcopro.sso.model.dao.implementation;

import java.util.HashMap;
import java.util.Map;

import fr.nimroad.gestcopro.sso.model.dao.UtilisateurDao;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.utils.model.dao.GenericDaoImpl;

public class UtilisateurDaoImplemation extends GenericDaoImpl<Utilisateur, Long> implements UtilisateurDao {

	private UtilisateurDaoImplemation(){
		super("gestcoprosso");
	}
	
	private static class UtilisateurDaoHolder{
		private final static UtilisateurDao INSTANCE = new UtilisateurDaoImplemation();
	}
	
	public static UtilisateurDao getInstance(){
		return UtilisateurDaoHolder.INSTANCE;
	}
	
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
