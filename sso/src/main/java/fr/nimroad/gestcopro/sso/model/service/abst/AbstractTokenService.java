package fr.nimroad.gestcopro.sso.model.service.abst;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import fr.nimroad.gestcopro.exception.GestCoproException;
import fr.nimroad.gestcopro.exception.security.SecurityActionTokenAllreadyUsedException;
import fr.nimroad.gestcopro.exception.security.SecurityActivationTokenExpiredException;
import fr.nimroad.gestcopro.exception.security.SecurityActivationTokenNotExistException;
import fr.nimroad.gestcopro.sso.model.entite.Token;
import fr.nimroad.gestcopro.sso.model.service.TokenService;
import fr.nimroad.gestcopro.sso.tools.TimeTools;

public abstract class AbstractTokenService<T extends Token> implements TokenService<T> {

	/**
     * Un token est valide si: <br/>
     * <ul>
     * <li>il a �t� pr�cedemmment cr�er.</li>
     * <li>il n'a pas d�j� �t� utilis�.</li>
     * <li>il n'a pas d�pass� le temps imparti.</li>
     * <li>l'utilisateur est en compte inactif.</li>
     * </ul>
     * @throws GedException 
     */
    @Override
    public void validateToken(String token) throws GestCoproException {
        
        Token activationToken = getDao().findTokenByToken(token);
        
        //V�rification de l'existence du token
        if(activationToken==null){
            throw new SecurityActivationTokenNotExistException();
        }
        
        //V�rification du d�lai du token
        if(!TimeTools.INSTANCE.validateExpirationTime(activationToken.getTimeStamp(), getDuration())){
          throw new SecurityActivationTokenExpiredException();
        }
        
        //Validation de l'activation du jeton
        if(!activationToken.isValid()) {
            throw new SecurityActionTokenAllreadyUsedException();
        }
    }

    protected Duration getDuration() {
        return Duration.of(1, ChronoUnit.DAYS);
    }

}
