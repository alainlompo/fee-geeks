package org.hypernovae.apis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.services.AdaptivePaymentsService;
import com.paypal.svcs.types.ap.PayRequest;
import com.paypal.svcs.types.ap.PayResponse;
import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.common.RequestEnvelope;

public class AdaptiveAPICaller {
	public static void main(String[] args) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, OAuthException, IOException, InterruptedException {
		PayRequest payRequest = new PayRequest();
		  
		List<Receiver> receivers = new ArrayList<Receiver>();
		Receiver receiver = new Receiver();
		receiver.setAmount(1.00);
		receiver.setEmail("alain.lompo-facilitator@zoho.com");
		receivers.add(receiver);
		ReceiverList receiverList = new ReceiverList(receivers);

		payRequest.setReceiverList(receiverList);

		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		payRequest.setRequestEnvelope(requestEnvelope); 
		payRequest.setActionType("PAY");
		payRequest.setCancelUrl("https://devtools-paypal.com/guide/ap_simple_payment?cancel=true");
		payRequest.setReturnUrl("https://devtools-paypal.com/guide/ap_simple_payment?success=true");
		payRequest.setCurrencyCode("USD");
		payRequest.setIpnNotificationUrl("http://replaceIpnUrl.com");

		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		sdkConfig.put("acct1.UserName", "your_username");
		sdkConfig.put("acct1.Password", "your_pass");
		sdkConfig.put("acct1.Signature","your_signature");
		sdkConfig.put("acct1.AppId","APP-80W284485P519543T");

		AdaptivePaymentsService adaptivePaymentsService = new AdaptivePaymentsService(sdkConfig);
		PayResponse payResponse = adaptivePaymentsService.pay(payRequest);
		System.out.println("ACK             :" + payResponse.getResponseEnvelope().getAck());
		System.out.println("Correlation ID  :" + payResponse.getResponseEnvelope().getCorrelationId());
		System.out.println("Paykey          :" + payResponse.getPayKey());
	}

}
