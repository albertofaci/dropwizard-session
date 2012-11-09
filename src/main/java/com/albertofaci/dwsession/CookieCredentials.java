package com.albertofaci.dwsession;

public class CookieCredentials {

	private String username;
	private String hashedCredential;
	private String sessionId;
	
	public CookieCredentials(String username, String hashedCredential, String sessionId) {
		this.username = username;
		this.hashedCredential = hashedCredential;
		this.sessionId = sessionId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHashedCredential() {
		return hashedCredential;
	}
	public void setHashedCredential(String hashedCredential) {
		this.hashedCredential = hashedCredential;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
