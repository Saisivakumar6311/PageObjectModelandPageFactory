package com.makemytrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.makemytrip.base.BaseTest;

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
	
	
	
	
	
	
}
