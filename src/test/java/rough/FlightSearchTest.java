package rough;

import java.text.ParseException;

import base.Page;
import pages.actions.HomePage;

public class FlightSearchTest {
	public static void main(String[] args) throws ParseException {
		
		
		Page.initConfiguration();
		HomePage page=new HomePage();
		page.gotoFlights().bookAFlight("Delhi (DEL-Indira Gandhi Intl.)", "Hyderabad (HYD-Rajiv Gandhi Intl.)", "25/06/2020", "27/06/2020","5","4","3");
		
	}
}
