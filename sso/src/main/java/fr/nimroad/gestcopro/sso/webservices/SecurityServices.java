package fr.nimroad.gestcopro.sso.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.nimroad.gestcopro.sso.model.service.ConnexionService;

@Path("security")
public class SecurityServices {

	private ConnexionService connexionService = ConnexionService.getInstance();
	
	@GET
	@Path("connect/{login}/{password}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response connecter(@PathParam("login") String login, @PathParam("password") String password){
		boolean authenticationSucceed = connexionService.connected(login, password);
		
		if(authenticationSucceed){
			return Response.status(Status.OK).build();
		} else {
			return Response.status(Status.FORBIDDEN).build();
		}
	}
}
