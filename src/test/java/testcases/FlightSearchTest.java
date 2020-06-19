package testcases;

import java.text.ParseException;

import org.testng.annotations.Test;

import base.Page;
import pages.actions.HomePage;

public class FlightSearchTest {
	
	@Test
	public void flightSearchTest() throws ParseException {
		Page.initConfiguration();
		HomePage page=new HomePage();
		page.gotoFlights().bookAFlight("BOM - Mumbai", "HYD - Hyderabad", "10/08/2020", "20/09/2020","5","4","3");
		page.quitBrowser();
	}
}
