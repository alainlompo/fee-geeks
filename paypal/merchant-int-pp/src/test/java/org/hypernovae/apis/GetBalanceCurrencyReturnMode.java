package org.hypernovae.apis;

public enum GetBalanceCurrencyReturnMode {

	PRIMARY("0", "Return the balance for the primary currency holding alone"),
	ALL("1", "Return the balance for each currency holding");
	
	private final String code;
	private final String description;
	
	private GetBalanceCurrencyReturnMode(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}