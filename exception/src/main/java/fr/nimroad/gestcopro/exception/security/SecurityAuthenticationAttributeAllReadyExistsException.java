package fr.nimroad.gestcopro.exception.security;

import fr.nimroad.gestcopro.exception.DictionnaryException;
import fr.nimroad.gestcopro.exception.GestCoproException;

public class SecurityAuthenticationAttributeAllReadyExistsException extends
		GestCoproException {

	private static final long serialVersionUID = 1L;

    public SecurityAuthenticationAttributeAllReadyExistsException(String attribute) {
        this.setCodeRetour(DictionnaryException.AUTHENTICATIONATTRIBUTEALLREADYEXISTS.getCodeRetour());
        this.setMessage(DictionnaryException.AUTHENTICATIONATTRIBUTEALLREADYEXISTS.getMessage().replaceAll("%attribute%", attribute));
    }
}
