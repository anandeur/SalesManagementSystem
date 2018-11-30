package com.sms.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Item {
	private String name;
	private Category category;
	private Calendar createdTime;

	public Item(String name, Category category) {
		this.name = name;
		this.category = category;
		this.createdTime = new GregorianCalendar();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", category=" + category + ", createdTime=" + createdTime + "]";
	}

}
