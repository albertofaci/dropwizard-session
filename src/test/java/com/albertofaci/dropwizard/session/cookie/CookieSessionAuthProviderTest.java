package com.albertofaci.dropwizard.session.cookie;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.albertofaci.dropwizard.session.cookie.CookieCredentials;
import com.albertofaci.dropwizard.session.cookie.CookieSessionAuthProvider;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.yammer.dropwizard.auth.Authenticator;

@RunWith(MockitoJUnitRunner.class)
public class CookieSessionAuthProviderTest {
	
	private CookieSessionAuthProvider<TestSession> provider;
	
	private @Mock Authenticator<CookieCredentials, TestSession> mockAuthenticator;
	
	
	@Before
	public void setup() {
		provider = new CookieSessionAuthProvider<TestSession>(mockAuthenticator);
	}
	
	@Test(expected=IllegalArgumentException.class)
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
