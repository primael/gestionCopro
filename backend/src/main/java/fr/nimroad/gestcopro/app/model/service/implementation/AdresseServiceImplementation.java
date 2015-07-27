package fr.nimroad.gestcopro.app.model.service.implementation;

import fr.nimroad.gestcopro.app.model.dao.AdresseDao;
import fr.nimroad.gestcopro.app.model.entite.Adresse;
import fr.nimroad.gestcopro.app.model.service.AdresseService;
import fr.nimroad.gestcopro.app.model.service.CommuneService;
import fr.nimroad.gestcopro.app.model.service.TypeVoieService;
import fr.nimroad.third.geocoding.Geocoder;

public enum AdresseServiceImplementation implements AdresseService {

	INSTANCE;

	private CommuneService communeService = CommuneService.getInstance();
	private AdresseDao adresseDao = AdresseDao.getInstance();
	private TypeVoieService typeVoieService = TypeVoieService.getInstance();
	
	@Override
	public Adresse sauvegarder(Adresse adresse) {
		//On doit tout d'abord compléter/valider la commune
		adresse.setCommune(communeService.getCommune(adresse.getCommune()));
		
		//Puis le type de voie si renseigné
		adresse.setTypeVoie(typeVoieService.getTypeVoie(adresse.getTypeVoie()));
		
		//On géocode la localisation de l'adresse
		Geocoder.INSTANCE.geocodeAdress(adresse);
		
		adresseDao.save(adresse);
		
		return adresse;
	}
	
	
}
