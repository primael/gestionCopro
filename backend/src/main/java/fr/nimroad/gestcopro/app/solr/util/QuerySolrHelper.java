package fr.nimroad.gestcopro.app.solr.util;

import org.apache.solr.client.solrj.SolrQuery;

public class QuerySolrHelper {

	private SolrQuery query = new SolrQuery();
	
	public QuerySolrHelper addFilterQuery(String... queries){
		this.query.addFilterQuery(queries);
		
		return this;
	}
}
