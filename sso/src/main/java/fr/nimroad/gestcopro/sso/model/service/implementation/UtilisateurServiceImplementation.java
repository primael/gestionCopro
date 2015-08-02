package fr.nimroad.gestcopro.sso.model.service.implementation;

import fr.nimroad.gestcopro.sso.model.dao.UtilisateurDao;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.service.UtilisateurService;

public enum UtilisateurServiceImplementation implements UtilisateurService {

	INSTANCE;

	private final UtilisateurDao utilisateurDao = UtilisateurDao.getInstance();
	
	@Override
	public Utilisateur getUtilisateur(String identifiant) {
		return utilisateurDao.findByIdentifiant(identifiant);
	}
}
