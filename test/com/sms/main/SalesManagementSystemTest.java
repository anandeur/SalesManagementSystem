package com.sms.main;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.sms.main.SalesManagementSystem;

public class SalesManagementSystemTest {
	private SalesManagementSystem sms;

	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		sms = new SalesManagementSystem();
		sms.addStore("", "bellandur", "bangalore", "karnataka", "india");
		sms.addStore("", "hsr", "bangalore", "karnataka", "india");
		sms.addItem("", "tea", "beverage");
		sms.addItem("", "sandwich", "food");
		sms.addStock("", "tea", "bellandur", "10", "15");
		sms.addStock("", "sandwich", "hsr", "5", "25");
		sms.sale("", "tea", "bellandur", "2");
		sms.sale("", "sandwich", "hsr", "1");
	}

	@SuppressWarnings("static-access")
	@Test
	public void test_sale_bellandur() {
		Store bellandurStore = sms.stores.get("bellandur");
		int totalSale = 0;
		Calendar todaysDate = new GregorianCalendar();
		todaysDate.set(Calendar.HOUR_OF_DAY, 0);
		todaysDate.set(Calendar.MINUTE, 0);
		todaysDate.set(Calendar.SECOND, 0);
		todaysDate.set(Calendar.MILLISECOND, 0);

		for (Sale sale : bellandurStore.getSales()) {
			if (todaysDate.before(sale.getCreatedTime())) {
				totalSale += sale.getAmount();
			}
		}
		assertEquals(30, totalSale);
	}

	@SuppressWarnings("static-access")
	@Test
	public void test_sale_bangalore() {
		City bangaloreCity = sms.cities.get("bangalore");
		int totalSale = 0;
		Calendar todaysDate = new GregorianCalendar();
		todaysDate.set(Calendar.HOUR_OF_DAY, 0);
		todaysDate.set(Calendar.MINUTE, 0);
		todaysDate.set(Calendar.SECOND, 0);
		todaysDate.set(Calendar.MILLISECOND, 0);

		for (Store store : bangaloreCity.getStores()) {
			for (Sale sale : store.getSales()) {
				if (todaysDate.before(sale.getCreatedTime())) {
					totalSale += sale.getAmount();
				}
			}
		}
		assertEquals(55, totalSale);
	}

}
