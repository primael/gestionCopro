package fr.nimroad.gestcopro.app.solr.mapper;

import java.util.ArrayList;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

import fr.nimroad.gestcopro.app.solr.model.DTSearch;

public abstract class AbstractSolrMapper {

	public abstract SolrInputDocument map(DTSearch dtSearch);
	
	public abstract DTSearch unmap(SolrDocument result);
	
	String getString(Object value){
		@SuppressWarnings("unchecked")
		ArrayList<String> arrayList = (ArrayList<String>)value;
		return arrayList.get(0);
	}
}
