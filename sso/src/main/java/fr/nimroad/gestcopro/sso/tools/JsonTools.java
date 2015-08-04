package fr.nimroad.gestcopro.sso.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.nimroad.gestcopro.exception.technical.TechnicalException;

public enum JsonTools {

	INSTANCE;
	
	public String objectToJson(Object dto) throws TechnicalException{
		
		String toReturn = "";
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			toReturn = mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			throw new TechnicalException(e);
		}
		
		return toReturn;		
	}
}
