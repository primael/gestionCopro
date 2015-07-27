package fr.nimroad.gestcopro.webservices;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.nimroad.gestcopro.app.model.entite.Coproprietaire;
import fr.nimroad.gestcopro.app.model.service.CoproprietaireService;
import fr.nimroad.gestcopro.app.solr.service.CoproprietaireSolrService;
import fr.nimroad.gestcopro.aspect.Loggable;

@Path("/coproprietaire")
public class CoproprietaireRestService {

	private CoproprietaireService coproprietaireService = CoproprietaireService.getInstance();
	private CoproprietaireSolrService coproprietaireSolrService = CoproprietaireSolrService.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		List<Coproprietaire> coproprietaires = coproprietaireService.getAll();
		GenericEntity<List<Coproprietaire>> entity = new GenericEntity<List<Coproprietaire>>(coproprietaires) {};
		return Response.ok(entity).build();
	}
	
	@GET
	@Path("reindexation")
	public Response reindex(){
		coproprietaireSolrService.fullReindexation();
		return Response.ok().build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sauvegarder(Coproprietaire coproprietaire){
		coproprietaireService.sauvegarder(coproprietaire);
		coproprietaireSolrService.indexer(coproprietaire);
		return Response.ok(coproprietaire).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Loggable
	public Response mettreAJour(Coproprietaire coproprietaire){
		coproprietaireService.sauvegarder(coproprietaire);
		coproprietaireSolrService.indexer(coproprietaire);
		return Response.ok(coproprietaire).build();
	}
	
}
