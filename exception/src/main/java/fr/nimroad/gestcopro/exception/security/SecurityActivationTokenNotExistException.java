package fr.nimroad.gestcopro.exception.security;

import fr.nimroad.gestcopro.exception.DictionnaryException;
import fr.nimroad.gestcopro.exception.GestCoproException;

public class SecurityActivationTokenNotExistException extends GestCoproException {

	private static final long serialVersionUID = 1L;

	public SecurityActivationTokenNotExistException() {
		this.setCodeRetour(DictionnaryException.ACTIVATIONTOKENNOTEXIST.getCodeRetour());
		this.setMessage(DictionnaryException.ACTIVATIONTOKENNOTEXIST.getMessage());
	}

}
