package fr.nimroad.gestcopro.utils.net;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public enum RequestHeaderHelper {

	INSTANCE;
	
	@SneakyThrows
	public String getReferer(final HttpServletRequest request) {
		String refererUrl = request.getHeader("referer");
		
		final String refererUrlTemp = request.getHeader("referer");
		if(refererUrl != null && !refererUrl.isEmpty()){
			final String refererURI = new URI(request.getHeader("referer")).getPath();
			if(refererURI != null && !refererURI.isEmpty()){
				refererUrl = refererUrlTemp.substring(0, refererUrlTemp.length() - refererURI.length());
			}
		}
		log.debug("Requête d'appel depuis {}", refererUrl);
		
		return refererUrl;
	}
}