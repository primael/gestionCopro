package fr.nimroad.gestcopro.exception;

import lombok.Getter;
import lombok.Setter;

public abstract class GestCoproException extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int codeRetour;
	
	@Getter
	@Setter
	private String message;

}
