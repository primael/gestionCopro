package fr.nimroad.gestcopro.exception.security;

import fr.nimroad.gestcopro.exception.DictionnaryException;
import fr.nimroad.gestcopro.exception.GestCoproException;

public class SecurityActionTokenAllreadyUsedException extends
		GestCoproException {

	private static final long serialVersionUID = 1L;

    public SecurityActionTokenAllreadyUsedException() {
        this.setCodeRetour(DictionnaryException.ACTIVATIONTOKENALLREADYUSED.getCodeRetour());
        this.setMessage(DictionnaryException.ACTIVATIONTOKENALLREADYUSED.getMessage());
    }
}
