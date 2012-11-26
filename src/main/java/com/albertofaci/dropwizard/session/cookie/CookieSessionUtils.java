package com.albertofaci.dropwizard.session.cookie;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.lang.StringUtils;


public class CookieSessionUtils {
	
	public static ResponseBuilder attachSession(ResponseBuilder responseBuilder, CookieSession session) {
		return responseBuilder
				.cookie(createCookie(CookieConstants.TOKEN_COOKIE_NAME, session.getToken()))
				.cookie(createCookie(CookieConstants.USER_COOKIE_NAME, session.getUsername()))
				.cookie(createCookie(CookieConstants.SESSION_COOKIE_NAME, session.getId()));
	}
	
	public static ResponseBuilder removeSession(ResponseBuilder responseBuilder) {
		return responseBuilder
				.cookie(clearCookie(CookieConstants.TOKEN_COOKIE_NAME))
				.cookie(clearCookie(CookieConstants.USER_COOKIE_NAME))
				.cookie(clearCookie(CookieConstants.SESSION_COOKIE_NAME));
	}
	
	private static NewCookie createCookie(String name, String value){
		return new NewCookie(new Cookie(name, value), "", 86400, false);
	}
	
	private static NewCookie clearCookie(String name){
		return new NewCookie(name, StringUtils.EMPTY);
	}

}
