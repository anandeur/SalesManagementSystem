package com.sms.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Stock {
	private Map<String, Integer> stock = new HashMap<String, Integer>();
	private Calendar updatedTime;

	public Stock() {
		this.updatedTime = new GregorianCalendar();
	}

	public Map<String, Integer> getStock() {
		return stock;
	}

	public void setStock(Map<String, Integer> stock) {
		this.stock = stock;
	}

	public Calendar getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Calendar updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public String toString() {
		return "Stock [updatedTime=" + updatedTime + "]";
	}
}
