package fr.nimroad.gestcopro.app.solr.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.SneakyThrows;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.app.model.entite.Dto;
import fr.nimroad.gestcopro.app.model.entite.Residence;
import fr.nimroad.gestcopro.app.solr.mapper.AbstractSolrMapper;
import fr.nimroad.gestcopro.app.solr.mapper.CoproprietaireMapper;
import fr.nimroad.gestcopro.app.solr.mapper.ResidenceMapper;
import fr.nimroad.gestcopro.app.solr.service.CoproprietaireSolrService;
import fr.nimroad.gestcopro.app.solr.service.SearchSolrService;
import fr.nimroad.gestcopro.app.util.PropertiesGetValue;

public enum SolrHandler {
	
	COPROPRIETAIRE("COPROPRIETAIRE"),
	RESIDENCE("RESIDENCE");
	
	private final SolrClient solr;
	
	@Getter
	private final String url;
	
	private SolrHandler(String coreName) {
		this.url = PropertiesGetValue.CONFIG.getValue("solr.url") + coreName;
		solr = new HttpSolrClient(url);
	}
	
	
	public List<? extends Dto> search(SolrQuery query, AbstractSolrMapper mapper) throws SolrServerException, IOException {
		QueryResponse response = solr.query(query);
		
		SolrDocumentList results = response.getResults();
		
		List<Dto> toReturn = new ArrayList<Dto>();
		for(SolrDocument objet: results){
			toReturn.add(mapper.unmap(objet));
		}
		
		return toReturn;
	}
	
	public List<Dto> search(SolrQuery query) throws SolrServerException, IOException {
		QueryResponse response = solr.query(query);
		
		SolrDocumentList results = response.getResults();
		
		//FIXME spécialisation moche
		CoproprietaireMapper coproprietaireMapper = new CoproprietaireMapper();
		ResidenceMapper residenceMapper = new ResidenceMapper();
				
		List<Dto> toReturn = new ArrayList<Dto>();
		for(SolrDocument objet: results){
			
			if(((String)objet.get("URI")).startsWith("COPROPRIETAIRE")){
				toReturn.add(coproprietaireMapper.unmap(objet));
			} else if(((String)objet.get("URI")).startsWith("RESIDENCE")){
				toReturn.add(residenceMapper.unmap(objet));
			}
		}
		
		return toReturn;
	}
	
	@SneakyThrows
	public void add(Dto object, AbstractSolrMapper mapper) {
		solr.add(mapper.map(object));
		solr.commit();
	}
	
	public static void main(String[] args) throws SolrServerException, IOException, ClassNotFoundException {
		
//		Coproprietaire coproprietaire = new Coproprietaire();
//		coproprietaire.setId(1l);
//		coproprietaire.setEmail("primael.bruant@l-infini.fr");
//		coproprietaire.setFixe("01 05 09 07 03");
//		coproprietaire.setMobile("06-58-88-71-34");
//		coproprietaire.setName("Bruant");
//		coproprietaire.setPrenom("Primaël");
//		
//		SolrHandler.COPROPRIETAIRE.add(coproprietaire, new CoproprietaireMapper());
//		
//		coproprietaire.setId(2l);
//		coproprietaire.setEmail("e.satoulou@hotmail.fr");
//		coproprietaire.setFixe("01.01.02.03.04");
//		coproprietaire.setMobile("06.05.06.07.08");
//		coproprietaire.setName("Satoulou");
//		coproprietaire.setPrenom("Eumaël");
//		
//		SolrHandler.COPROPRIETAIRE.add(coproprietaire, new CoproprietaireMapper());
//		
//		Residence residence = new Residence();
//		residence.setId(1l);
//		residence.setName("Residence Clos Boissy - Limeil Brevannes");
//		
//		SolrHandler.RESIDENCE.add(residence, new ResidenceMapper());
		
//		CoproprietaireService service = CoproprietaireService.getInstance();
//		for(Coproprietaire coproprietaire : service.findByFull("maél")){
//			System.out.println(coproprietaire);
//		}
		
		
		SearchSolrService service = SearchSolrService.getInstance();
		for(Dto dtSearch : service.findByFull("morel")){
			System.out.println(dtSearch);
		}
	}
}
