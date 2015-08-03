package fr.nimroad.gestcopro.sso.model.service.implementation;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import fr.nimroad.gestcopro.exception.GestCoproException;
import fr.nimroad.gestcopro.exception.security.SecurityActionTokenAllreadyUsedException;
import fr.nimroad.gestcopro.exception.security.SecurityActivationTokenExpiredException;
import fr.nimroad.gestcopro.exception.security.SecurityActivationTokenNotExistException;
import fr.nimroad.gestcopro.sso.model.dao.TokenDataAccess;
import fr.nimroad.gestcopro.sso.model.entite.ActivationToken;
import fr.nimroad.gestcopro.sso.model.entite.Token;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.entite.token.TypeToken;
import fr.nimroad.gestcopro.sso.model.service.abst.AbstractTokenService;
import fr.nimroad.gestcopro.sso.tools.TimeTools;

public class ActivationTokenServiceImplementation extends AbstractTokenService<ActivationToken> {
    
    @Override
    public ActivationToken createToken(Utilisateur utilisateur) throws GestCoproException {
        ActivationToken activationToken = new ActivationToken(utilisateur);
        getDao().save(activationToken);
        return activationToken;
    }

    @Override
    public void validateToken(String token) throws GestCoproException {
        Token activationToken = getDao().findTokenByToken(token);
        
        //Vérification de l'existence du token
        if(activationToken==null){
            throw new SecurityActivationTokenNotExistException();
        }
        
        //Vérification du délai du token
        if(!TimeTools.INSTANCE.validateExpirationTime(activationToken.getTimeStamp(), Duration.of(1, ChronoUnit.DAYS))){
          throw new SecurityActivationTokenExpiredException();
        }
        
        //Vérification de la validité du token (pas déjà utilisé)
        if(!activationToken.isValid()){
            throw new SecurityActionTokenAllreadyUsedException();
        }
        
        //Activation de l'utilisateur
        /*try {
            Utilisateur utilisateur = userService.getUtilisateur(activationToken.getUtilisateur().getIdentifiant());
            utilisateur.getStatut().activerCompte();
            utilisateur.setActif(true);
            
            userDao.updateEntity(utilisateur);
            
            activationToken.setValid(false);
            
            getDao().updateEntity((ActivationToken) activationToken);
            
        } catch(IllegalStateException exception) {
            throw new SecurityActionNotAllowedException();
        }*/
    }

    @SuppressWarnings("unchecked")
    @Override
    public TokenDataAccess<ActivationToken> getDao() {
        return (TokenDataAccess<ActivationToken>) TokenDataAccess.getDataAccess(TypeToken.ACTIVATIONTOKEN);
    }
}
