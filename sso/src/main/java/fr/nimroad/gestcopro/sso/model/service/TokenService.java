package fr.nimroad.gestcopro.sso.model.service;

import fr.nimroad.gestcopro.exception.GestCoproException;
import fr.nimroad.gestcopro.sso.model.dao.TokenDataAccess;
import fr.nimroad.gestcopro.sso.model.entite.Token;
import fr.nimroad.gestcopro.sso.model.entite.Utilisateur;
import fr.nimroad.gestcopro.sso.model.entite.token.TypeToken;

/**
 * Service permettant la gestion des token d'activation
 * @author Primael Bruant
 *
 */
public interface TokenService<T extends Token> {

    TokenDataAccess<T> getDao();
    
    /**
     * M�thode permettant de valider un jeton d'activation
     * @param token Le jeton d'activation � valider
     * @throws GestCoproException Erreur lev�e lorsqu'un �tat incompatible est trouv�.
     */
    void validateToken(String token) throws GestCoproException;

    /**
     * M�thode permettant la cr�ation d'un jeton d'activation
     * @param utilisateur
     * @return
     * @throws GestCoproException 
     */
    T createToken(Utilisateur utilisateur) throws GestCoproException;

    static TokenService<? extends Token> getService(TypeToken typeToken) {
        return typeToken.getService();
    }

}