package fr.nimroad.gestcopro.app.solr.util;

import java.io.IOException;

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
import fr.nimroad.gestcopro.app.solr.model.DTSearch;

public enum SolrHandler {
	
	COPROPRIETAIRE("COPROPRIETAIRE");
	
	private final SolrClient solr;
	
	private SolrHandler(String coreName) {
		solr = new HttpSolrClient("http://192.168.1.25:8983/solr/" + coreName);
	}
	
	public void search(SolrQuery query, AbstractSolrMapper mapper) throws SolrServerException, IOException {
		QueryResponse response = solr.query(query);
		
		SolrDocumentList results = response.getResults();
		
		for(SolrDocument objet: results){
			//mapper.map(objet);
			System.out.println(mapper.unmap(objet));
		}
	}
	
	@SneakyThrows
	public void add(DTSearch object, AbstractSolrMapper mapper) {
		solr.add(mapper.map(object));
		solr.commit();
	}
	
	public static void main(String[] args) throws SolrServerException, IOException, ClassNotFoundException {
		
		SolrQuery query = new SolrQuery("*:*");
		
		SolrHandler.COPROPRIETAIRE.search(query, new CoproprietaireMapper());
		
	}
}
