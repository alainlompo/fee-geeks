package org.hypernovae.apis;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.paypal.base.rest.PayPalRESTException;

public class RESTAPICallerTest {
	
	@Test
	public void testRESTAPICall() throws PayPalRESTException {
		RESTAPICaller.main(null);
		assertTrue(true);
	}

}
