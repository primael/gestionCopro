package fr.nimroad.gestcopro.utils.ws;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import fr.nimroad.gestcopro.utils.net.RequestHeaderHelper;

public enum ResponseHelper {

	INSTANCE;

	public Response getResponseWithReferer(GenericEntity<?> entity, HttpServletRequest httpRequest) {
		
		String referer = RequestHeaderHelper.INSTANCE.getReferer(httpRequest);

		return Response.ok(entity) //
				.header("Access-Control-Allow-Origin", referer)
				.header("Access-Control-Allow-Credentials", "true").build();
	}
}
