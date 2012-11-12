package com.albertofaci.dwsession.cookie;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.google.common.base.Optional;
import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.server.impl.inject.AbstractHttpContextInjectable;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;

public class CookieSessionAuthInjectable<S> extends AbstractHttpContextInjectable<S> {
	
	private final Authenticator<CookieCredentials, S> authenticator;
	private final boolean required;
	
	public CookieSessionAuthInjectable(Authenticator<CookieCredentials, S> authenticator, boolean required) {
		this.authenticator = authenticator;
		this.required = required;
	}

	@Override
	public S getValue(HttpContext c) {
		MultivaluedMap<String, String> allCookies = c.getRequest().getCookieNameValueMap();
		String hashedLogin = allCookies.getFirst(CookieConstants.LOGIN_COOKIE_NAME);
		String username = allCookies.getFirst(CookieConstants.USER_COOKIE_NAME);
		String sessionId = allCookies.getFirst(CookieConstants.SESSION_COOKIE_NAME);
		CookieCredentials cookieCredentials = new CookieCredentials(username, hashedLogin, sessionId);
		Optional<S> t;
		try {
			t = authenticator.authenticate(cookieCredentials);
			 if (t.isPresent()) {
	             return t.get();
	         }
		} catch (AuthenticationException e) {
			if(required) {
			   throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED)
                       .entity("Credentials are required to access this resource.")
                       .type(MediaType.TEXT_PLAIN_TYPE)
                       .build());
			}
		}
		 return null;
		 
	}
	

}
