package com.sms.main;

import java.util.ArrayList;
import java.util.List;

public class State {
	private String name;
	private Country country;
	private List<City> cities = new ArrayList<City>();

	public State(String name, Country country) {
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "State [name=" + name + "]";
	}
}
