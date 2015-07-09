package fr.nimroad.gestcopro.app.solr.util;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public enum SolrHandler {
	
	INSTANCE;
	
	private final SolrClient solr;
	
	private SolrHandler() {
		solr = new HttpSolrClient("http://127.0.0.1:8983/solr/COPROPRIETAIRE");
	}
	
	public void search(SolrQuery query/*, Mapper<SolrDocument, ?> mapper*/) throws SolrServerException, IOException {
		QueryResponse response = solr.query(query);
		
		SolrDocumentList results = response.getResults();
		
		for(SolrDocument objet: results){
			//mapper.map(objet);
			System.out.println(objet);
		}
	}
	
	public static void main(String[] args) throws SolrServerException, IOException {
		
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.addFilterQuery("NOM_TRI:*AD*");
		
		SolrHandler.INSTANCE.search(query);
	}
}
