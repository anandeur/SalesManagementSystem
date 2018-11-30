package com.sms.main;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesManagementSystem {

	public static final Map<String, Store> stores = new HashMap<String, Store>();
	public static final Map<String, Item> items = new HashMap<String, Item>();
	public static final Map<String, Stock> inventory = new HashMap<String, Stock>();
	public static final Map<String, Map<String, Integer>> prices = new HashMap<String, Map<String, Integer>>();
	public static final Map<String, City> cities = new HashMap<String, City>();
	public static final Map<String, State> states = new HashMap<String, State>();
	public static final Map<String, Country> countries = new HashMap<String, Country>();

	public static void main(String[] args) {
		System.out.println("Welcome to Sales Management System");
		while (true) {
			Scanner scan = new Scanner(System.in);
			try {
				String input = scan.nextLine();
				String[] params = input.split("~");
				Command command = Command.valueOf(params[0]);
				switch (command) {
				case addStore:
					if (params.length == 5) {
						addStore(params);
					} else {
						invalidInput(input);
					}
					printStatus();
					break;
				case addItem:
					if (params.length == 3) {
						addItem(params);
					} else {
						invalidInput(input);
					}
					printStatus();
					break;
				case addStock:
					if (params.length == 5) {
						addStock(params);
					} else {
						invalidInput(input);
					}
					printStatus();
					break;
				case updateStock:
					if (params.length == 5) {

					} else {
						invalidInput(input);
					}
					printStatus();
					break;
				case sale:
					if (params.length == 4) {
						sale(params);
					} else {
						invalidInput(input);
					}
					printStatus();
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}

	public static void invalidInput(String input) {
		System.out.println("Invalid input: " + input);
	}

	public static void noItem(String itemName) {
		System.out.println("Item does not exist: " + itemName);
	}

	public static void noStore(String storeName) {
		System.out.println("No store with name:" + storeName);
	}

	public static void noQuantity(String itemName, String storeName) {
		System.out.println("Insufficient quantity for item " + itemName + " at store " + storeName);
	}

	public static void addStore(String... params) {
		if (!stores.containsKey(params[1])) {
			Country country = null;
			if (countries.containsKey(params[4])) {
				country = countries.get(params[4]);
			} else {
				country = new Country(params[4]);
				countries.put(params[4], country);
			}
			State state = null;
			if (states.containsKey(params[3])) {
				state = states.get(params[3]);
			} else {
				state = new State(params[3], country);
				states.put(params[3], state);
			}
			country.getStates().add(state);
			City city = null;
			if (cities.containsKey(params[2])) {
				city = cities.get(params[2]);
			} else {
				city = new City(params[2], state, country);
				cities.put(params[2], city);
			}
			state.getCities().add(city);
			Store store = new Store(params[1], city, state, country);
			stores.put(store.getName(), store);
			city.getStores().add(store);
		}
	}

	public static void addItem(String... params) {
		if (!items.containsKey(params[1])) {
			Item item = new Item(params[1], Category.valueOf(params[2]));
			items.put(item.getName(), item);
		}
	}

	public static void addStock(String... params) {
		Item item = items.get(params[1]);
		if (item != null) {
			Store store = stores.get(params[2]);
			if (store != null) {
				store.getItems().add(item);
				Integer quantity = Integer.valueOf(params[3]);
				if (inventory.containsKey(store.getName())) {
					Stock storeStock = inventory.get(store.getName());
					storeStock.getStock().put(item.getName(), quantity);
					storeStock.setUpdatedTime(new GregorianCalendar());
				} else {
					Stock storeStock = new Stock();
					storeStock.getStock().put(item.getName(), quantity);
					storeStock.setUpdatedTime(new GregorianCalendar());
					inventory.put(store.getName(), storeStock);
				}
				Integer price = Integer.valueOf(params[4]);
				if (prices.containsKey(store.getName())) {
					Map<String, Integer> storePrice = prices.get(store.getName());
					storePrice.put(item.getName(), price);
				} else {
					Map<String, Integer> storePrice = new HashMap<String, Integer>();
					storePrice.put(item.getName(), price);
					prices.put(store.getName(), storePrice);
				}
			} else {
				noStore(params[2]);
			}
		} else {
			noItem(params[1]);
		}
	}

	public static void updateStock(String... params) {
		Item item = items.get(params[1]);
		if (item != null) {
			Store store = stores.get(params[2]);
			if (store != null) {
				store.getItems().add(item);
				Integer quantity = Integer.valueOf(params[3]);
				if (inventory.containsKey(store.getName())) {
					Stock storeStock = inventory.get(store.getName());
					storeStock.getStock().put(item.getName(), quantity);
					storeStock.setUpdatedTime(new GregorianCalendar());
				} else {
					Stock storeStock = new Stock();
					storeStock.getStock().put(item.getName(), quantity);
					storeStock.setUpdatedTime(new GregorianCalendar());
					inventory.put(store.getName(), storeStock);
				}
				Integer price = Integer.valueOf(params[4]);
				if (prices.containsKey(store.getName())) {
					Map<String, Integer> storePrice = prices.get(store.getName());
					storePrice.put(item.getName(), price);
				} else {
					Map<String, Integer> storePrice = new HashMap<String, Integer>();
					storePrice.put(item.getName(), price);
					prices.put(store.getName(), storePrice);
				}
			} else {
				noStore(params[2]);
			}
		} else {
			noItem(params[1]);
		}
	}

	public static void sale(String... params) {
		Item item = items.get(params[1]);
		if (item != null) {
			Store store = stores.get(params[2]);
			if (store != null) {
				Integer purchasedQuantity = Integer.valueOf(params[3]);
				Integer existingQuantity = inventory.get(store.getName()).getStock().get(item.getName());
				if (purchasedQuantity <= existingQuantity) {
					Sale sale = new Sale(item, store, purchasedQuantity);
					store.getSales().add(sale);
					Integer newQuantity = existingQuantity - purchasedQuantity;
					if (inventory.containsKey(store.getName())) {
						Stock storeStock = inventory.get(store.getName());
						storeStock.getStock().put(item.getName(), newQuantity);
						storeStock.setUpdatedTime(new GregorianCalendar());
					} else {
						Stock storeStock = new Stock();
						storeStock.getStock().put(item.getName(), newQuantity);
						storeStock.setUpdatedTime(new GregorianCalendar());
						inventory.put(store.getName(), storeStock);
					}
				} else {
					noQuantity(params[2], params[3]);
				}
			} else {
				noStore(params[2]);
			}
		} else {
			noItem(params[1]);
		}
	}

	private static void printStatus() {
		System.out.println("Countries: " + countries);
		System.out.println("States: " + states);
		System.out.println("Cities: " + cities);
		System.out.println("Stores: " + stores);
		System.out.println("Items: " + items);
		System.out.println("Inventory: " + inventory);
		System.out.println("Prices: " + prices);
	}

}
