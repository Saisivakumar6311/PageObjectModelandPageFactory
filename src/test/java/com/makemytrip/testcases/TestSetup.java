package com.makemytrip.testcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.makemytrip.base.BaseTest;

public class TestSetup extends BaseTest{
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		readPropertyFile();
		driverinitilization();
		handlepopup();
		setExtentReport();
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
}
