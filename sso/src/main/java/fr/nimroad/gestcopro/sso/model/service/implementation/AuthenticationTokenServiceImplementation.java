package fr.nimroad.gestcopro.sso.model.service.implementation;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import fr.nimroad.gestcopro.exception.GestCoproException;
import fr.nimroad.gestcopro.sso.model.dao.TokenDataAccess;
import fr.nimroad.gestcopro.sso.model.entite.AuthenticationToken;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.entite.token.TypeToken;
import fr.nimroad.gestcopro.sso.model.service.abst.AbstractTokenService;

public class AuthenticationTokenServiceImplementation extends AbstractTokenService<AuthenticationToken> {

	 @SuppressWarnings("unchecked")
	    @Override
	    public TokenDataAccess<AuthenticationToken> getDao() {
	        return (TokenDataAccess<AuthenticationToken>) TokenDataAccess.getDataAccess(TypeToken.AUTHENTIFICATIONTOKEN);
	    }

	    @Override
	    public AuthenticationToken createToken(Utilisateur utilisateur) throws GestCoproException {
	        final AuthenticationToken token = new AuthenticationToken(utilisateur);

//	        MessageBuilder builder = new SecurityMessageBuilder();
//	        builder.with(SecurityOperations.TOKEN, token.getToken()) //
//	                .with(SecurityOperations.SECURITY_EVENT, SecurityEvent.TOKEN_CREATION) //
//	                .with(SecurityOperations.LOGIN, utilisateur.getLogin());

//	        System.out.println(builder.getMessage());

	        // On invalide les précédents
	        this.getDao().invalidatePreviousTokens(utilisateur);
	        // On persiste le nouveau token
	        this.getDao().save(token);

	        return token;
	    }

	    @Override
	    protected Duration getDuration() {
	        return Duration.of(5, ChronoUnit.MINUTES);
	    }
}
