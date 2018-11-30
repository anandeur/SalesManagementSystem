package com.sms.main;

public enum Category {
	food("food"), beverage("beverage");
	private String value;

	private Category(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
