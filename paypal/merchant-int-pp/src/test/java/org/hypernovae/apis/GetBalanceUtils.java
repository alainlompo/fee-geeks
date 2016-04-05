package org.hypernovae.apis;

import urn.ebay.api.PayPalAPI.GetBalanceRequestType;

public class GetBalanceUtils {
	private GetBalanceUtils() {}
	public static void setBalanceCurrencyReturnMode(GetBalanceRequestType getBalanceRequestType, GetBalanceCurrencyReturnMode currencyReturnMode) {
		getBalanceRequestType.setReturnAllCurrencies(currencyReturnMode.getCode());
	}
}
