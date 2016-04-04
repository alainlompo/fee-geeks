package org.hypernovae.apis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;
import com.paypal.svcs.services.AdaptivePaymentsService;
import com.paypal.svcs.types.ap.PreapprovalRequest;
import com.paypal.svcs.types.ap.PreapprovalResponse;
import com.paypal.svcs.types.common.RequestEnvelope;

public class AdaptivePreApprovalCaller {
	public static void main(String[] args) throws SSLConfigurationException, InvalidCredentialException, UnsupportedEncodingException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, OAuthException, IOException, InterruptedException {
		RequestEnvelope requestEnvelope = new RequestEnvelope("en_US");
		PreapprovalRequest preapprovalRequest = new PreapprovalRequest();
		preapprovalRequest.setRequestEnvelope(requestEnvelope);

		preapprovalRequest.setCurrencyCode("USD");
		preapprovalRequest.setStartingDate("2016-04-04");
		preapprovalRequest.setEndingDate("2017-04-04");

		preapprovalRequest.setMaxAmountPerPayment(1.0);
		preapprovalRequest.setMaxNumberOfPayments(5);
		preapprovalRequest.setMaxTotalAmountOfAllPayments(5.0);

//		preapprovalRequest.setSenderEmail("platfo_1255077030_biz@gmail.com");
		preapprovalRequest.setSenderEmail("alainlompo-facilitator@zoho.com");
		preapprovalRequest.setCancelUrl("https://devtools-paypal.com/guide/ap_preapprove_payment?cancel=true");
		preapprovalRequest.setReturnUrl("https://devtools-paypal.com/guide/ap_preapprove_payment?success=true");
		preapprovalRequest.setIpnNotificationUrl("http://replaceIpnUrl.com");

//		Map<String, String> sdkConfig = new HashMap<String, String>();
//		sdkConfig.put("mode", "sandbox");
//		sdkConfig.put("acct1.UserName", "jb-us-seller_api1.paypal.com");
//		sdkConfig.put("acct1.Password", "WX4WTU3S8MY44S7F");
//		sdkConfig.put("acct1.Signature","AFcWxV21C7fd0v3bYYYRCpSSRl31A7yDhhsPUU2XhtMoZXsWHFxu-RWy");
//		sdkConfig.put("acct1.AppId","APP-80W284485P519543T");
		
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		sdkConfig.put("acct1.UserName", "your_user_name_here");
		sdkConfig.put("acct1.Password", "your_password_here");
		sdkConfig.put("acct1.Signature","your_signature_here");
		sdkConfig.put("acct1.AppId","APP-80W284485P519543T");

		AdaptivePaymentsService adaptivePaymentsService = new AdaptivePaymentsService(sdkConfig);
		PreapprovalResponse preapprovalResponse = adaptivePaymentsService.preapproval(preapprovalRequest);
		
		System.out.println("ACK             :" + preapprovalResponse.getResponseEnvelope().getAck());
		System.out.println("Correlation ID  :" + preapprovalResponse.getResponseEnvelope().getCorrelationId());
		System.out.println("Paykey          :" + preapprovalResponse.getPreapprovalKey());
		
	}

}
