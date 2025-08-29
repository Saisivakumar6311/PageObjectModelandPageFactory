package com.makemytrip.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	public static Properties config;
	public static WebDriver driver;
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest childTest;
	
	public void driverinitilization() {
		
		driver= new ChromeDriver();
		
		driver.get(config.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(config.getProperty("pageloadTime"))));
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().deleteAllCookies();
	}
	
	public void handlepopup() {
		//WebElement close =driver.findElement(By.xpath("//span[@class='commonModal__close']"));
		try {
			
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement closebutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='commonModal__close']")));
		closebutton.click();
		System.out.println("login pop up close successfully");
		} catch (Exception e) {
			System.out.println("login popup not displayed");
		}
	}
	
	public void readPropertyFile() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/property/config.properties");
		config = new Properties();
		config.load(fis);
	}
	
	public void setExtentReport() {
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//extendReports//MakemyTripReport.html");
		
		htmlReporter.config().setDocumentTitle("Make My Trip Automation report");
		
		htmlReporter.config().setReportName("Functional Testing");
		
		htmlReporter.config().setTheme(Theme.DARK);
	
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("Environmant", "Stage");
	
	
	
	
	
	
	
	}
}
