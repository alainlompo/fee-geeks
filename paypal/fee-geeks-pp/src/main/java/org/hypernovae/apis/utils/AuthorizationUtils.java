package org.hypernovae.apis.utils;

import java.util.ArrayList;
import java.util.List;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;
public class AuthorizationUtils {
	
	private AuthorizationUtils() {
		
	}
	
	public static  Authorization getAuthorization(APIContext apiContext)
			throws PayPalRESTException {

		// ###Details
		// Let's you specify details of a payment amount.
		Details details = new Details();
		details.setShipping("0.02");
		details.setSubtotal("111.41");
		details.setTax("0.02");

		// ###Amount
		// Let's you specify a payment amount.
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal("111.47");
		amount.setDetails(details);

		// ###Transaction
		// A transaction defines the contract of a
		// payment - what is the payment for and who
		// is fulfilling it. Transaction is created with
		// a `Payee` and `Amount` types
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction
				.setDescription("This is the payment transaction description.");
		
		// The Payment creation API requires a list of
		// Transaction; add the created `Transaction`
		// to a List
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// ###Address
		// Base Address object used as shipping or billing
		// address in a payment. [Optional]
		Address billingAddress = new Address();
		billingAddress.setCity("Alberttown");
		billingAddress.setCountryCode("US");
		billingAddress.setLine1("53 North West View");
		billingAddress.setPostalCode("46210");
		billingAddress.setState("OH");

		// ###CreditCard
		// A resource representing a credit card that can be
		// used to fund a payment.
		CreditCard creditCard = new CreditCard();
		creditCard.setBillingAddress(billingAddress);
		creditCard.setCvv2(874);
		creditCard.setExpireMonth(12);
		creditCard.setExpireYear(2019);
		creditCard.setFirstName("Joe Dalton");
		creditCard.setLastName("Shopper");
		creditCard.setNumber("44171199347920331");
		creditCard.setType("visa");
		
		// ###FundingInstrument
		// A resource representing a Payeer's funding instrument.
		// Use a Payer ID (A unique identifier of the payer generated
		// and provided by the facilitator. This is required when
		// creating or using a tokenized funding instrument)
		// and the `CreditCardDetails`
		FundingInstrument fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(creditCard);
		
		// The Payment creation API requires a list of
		// FundingInstrument; add the created `FundingInstrument`
		// to a List
		List<FundingInstrument> fundingInstruments = new ArrayList<FundingInstrument>();
		fundingInstruments.add(fundingInstrument);
		
		// ###Payer
		// A resource representing a Payer that funds a payment
		// Use the List of `FundingInstrument` and the Payment Method
		// as 'credit_card'
		Payer payer = new Payer();
		payer.setFundingInstruments(fundingInstruments);
		payer.setPaymentMethod("credit_card");

		// ###Payment
		// A Payment Resource; create one using
		// the above types and intent as 'authorize'
		Payment payment = new Payment();
		payment.setIntent("authorize");
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		Payment responsePayment = payment.create(apiContext);
		return responsePayment.getTransactions().get(0)
				.getRelatedResources().get(0).getAuthorization();
	}

}
