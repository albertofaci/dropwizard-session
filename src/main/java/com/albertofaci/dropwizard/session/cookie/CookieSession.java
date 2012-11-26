package com.albertofaci.dropwizard.session.cookie;

public interface CookieSession {

	String getId();
	
	String getUsername();
	
	String getToken();
	
}
