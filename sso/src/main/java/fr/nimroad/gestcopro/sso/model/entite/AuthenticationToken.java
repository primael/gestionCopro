package fr.nimroad.gestcopro.sso.model.entite;

import lombok.NoArgsConstructor;

/**
 * Un jeton d'authentification est caracterise par: - un identifiant - un timestamp de creation - un utilisateur a
 * l'origine de la demande
 * 
 * @author pbruant
 *
 */
@NoArgsConstructor
public class AuthenticationToken extends Token {

    public AuthenticationToken(Utilisateur utilisateur) {
        super(utilisateur);
    }

}