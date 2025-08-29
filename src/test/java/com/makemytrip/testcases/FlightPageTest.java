package com.makemytrip.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.makemytrip.base.BaseTest;
import com.makemytrip.pages.HomePage;

public class FlightPageTest extends BaseTest{
	
	@Test
	public void searchFlight() {
		
		HomePage home = new HomePage();
		
		home.selectFlightMenu();
		test.log(Status.INFO, "Clicked on flight menu");
		
		home.roundTripMenu();
		test.log(Status.INFO, "Round trip menu");
		
		home.enterDepartureCity();
		test.log(Status.INFO, "Entered the Depature city");
		
		home.enterReturnCity();
		test.log(Status.INFO, "Entered the returncity");
		
		home.enterDepartureDate();
		test.log(Status.INFO, "Entered the Depaturedate");
		
		home.enterReturnDate();
		test.log(Status.INFO, "Entered the return date");
		
		home.searchButton();
		test.log(Status.INFO, "Clicked on Searchbutton");
	}
	
}
