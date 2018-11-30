package com.sms.main;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sale {
	private Item item;
	private Integer quantity;
	private Store store;
	private Integer amount;
	private Calendar createdTime;

	public Sale(Item item, Store store, Integer quantity) {
		this.item = item;
		this.store = store;
		this.quantity = quantity;
		this.createdTime = new GregorianCalendar();
		this.amount = quantity * SalesManagementSystem.prices.get(store.getName()).get(item.getName());
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "Sale [item=" + item + ", quantity=" + quantity + ", store=" + store + ", amount=" + amount
				+ ", createdTime=" + createdTime + "]";
	}
	
}
