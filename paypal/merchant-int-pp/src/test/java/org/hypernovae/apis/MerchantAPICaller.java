package org.hypernovae.apis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

import urn.ebay.api.PayPalAPI.*;

public class MerchantAPICaller {
	
	/**
	 * This code is only illustrative of the approach to dealing with the merchant Sdk
	 * Notice that the merchant sdk is no more actively supported by its editor and
	 * will be deprecated in the future
	 * @see https://github.com/paypal/merchant-sdk-java
	 * @param args
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws OAuthException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws SSLConfigurationException, InvalidCredentialException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, OAuthException, IOException, InterruptedException, ParserConfigurationException, SAXException {
		TransactionSearchReq tnxReq = new TransactionSearchReq();
		TransactionSearchRequestType requestType = new TransactionSearchRequestType();
		requestType.setStartDate("2016-04-03T00:00:00.000Z");
		requestType.setStartDate("2016-04-04T00:00:00.000Z");
		
		requestType.setVersion("95.0");
		requestType.setTransactionID("TX-ID");
		tnxReq.setTransactionSearchRequest(requestType);
		
		//PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService();
		
		Map<String, String> customConfigurationMap = new HashMap<String, String>();
		customConfigurationMap.put("mode", "sandbox");
		
		PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(customConfigurationMap);
		TransactionSearchResponseType txnResponse = service.transactionSearch(tnxReq,"USERNAME");
	}
}
