package fr.nimroad.gestcopro.app.solr.mapper;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

import fr.nimroad.codec.Byte64SerializerByte;
import fr.nimroad.codec.CompressedSerializer;
import fr.nimroad.gestcopro.app.model.entite.Dto;
import fr.nimroad.gestcopro.app.model.entite.Residence;
import fr.nimroad.gestcopro.app.model.entite.definition.SearchableResidenceDefinition;

public class ResidenceMapper extends AbstractSolrMapper {

	@Override
	public SolrInputDocument map(Dto dtSearch) {
		Residence residence = (Residence) dtSearch;
		
		SolrInputDocument document = new SolrInputDocument();
		
		document.addField(SearchableResidenceDefinition.URI, SearchableResidenceDefinition.URN + "@" + residence.getId());
		document.addField(SearchableResidenceDefinition.FULL_RESULT, Byte64SerializerByte.INSTANCE.encode(CompressedSerializer.INSTANCE.encode(residence)));
		document.addField(SearchableResidenceDefinition.CONTENT, concatenateChamp(residence));
		
		document.addField(SearchableResidenceDefinition.NAME_FIELD_NAME, residence.getName());
		document.addField(SearchableResidenceDefinition.NAME_TRI_FIELD, residence.getName().toUpperCase());
		
		return document;
	}

	@Override
	public Residence unmap(SolrDocument result) {
		byte[] value = (byte[])result.getFieldValue("FULL_RESULT");
		
		return (Residence) CompressedSerializer.INSTANCE.decode(Byte64SerializerByte.INSTANCE.decode(value));
	}
	
	private String concatenateChamp(Residence residence){
		String toReturn = residence.getName().toUpperCase();
		return toReturn;
	}

}
