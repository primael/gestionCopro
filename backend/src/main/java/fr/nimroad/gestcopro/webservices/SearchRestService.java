package fr.nimroad.gestcopro.webservices;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.app.solr.service.CoproprietaireSolrService;
import fr.nimroad.gestcopro.app.solr.service.SearchSolrService;

@Path("/search")
public class SearchRestService {

	private CoproprietaireSolrService coproprietaireSolrService = CoproprietaireSolrService.getInstance();

	private SearchSolrService searchSolrService = SearchSolrService.getInstance();
	
	@GET
	@Path("coproprietaire/{term}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchCoproprietaire(@PathParam("term") String term) {

		List<Coproprietaire> coproprietaires = coproprietaireSolrService.findByFull(term);
		GenericEntity<List<Coproprietaire>> entity = new GenericEntity<List<Coproprietaire>>(coproprietaires) {
		};
		return Response.ok(entity) //
				.header("access-control-allow-origin", "http://127.0.0.1") //
				.header("access-control-expose-header", "Cache-Control,Content-Encoding") // 
				.build();
	}

	@GET
	@Path("coproprietaire/{start}/{nbRows}/{term}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchCoproprietaire(@PathParam("start") int start, @PathParam("nbRows") int nbRows,
			@PathParam("term") String term) {

		List<Coproprietaire> coproprietaires = coproprietaireSolrService.findByFull(term, start, nbRows);
		GenericEntity<List<Coproprietaire>> entity = new GenericEntity<List<Coproprietaire>>(coproprietaires) {
		};
		return Response.ok(entity).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("{term}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchAll(@PathParam("term") String term) {

		List resultats = searchSolrService.findByFull(term);
		GenericEntity<List> entity = new GenericEntity<List>(resultats) {};
		return Response.ok(entity).build();
	}
}
