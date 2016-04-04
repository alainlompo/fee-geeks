package org.hypernovae.apis;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hypernovae.apis.utils.AuthorizationUtils;

import com.paypal.api.payments.*;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalResource;

public class RESTAPICaller {
	
	public static void main(String[] args) throws PayPalRESTException {
		/*File configFile = new File("./src/test/resources/sdk_config.properties");
		OAuthTokenCredential tokenCredential = Payment.initConfig(configFile); 
		String accessToken = tokenCredential.getAccessToken();
		APIContext apiContext = new APIContext(accessToken);*/
		
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");

		String accessToken = "Bearer A101.TL6QdgR836CVasssrZOE7ri1woGPW2SKjdnhGFE7uEaRnG4emCZ_Ig-2dH6qjCjXRB.lejyNTSThBFRs30mxSVACvuOsmm";
		APIContext apiContext = new APIContext(accessToken);
		apiContext.setConfigurationMap(sdkConfig);

		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("12");

		Transaction transaction = new Transaction();
		transaction.setDescription("creating a payment");
		transaction.setAmount(amount);

		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("https://devtools-paypal.com/guide/pay_paypal?cancel=true");
		redirectUrls.setReturnUrl("https://devtools-paypal.com/guide/pay_paypal?success=true");
		payment.setRedirectUrls(redirectUrls);

		Payment createdPayment = payment.create(apiContext);
		System.out.println(createdPayment.toJSON());
		
		/** -------------------------------------------------------------------------------
		 * The REST API Authorization
		 * --------------------------------------------------------------------------------
		 */
		/*Authorization aut = AuthorizationUtils.getAuthorization(apiContext);
		System.out.println("create time             = "+ aut.getCreateTime());
		System.out.println("ID                      = " + aut.getId());
		System.out.println("parent payment          =" + aut.getParentPayment());
		System.out.println("Payment mode            =" + aut.getPaymentMode());
		System.out.println("Pending reason          =" + aut.getPendingReason());
		System.out.println("State                   =" + aut.getState());
		System.out.println("Valid until             =" + aut.getValidUntil());
		System.out.println("client id               =" + PayPalResource.getClientID() );
		System.out.println("client secret           =" + PayPalResource.getClientSecret());
		System.out.println("last request            =" + PayPalResource.getLastRequest());
		System.out.println("last response           =" + PayPalResource.getLastResponse());
		System.out.println("-------------------------------------------------------------");
		System.out.println("Json version....");
		System.out.println("-------------------------------------------------------------");
		System.out.println(aut.toJSON());*/	
				
	}
	

}
