package fr.nimroad.gestcopro.app.solr.mapper;

import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

import fr.nimroad.codec.Byte64Serializer;
import fr.nimroad.codec.CompressedSerializer;
import fr.nimroad.gestcopro.app.solr.definition.SearchableCoproprietaireDefinition;
import fr.nimroad.gestcopro.app.solr.model.Coproprietaire;
import fr.nimroad.gestcopro.app.solr.model.DTSearch;

public class CoproprietaireMapper extends AbstractSolrMapper {

	@Override
	public SolrInputDocument map(DTSearch dtSearch) {
		
		Coproprietaire coproprietaire = (Coproprietaire) dtSearch;
		// On créer un SolrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		
		document.addField(SearchableCoproprietaireDefinition.URI, SearchableCoproprietaireDefinition.URN + "@" + coproprietaire.getId());
		document.addField(SearchableCoproprietaireDefinition.FULL_RESULT, Byte64Serializer.INSTANCE.encode(CompressedSerializer.INSTANCE.encode(coproprietaire)));
		
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
		
		result.getFieldValueMap().forEach(new BiConsumer<String, Object>() {

			@Override
			public void accept(String t, Object u) {
				System.out.println(t +" = " + u);
			}
		});
		
		//System.out.println(value);
		
		//System.out.println(CompressedSerializer.INSTANCE.decode(Byte64Serializer.INSTANCE.decode(value)));
		return null;
	}

}
