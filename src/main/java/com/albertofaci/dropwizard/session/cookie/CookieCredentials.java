package com.albertofaci.dropwizard.session.cookie;

public class CookieCredentials {

	private String username;
	private String token;
	private String sessionId;
	
	public CookieCredentials(String username, String token, String sessionId) {
		this.username = username;
		this.token = token;
		this.sessionId = sessionId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
