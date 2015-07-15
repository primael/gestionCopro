package fr.nimroad.gestcopro.app.solr.util;

import org.apache.solr.client.solrj.SolrQuery;

import fr.nimroad.gestcopro.app.util.PropertiesGetValue;

public class QuerySolrHelper {

	private SolrQuery query;
	
	private String filterQuery = "";
	
	public QuerySolrHelper(){
		this("*:*");
	}
	
	public QuerySolrHelper(String query){
		this.query = new SolrQuery(query);
	}
	
	public QuerySolrHelper addFilterQuery(String searchTerm, String query){
		
		filterQuery += " " + query + ":*" + searchTerm.toUpperCase() + "*";
		
		return this;
	}
	
	public QuerySolrHelper addAndFilterQuery(String searchTerm, String... queries){
		
		addGenericFilterQuery("AND", searchTerm, queries);
		return this;
	}
	
	public QuerySolrHelper addOrFilterQuery(String searchTerm, String... queries){
		
		addGenericFilterQuery("OR", searchTerm, queries);
		
		return this;
	}
	
	public QuerySolrHelper addCore(String... cores){
		String shard = "";
		
		for(String core : cores){
			if(!shard.isEmpty()){
				shard += ","; 
			}
			shard += PropertiesGetValue.CONFIG.getValue("solr.url") + core;
		}
		
		query.setParam("shards",shard);
		
		return this;
	}
	
	public QuerySolrHelper addStart(int start){
		query.setStart(start);
		return this;
	}
	
	public QuerySolrHelper setRows(int rows){
		query.setRows(rows);
		return this;
	}
	
	private void addGenericFilterQuery(String lien, String searchTerm, String... queries){
		for(String query : queries){
			if(!filterQuery.isEmpty()){
				filterQuery += " " + lien; 
			}
			filterQuery += " " + query + ":*" + searchTerm.toUpperCase() + "*";
		}		
	}
	
	public SolrQuery build(){
		return query.addFilterQuery(filterQuery); //.setParam("shards", "http://127.0.0.1:8983/solr/COPROPRIETAIRE");
	}
}
