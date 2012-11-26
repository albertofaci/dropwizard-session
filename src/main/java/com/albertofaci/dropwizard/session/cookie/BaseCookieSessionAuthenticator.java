package com.albertofaci.dropwizard.session.cookie;


import com.google.common.base.Optional;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;

public abstract class BaseCookieSessionAuthenticator<U, S> implements Authenticator<CookieCredentials, S> {

	public Optional<S> authenticate(CookieCredentials credentials) throws AuthenticationException {
		U user = findUserByCredentials(credentials);
		S session = createSessionFromCredentialsAndUser(credentials, user);
		if(user != null){
			if(isValidCredential(credentials, user)) {
				return  Optional.of(session);
			}	
		}
        return Optional.absent();
	}
	
	protected abstract U findUserByCredentials(CookieCredentials credentials);
	
	protected abstract S createSessionFromCredentialsAndUser(CookieCredentials credentials, U user);
	
	protected abstract boolean isValidCredential(CookieCredentials credentials, U user);
	
}
