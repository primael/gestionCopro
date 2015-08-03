package fr.nimroad.gestcopro.exception.security;

import fr.nimroad.gestcopro.exception.DictionnaryException;
import fr.nimroad.gestcopro.exception.GestCoproException;

public class SecurityActionNotAllowedException extends GestCoproException {

	private static final long serialVersionUID = 1L;

	public SecurityActionNotAllowedException() {
		this.setCodeRetour(DictionnaryException.ACTIONNOTALLOWED.getCodeRetour());
		this.setMessage(DictionnaryException.ACTIONNOTALLOWED.getMessage());
	}
}
