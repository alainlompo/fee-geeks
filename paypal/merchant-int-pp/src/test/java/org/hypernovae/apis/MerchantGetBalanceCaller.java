package org.hypernovae.apis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import urn.ebay.api.PayPalAPI.*;
import urn.ebay.apis.CoreComponentTypes.*;

public class MerchantGetBalanceCaller {

	public final Logger LOGGER = LoggerFactory.getLogger(MerchantGetBalanceCaller.class);
	public GetBalanceResponseType getTheBalance() {
		
		GetBalanceReq getBalanceReq = new GetBalanceReq();
		GetBalanceRequestType getBalanceRequestType = new GetBalanceRequestType();
		GetBalanceUtils.setBalanceCurrencyReturnMode(getBalanceRequestType, GetBalanceCurrencyReturnMode.ALL);
		getBalanceReq.setGetBalanceRequest(getBalanceRequestType);
		
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		sdkConfig.put("acct1.UserName", "YOUR_USERNAME_HERE");
		sdkConfig.put("acct1.Password", "YOUR_PASSWORD_HERE");
		sdkConfig.put("acct1.Signature","YOUR_SIGNATURE_HERE");
		sdkConfig.put("acct1.AppId","APP-80W284485P519543T");
		
		PayPalAPIInterfaceServiceService service = null;
		try {
			service = new PayPalAPIInterfaceServiceService(sdkConfig);
		} catch (Exception ex) {
			LOGGER.error("An error occured ... " + ex.getMessage());
		}
		
		GetBalanceResponseType getBalanceResponseType = null;
		try {
			getBalanceResponseType = service.getBalance(getBalanceReq);
		} catch (Exception ex) {
			LOGGER.error("An exception occured while accessing the getbalance service..." + ex.getMessage());						
		}
		if ("SUCCESS".equalsIgnoreCase(getBalanceResponseType.getAck().getValue())) {
			Iterator<BasicAmountType> iterator = getBalanceResponseType.getBalanceHoldings().iterator();
			System.out.println("Printing all balances informations....");
			while (iterator.hasNext()) {
				BasicAmountType amount = iterator.next();
				System.out.println("found " + amount.getValue() + " - " + amount.getCurrencyID());
			}
			
		} else {
			System.out.println("The operation was not successful.....");
		}
		return getBalanceResponseType;
		
	}
}
