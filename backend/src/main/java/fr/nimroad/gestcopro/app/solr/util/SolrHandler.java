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

import fr.nimroad.gestcopro.app.solr.mapper.AbstractSolrMapper;
import fr.nimroad.gestcopro.app.solr.mapper.CoproprietaireMapper;
import fr.nimroad.gestcopro.app.solr.mapper.ResidenceMapper;
import fr.nimroad.gestcopro.app.util.PropertiesGetValue;
import fr.nimroad.gestcopro.utils.model.entite.Dto;

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
	
	
	public List<? extends Dto<?>> search(SolrQuery query, AbstractSolrMapper mapper) throws SolrServerException, IOException {
		QueryResponse response = solr.query(query);
		
		SolrDocumentList results = response.getResults();
		
		List<Dto<?>> toReturn = new ArrayList<Dto<?>>();
		for(SolrDocument objet: results){
			toReturn.add(mapper.unmap(objet));
		}
		
		return toReturn;
	}
	
	public List<Dto<?>> search(SolrQuery query) throws SolrServerException, IOException {
		QueryResponse response = solr.query(query);
		
		SolrDocumentList results = response.getResults();
		
		//FIXME spécialisation moche
		CoproprietaireMapper coproprietaireMapper = new CoproprietaireMapper();
		ResidenceMapper residenceMapper = new ResidenceMapper();
				
		List<Dto<?>> toReturn = new ArrayList<Dto<?>>();
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
	public void add(Dto<?> object, AbstractSolrMapper mapper) {
		solr.add(mapper.map(object));
		solr.commit();
	}
	
	@SneakyThrows
	public void flush(){
		solr.deleteByQuery("*:*");
	}
}
