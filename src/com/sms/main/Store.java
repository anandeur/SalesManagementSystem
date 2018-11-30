package com.sms.main;

import java.util.ArrayList;
import java.util.List;

public class Store {
	private String name;
	private City city;
	private State state;
	private Country country;
	private List<Item> items = new ArrayList<Item>();
	private List<Sale> sales = new ArrayList<Sale>();

	public Store(String name, City city, State state, Country country) {
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + "]";
	}

}
