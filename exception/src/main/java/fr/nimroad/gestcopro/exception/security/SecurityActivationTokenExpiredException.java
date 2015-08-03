package fr.nimroad.gestcopro.exception.security;

import fr.nimroad.gestcopro.exception.DictionnaryException;
import fr.nimroad.gestcopro.exception.GestCoproException;

public class SecurityActivationTokenExpiredException extends GestCoproException {

	private static final long serialVersionUID = 1L;

    public SecurityActivationTokenExpiredException() {
        this.setCodeRetour(DictionnaryException.ACTIVATIONTOKENEXPIRED.getCodeRetour());
        this.setMessage(DictionnaryException.ACTIVATIONTOKENEXPIRED.getMessage());
    }
}
