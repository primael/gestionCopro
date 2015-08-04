package fr.nimroad.gestcopro.sso.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.nimroad.gestcopro.exception.GestCoproException;
import fr.nimroad.gestcopro.sso.model.entite.Token;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.entite.token.TypeToken;
import fr.nimroad.gestcopro.sso.model.service.ConnexionService;
import fr.nimroad.gestcopro.sso.model.service.TokenService;
import fr.nimroad.gestcopro.sso.model.service.UtilisateurService;
import fr.nimroad.gestcopro.sso.tools.JsonTools;
import fr.nimroad.gestcopro.sso.webservices.transport.AuthenticationObject;

@Path("session")
public class SecurityServices {

	private ConnexionService connexionService = ConnexionService.getInstance();
	
	@SuppressWarnings("unchecked")
	private TokenService<Token> authenticationTokenService = (TokenService<Token>) TokenService.getService(TypeToken.AUTHENTIFICATIONTOKEN);
	
	private UtilisateurService utilisateurService = UtilisateurService.getInstance();
	
	@GET
	public void loggedIn(){
		System.out.println("loggedIn");
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response login(Utilisateur utilisateur){
		Response toReturn;
		
		try {
			boolean result = connexionService.connected(utilisateur.getIdentifiant(), utilisateur.getPassword());
			
			if(result){
				//On récupère l'utilisateur
				Utilisateur user = utilisateurService.getUtilisateur(utilisateur.getIdentifiant());
				
				//On créer un jeton de connexion
				Token token = authenticationTokenService.createToken(utilisateur);
				
				//On créer l'objet de réponse
				AuthenticationObject entity = new AuthenticationObject();
				entity.setAuth(true);
				entity.setId(user.getId());
				entity.setUser(user);
				entity.setToken(token.getToken());
				
				toReturn = Response.status(Status.OK).entity(JsonTools.INSTANCE.objectToJson(entity)).build();
			} else {
				toReturn = Response.status(Status.FORBIDDEN).build();
			}
		} catch (GestCoproException exception) {
			toReturn = Response.status(Status.INTERNAL_SERVER_ERROR).entity(exception).build();
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
