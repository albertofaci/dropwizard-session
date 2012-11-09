package com.albertofaci.dwsession;


import org.apache.commons.lang.StringUtils;

import com.google.common.base.Optional;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;


public abstract class BaseCookieAuthenticator implements Authenticator<CookieCredentials, CookieSession> {

		public Optional<CookieSession> authenticate(CookieCredentials credentials) throws AuthenticationException {
			User user = findUser(credentials);
			if(user != null){
				if(StringUtils.equals(credentials.getHashedCredential(), user.getHashedCredential())) {
					return  Optional.of(buildCookieSession(credentials, user));
				}	
			}
	        return Optional.absent();
		}
		
		protected abstract User findUser(CookieCredentials credentials);
		
		protected abstract CookieSession buildCookieSession(CookieCredentials cookieCredentials, User user);
		

}
