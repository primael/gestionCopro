package fr.nimroad.gestcopro.app.solr.service.implementation;

import java.util.List;

import lombok.SneakyThrows;
import fr.nimroad.gestcopro.app.model.dao.CoproprietaireDao;
import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.app.model.entite.definition.SearchableCoproprietaireDefinition;
import fr.nimroad.gestcopro.app.solr.mapper.CoproprietaireMapper;
import fr.nimroad.gestcopro.app.solr.service.CoproprietaireSolrService;
import fr.nimroad.gestcopro.app.solr.util.QuerySolrHelper;
import fr.nimroad.gestcopro.app.solr.util.SolrHandler;

public enum CoproprietaireServiceImpl implements CoproprietaireSolrService {

	INSTANCE;

	private final CoproprietaireDao coproprietaireDao = CoproprietaireDao.getInstance();
	
	@Override
	public Coproprietaire findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@SneakyThrows
	public List<Coproprietaire> findByNom(String searchTerm) {
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		querySolrHelper.addFilterQuery(searchTerm,
				SearchableCoproprietaireDefinition.NAME_TRI_FIELD);

		return (List<Coproprietaire>) SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build(), new CoproprietaireMapper());
	}

	@Override
	@SneakyThrows
	@SuppressWarnings("unchecked")
	public List<Coproprietaire> findByNomOrPrenom(String searchTerm) {
		//Collection<String> terms = splitSearchTermAndRemoveIgnoredCharacters(searchTerm);
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		//for(String term : terms){
			querySolrHelper.addOrFilterQuery(searchTerm,
					SearchableCoproprietaireDefinition.NAME_TRI_FIELD, SearchableCoproprietaireDefinition.FIRSTNAME_TRI_FIELD);
		//}
		return (List<Coproprietaire>) SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build(), new CoproprietaireMapper());
	}

	@SuppressWarnings("unchecked")
	@Override
	@SneakyThrows
	public List<Coproprietaire> findByFull(String searchTerm) {
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		querySolrHelper.addOrFilterQuery(searchTerm,
				SearchableCoproprietaireDefinition.NAME_TRI_FIELD, SearchableCoproprietaireDefinition.FIRSTNAME_TRI_FIELD,
				SearchableCoproprietaireDefinition.ADRESSE_TRI_FIELD, SearchableCoproprietaireDefinition.FIXE_TRI_FIELD,
				SearchableCoproprietaireDefinition.MOBILE_FIELD_NAME, SearchableCoproprietaireDefinition.MAIL_TRI_FIELD);
		
		return (List<Coproprietaire>) SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build(), new CoproprietaireMapper());
	}
	
	@Override
	@SneakyThrows
	@SuppressWarnings("unchecked")
	public List<Coproprietaire> findByFull(String searchTerm, int start, int nbRows) {
		QuerySolrHelper querySolrHelper = new QuerySolrHelper();
		querySolrHelper.addOrFilterQuery(searchTerm,
				SearchableCoproprietaireDefinition.NAME_TRI_FIELD, SearchableCoproprietaireDefinition.FIRSTNAME_TRI_FIELD,
				SearchableCoproprietaireDefinition.ADRESSE_TRI_FIELD, SearchableCoproprietaireDefinition.FIXE_TRI_FIELD,
				SearchableCoproprietaireDefinition.MOBILE_FIELD_NAME, SearchableCoproprietaireDefinition.MAIL_TRI_FIELD);
		querySolrHelper.addStart(start).setRows(nbRows);
		
		return (List<Coproprietaire>) SolrHandler.COPROPRIETAIRE.search(querySolrHelper.build(), new CoproprietaireMapper());
	}


	@Override
	public void fullReindexation() {
		//On supprime les objets indexés
		SolrHandler.COPROPRIETAIRE.flush();
		
		// On récupère la liste de tous les copropriétaires
		//FIXME dans la vrai vie on prendrait par tranche de N (étant défini dans le fichier de configuraion externe)
		List<Coproprietaire> coproprietaires = coproprietaireDao.getAll();
		
		for(Coproprietaire coproprietaire : coproprietaires){
			SolrHandler.COPROPRIETAIRE.add(coproprietaire, new CoproprietaireMapper());
		}
	}

	@Override
	public void indexer(Coproprietaire coproprietaire) {
		SolrHandler.COPROPRIETAIRE.add(coproprietaire, new CoproprietaireMapper());
	}
	
	

}
