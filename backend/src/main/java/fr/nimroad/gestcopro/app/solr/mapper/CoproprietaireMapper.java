package fr.nimroad.gestcopro.app.solr.mapper;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

import fr.nimroad.codec.Byte64SerializerByte;
import fr.nimroad.codec.CompressedSerializer;
import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.app.model.entite.Dto;
import fr.nimroad.gestcopro.app.model.entite.definition.SearchableCoproprietaireDefinition;

public class CoproprietaireMapper extends AbstractSolrMapper {

	@Override
	public SolrInputDocument map(Dto dtSearch) {
		
		Coproprietaire coproprietaire = (Coproprietaire) dtSearch;
		// On créer un SolrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		
		document.addField(SearchableCoproprietaireDefinition.URI, SearchableCoproprietaireDefinition.URN + "@" + coproprietaire.getId());
		document.addField(SearchableCoproprietaireDefinition.FULL_RESULT, Byte64SerializerByte.INSTANCE.encode(CompressedSerializer.INSTANCE.encode(coproprietaire)));
		document.addField(SearchableCoproprietaireDefinition.CONTENT, concatenateChamp(coproprietaire));
		
		document.addField(SearchableCoproprietaireDefinition.NAME_FIELD_NAME, coproprietaire.getName());
		document.addField(SearchableCoproprietaireDefinition.NAME_TRI_FIELD, coproprietaire.getName().toUpperCase());

		document.addField(SearchableCoproprietaireDefinition.FIRSTNAME_FIELD_NAME, coproprietaire.getPrenom());
		document.addField(SearchableCoproprietaireDefinition.FIRSTNAME_TRI_FIELD, coproprietaire.getPrenom().toUpperCase());
		
		document.addField(SearchableCoproprietaireDefinition.MOBILE_FIELD_NAME, coproprietaire.getMobile());
		document.addField(SearchableCoproprietaireDefinition.MOBILE_TRI_FIELD, coproprietaire.getMobile().trim().replaceAll("[.!?\\- ]", "").toUpperCase());
		
		document.addField(SearchableCoproprietaireDefinition.FIXE_FIELD_NAME, coproprietaire.getFixe());
		document.addField(SearchableCoproprietaireDefinition.FIXE_TRI_FIELD, coproprietaire.getFixe().trim().replaceAll("[.!?\\- ]", "").toUpperCase());
		
		document.addField(SearchableCoproprietaireDefinition.MAIL_FIELD_NAME, coproprietaire.getEmail());
		document.addField(SearchableCoproprietaireDefinition.MAIL_TRI_FIELD, coproprietaire.getEmail().toLowerCase());
		
		return document;
	}

	@Override
	public Coproprietaire unmap(SolrDocument result) {
		
		byte[] value = (byte[])result.getFieldValue("FULL_RESULT");
		
		return (Coproprietaire) CompressedSerializer.INSTANCE.decode(Byte64SerializerByte.INSTANCE.decode(value));
	}

	private String concatenateChamp(Coproprietaire coproprietaire){
		String toReturn = coproprietaire.getName().toUpperCase() + " " + coproprietaire.getPrenom().toUpperCase() + " " + coproprietaire.getMobile().trim().replaceAll("[.!?\\- ]", "").toUpperCase() + " ";
		toReturn += coproprietaire.getFixe().trim().replaceAll("[.!?\\- ]", "").toUpperCase() + " " + coproprietaire.getEmail().toLowerCase();
		return toReturn;
	}
}
