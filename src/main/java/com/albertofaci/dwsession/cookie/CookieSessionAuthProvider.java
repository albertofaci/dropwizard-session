package com.albertofaci.dwsession.cookie;

import com.sun.jersey.api.model.Parameter;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;
import com.yammer.dropwizard.auth.Auth;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.logging.Log;

public class CookieSessionAuthProvider<S> implements InjectableProvider<Auth, Parameter> {
	
	static final Log LOG = Log.forClass(CookieSessionAuthProvider.class);

	private final Authenticator<CookieCredentials, S> authenticator;

	public CookieSessionAuthProvider(Authenticator<CookieCredentials, S> authenticator) {
		if(authenticator == null){
			throw new IllegalArgumentException("authenticator must not be null");
		}
		this.authenticator = authenticator;
	}

	public ComponentScope getScope() {
		return ComponentScope.PerRequest;
	}

	public Injectable<?> getInjectable(ComponentContext ic, Auth a, Parameter c) {
		return new CookieSessionAuthInjectable<S>(authenticator, a.required());
	}

}

