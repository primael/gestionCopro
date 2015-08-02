package fr.nimroad.gestcopro.sso.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.service.ConnexionService;
import fr.nimroad.gestcopro.sso.model.service.UtilisateurService;
import fr.nimroad.gestcopro.sso.webservices.transport.AuthenticationObject;

@Path("session")
public class SecurityServices {

	private ConnexionService connexionService = ConnexionService.getInstance();
	
	private UtilisateurService utilisateurService = UtilisateurService.getInstance();
	
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
	
	@GET
	public void loggedIn(){
		System.out.println("loggedIn");
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response login(Utilisateur utilisateur){
		Response toReturn;
		
		boolean result = connexionService.connected(utilisateur.getIdentifiant(), utilisateur.getPassword());
		
		if(result){
			//On récupère l'utilisateur
			Utilisateur user = utilisateurService.getUtilisateur(utilisateur.getIdentifiant());
			
			//On créer l'objet de réponse
			AuthenticationObject entity = new AuthenticationObject();
			entity.setAuth(true);
			entity.setId(user.getId());
			entity.setUser(user);
			
			toReturn = Response.status(Status.OK).entity(entity).build();
		} else {
			toReturn = Response.status(Status.FORBIDDEN).build();
		}
		return toReturn;
	}
	
	@PUT
	public void relogin(){
		System.out.println("relogin");
	}
	
	@DELETE
	public void logout(){
		System.out.println("logout");
	}
}
