package com.sms.main;

public enum Command {
	addStore("addStore"), addItem("addItem"), addStock("addStock"), updateStock("updateStock"), sale("sale");
	private String value;

	private Command(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
