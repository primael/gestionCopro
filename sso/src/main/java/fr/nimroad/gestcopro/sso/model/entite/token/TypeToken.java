package fr.nimroad.gestcopro.sso.model.entite.token;

import lombok.Getter;
import fr.nimroad.gestcopro.sso.model.dao.TokenDataAccess;
import fr.nimroad.gestcopro.sso.model.dao.implementation.AuthenticationDataAccessImplementation;
import fr.nimroad.gestcopro.sso.model.dao.implementation.TokenDataAccessImplementation;
import fr.nimroad.gestcopro.sso.model.entite.ActivationToken;
import fr.nimroad.gestcopro.sso.model.entite.Token;
import fr.nimroad.gestcopro.sso.model.service.TokenService;
import fr.nimroad.gestcopro.sso.model.service.implementation.ActivationTokenServiceImplementation;
import fr.nimroad.gestcopro.sso.model.service.implementation.AuthenticationTokenServiceImplementation;

@Getter
public enum TypeToken {

	ACTIVATIONTOKEN(new ActivationTokenServiceImplementation(), new TokenDataAccessImplementation<ActivationToken>(){}), //
    
    AUTHENTIFICATIONTOKEN(new AuthenticationTokenServiceImplementation(), AuthenticationDataAccessImplementation.INSTANCE), //
    ;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private TypeToken(TokenService service, TokenDataAccess dao){
        this.service = service;
        this.dao = dao;
    }
    
    private final TokenService<? extends TokenDataAccess<? extends Token>> service;
    
    private final TokenDataAccess<? extends TokenDataAccess<? extends Token>> dao;
}
