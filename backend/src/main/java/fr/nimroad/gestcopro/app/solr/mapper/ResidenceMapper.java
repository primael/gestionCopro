package fr.nimroad.gestcopro.app.solr.mapper;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

import fr.nimroad.codec.Byte64SerializerByte;
import fr.nimroad.codec.CompressedSerializer;
import fr.nimroad.gestcopro.app.solr.definition.SearchableResidenceDefinition;
import fr.nimroad.gestcopro.app.solr.model.DTSearch;
import fr.nimroad.gestcopro.app.solr.model.Residence;

public class ResidenceMapper extends AbstractSolrMapper {

	@Override
	public SolrInputDocument map(DTSearch dtSearch) {
		Residence residence = (Residence) dtSearch;
		
		SolrInputDocument document = new SolrInputDocument();
		
		document.addField(SearchableResidenceDefinition.URI, SearchableResidenceDefinition.URN + "@" + residence.getId());
		document.addField(SearchableResidenceDefinition.FULL_RESULT, Byte64SerializerByte.INSTANCE.encode(CompressedSerializer.INSTANCE.encode(residence)));
		
		document.addField(SearchableResidenceDefinition.NAME_FIELD_NAME, residence.getName());
		document.addField(SearchableResidenceDefinition.NAME_TRI_FIELD, residence.getName().toUpperCase());
		
		return document;
	}

	@Override
	public Residence unmap(SolrDocument result) {
		byte[] value = (byte[])result.getFieldValue("FULL_RESULT");
		
		return (Residence) CompressedSerializer.INSTANCE.decode(Byte64SerializerByte.INSTANCE.decode(value));
	}

}
