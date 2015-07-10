package fr.nimroad.gestcopro.config;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = { "fr.nimroad.gestcopro.app.solr.model",
		"fr.nimroad.gestcopro.app.solr.repository", "fr.nimroad.gestcopro.app.web" }, multicoreSupport = true)
public class SearchContext {

	@Bean
	public HttpSolrServer solrServer(@Value("${solr.host}") String solrHost) {
		return new HttpSolrServer(solrHost);
	}
}
