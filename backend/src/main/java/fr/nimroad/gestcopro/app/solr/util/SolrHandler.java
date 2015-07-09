package fr.nimroad.gestcopro.app.solr.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Cleanup;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import fr.nimroad.gestcopro.app.solr.model.Coproprietaire;

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
	
	public void add(SolrInputDocument solrInputDocument) throws SolrServerException, IOException{
		solr.add(solrInputDocument);
		solr.commit();
	}
	
	public static void main(String[] args) throws SolrServerException, IOException, ClassNotFoundException {
		
		Coproprietaire coproprietaire = new Coproprietaire();
		coproprietaire.setEmail("primael@l-infini.fr");
		coproprietaire.setFixe("09.58.45.23.65");
		coproprietaire.setId(1l);
		coproprietaire.setMobile("06 58 88 71 34");
		coproprietaire.setName("Bruant");
		coproprietaire.setPrenom("Primaël");
		
		System.out.println(coproprietaire + " <==> " + coproprietaire.hashCode());
		@Cleanup final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		@Cleanup final ObjectOutputStream oos = new ObjectOutputStream(baos);
		
		oos.writeObject(coproprietaire);
		
		byte[] object = baos.toByteArray();
		System.out.println(object);
		
		
		@Cleanup final InputStream bais = new ByteArrayInputStream(object);
		@Cleanup final ObjectInputStream ois = new ObjectInputStream(bais);

		Object test = ois.readObject();
		System.out.println(test + " <==> " + test.hashCode());
		
		/*SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.addFilterQuery("NOM_TRI:*AD*");*/
		
		//SolrHandler.INSTANCE.search(query);
	}
}
