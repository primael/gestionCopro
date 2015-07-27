package fr.nimroad.gestcopro.app.solr.mapper;

import java.util.ArrayList;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

import fr.nimroad.gestcopro.app.model.entite.Dto;

public abstract class AbstractSolrMapper {

	public abstract SolrInputDocument map(Dto<?> dtSearch);
	
	public abstract Dto<?> unmap(SolrDocument result);
	
	String getString(Object value){
		@SuppressWarnings("unchecked")
		ArrayList<String> arrayList = (ArrayList<String>)value;
		return arrayList.get(0);
	}
}
