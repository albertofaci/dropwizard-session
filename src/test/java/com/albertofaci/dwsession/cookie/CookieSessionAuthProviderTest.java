package com.albertofaci.dwsession.cookie;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.sun.jersey.core.spi.component.ComponentScope;
import com.yammer.dropwizard.auth.Authenticator;

public class CookieSessionAuthProviderTest {
	
	private CookieSessionAuthProvider<TestSession> provider;
	
	private @Mock Authenticator<CookieCredentials, TestSession> mockAuthenticator;
	
	
	@Before
	public void setup() {
		provider = new CookieSessionAuthProvider<TestSession>(mockAuthenticator);
	}
	
	@Test
	public void failsCreateProvicerWithNullAuthenticator() {
		new CookieSessionAuthProvider<TestSession>(null);
	}
	
	@Test
	public void scopeIsPerRequest() {
		assertThat(provider.getScope(), equalTo(ComponentScope.PerRequest));
	}
	
	private interface TestSession {
		
	}
	

}
