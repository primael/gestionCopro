package fr.nimroad.gestcopro.exception.technical;

import fr.nimroad.gestcopro.exception.DictionnaryException;
import fr.nimroad.gestcopro.exception.GestCoproException;

public class TechnicalException extends GestCoproException {

	private static final long serialVersionUID = 1L;

	public TechnicalException() {
		this.setCodeRetour(DictionnaryException.TECHNICAL.getCodeRetour());
		this.setMessage(DictionnaryException.TECHNICAL.getMessage());
	}
	
	public TechnicalException(Exception exception) {
		this.setCodeRetour(DictionnaryException.TECHNICAL.getCodeRetour());
		this.setMessage(DictionnaryException.TECHNICAL.getMessage());
		this.setStackTrace(exception.getStackTrace());
	}
}
