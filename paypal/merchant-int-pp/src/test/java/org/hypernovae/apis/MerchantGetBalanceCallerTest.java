package org.hypernovae.apis;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import urn.ebay.api.PayPalAPI.GetBalanceResponseType;

public class MerchantGetBalanceCallerTest {
	@Test
	public void getBalanceTest() {
		MerchantGetBalanceCaller caller = new MerchantGetBalanceCaller();
		GetBalanceResponseType callResponse = caller.getTheBalance();
		assertNotNull(callResponse);
	}

}
