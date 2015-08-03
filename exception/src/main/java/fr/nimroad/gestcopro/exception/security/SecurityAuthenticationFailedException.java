package fr.nimroad.gestcopro.exception.security;

import fr.nimroad.gestcopro.exception.DictionnaryException;
import fr.nimroad.gestcopro.exception.GestCoproException;

public class SecurityAuthenticationFailedException extends GestCoproException {

	private static final long serialVersionUID = 1L;

	public SecurityAuthenticationFailedException() {
		this.setCodeRetour(DictionnaryException.AUTHENTICATIONFAILED.getCodeRetour());
		this.setMessage(DictionnaryException.AUTHENTICATIONFAILED.getMessage());
	}
}
