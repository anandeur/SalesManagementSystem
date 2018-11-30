package com.sms.main;

import java.util.ArrayList;
import java.util.List;

public class City {
	private String name;
	private State state;
	private Country country;
	private List<Store> stores = new ArrayList<Store>();

	public City(String name, State state, Country country) {
		this.name = name;
		this.state = state;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	@Override
	public String toString() {
		return "City [name=" + name + "]";
	}
}
