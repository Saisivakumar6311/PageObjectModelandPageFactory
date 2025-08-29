package com.makemytrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.base.BaseTest;
import com.makemytrip.util.TestUtil;

public class HomePage extends BaseTest{
	
	@FindBy(xpath="//a[contains(@href,'/flights')]/span[2]")
	WebElement flightMenu;
	
	@FindBy(xpath="//li[@data-cy='roundTrip']//span[@class='tabsCircle appendRight5']")
	WebElement roundTripMenu;
	
	@FindBy(xpath="//input[@id='fromCity']")
	WebElement fromCityDrop;
	
	@FindBy(xpath="//input[@placeholder='From']")
	WebElement searchFromCity;
	
	@FindBy(xpath="//input[@id='toCity']")
	WebElement searchToCity;
	
	@FindBy(xpath ="//span[@class='lbl_input appendBottom10' and text()='Departure']")
	WebElement depatureDrop;
	
	@FindBy(xpath="//span[@class='lbl_input appendBottom10' and text()='Return']")
	WebElement returnDrop;
	
	String depatureData="//div[@arial-label='%replace%' and @arial-disabled='false']";
	String returnData = "//div[@arial-label='%replace%' and @arial-disabled='false']";
	
	@FindBy(xpath = "//a[contains(@class,'primaryBtn font24 latoBold widgetSearchBtn') and text()='Search']")
	WebElement SearchBtn;
	
	
	//Constructor
	
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void selectFlightMenu() {
		flightMenu.click();
	}
	
	public void roundTripMenu() {
		roundTripMenu.click();
	}
	
	public void enterDepartureCity() {
		fromCityDrop.click();
		searchFromCity.sendKeys(config.getProperty("From"));
		searchFromCity.sendKeys(Keys.TAB);
	}
	
	public void enterReturnCity() {
		searchToCity.sendKeys(config.getProperty("To"));
		searchToCity.sendKeys(Keys.TAB);
	}
	
	public void enterDepartureDate() {
		depatureDrop.click();
//		String departureXpath=depatureData.replace("%replace%", "Thu Aug 29 2025");
//		
//		driver.findElement(By.xpath(departureXpath)).click();
		
		TestUtil date = TestUtil.getCurrentDateandReturnDate();
		driver.findElement(TestUtil.customXpath(depatureData, date.returnDate)).click();
	}
	
	public void enterReturnDate() {
		returnDrop.click();
		TestUtil date = TestUtil.getCurrentDateandReturnDate();
		driver.findElement(TestUtil.customXpath(returnData, date.returnDate)).click();
	
	}
	
	public void searchButton() {
		SearchBtn.click();
	}
	
	
	
}
