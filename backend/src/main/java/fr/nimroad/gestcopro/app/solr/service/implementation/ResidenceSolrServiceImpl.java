package fr.nimroad.gestcopro.app.solr.service.implementation;

import java.util.List;

import fr.nimroad.gestcopro.app.model.entite.Residence;
import fr.nimroad.gestcopro.app.model.service.ResidenceService;
import fr.nimroad.gestcopro.app.solr.mapper.ResidenceMapper;
import fr.nimroad.gestcopro.app.solr.service.ResidenceSolrService;
import fr.nimroad.gestcopro.app.solr.util.SolrHandler;

public enum ResidenceSolrServiceImpl implements ResidenceSolrService {

	INSTANCE;

	private final ResidenceService residenceService = ResidenceService.getInstance();
	
	@Override
	public void fullReindexation() {
		// On supprime les objets indexés
		SolrHandler.RESIDENCE.flush();

		// On récupère la liste de toutes les résidences
		// FIXME dans la vrai vie on prendrait par tranche de N (étant défini dans le fichier de configuraion externe)
		List<Residence> residences = residenceService.getAll();

		for (Residence residence : residences) {
			SolrHandler.RESIDENCE.add(residence, new ResidenceMapper());
		}

	}

	@Override
	public void indexer(Residence residence) {
		// TODO Auto-generated method stub

	}

}
