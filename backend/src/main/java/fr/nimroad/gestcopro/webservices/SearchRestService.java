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
import fr.nimroad.gestcopro.app.solr.service.CoproprietaireService;

@Path("/search")
public class SearchRestService {

	private CoproprietaireService coproprietaireService = CoproprietaireService.getInstance();
	
	@GET
	@Path("{term}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@PathParam("term") String term){
		
		List<Coproprietaire> coproprietaires = coproprietaireService.findByFull(term);
		GenericEntity<List<Coproprietaire>> entity = new GenericEntity<List<Coproprietaire>>(coproprietaires) {};
		return Response.ok(entity).build();
	}
}
