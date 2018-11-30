package com.sms.main;

import java.util.ArrayList;
import java.util.List;

public class Country {
	private String name;
	private List<State> states = new ArrayList<State>();

	public Country(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + "]";
	}
}
