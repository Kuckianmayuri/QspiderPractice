package config;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.WebdriverUtility;

public class baseClass {
   
	public JavaUtility jlib = new JavaUtility();
    public  ExcelUtility elib = new ExcelUtility();
    public PropertyUtility prib = new PropertyUtility();
    public WebdriverUtility wUtil = new WebdriverUtility();
    public WebDriver driver;
    public HomePage home;
    public static WebDriver sdriver = null;
	   
	@BeforeSuite (groups = {"smoke", "campaign"})
	public void beforeSuite() {
		Reporter.log("Database connectivity", true);
		
	}
	@AfterSuite (groups = {"smoke", "Regression", "campaign"})
	public void afterSuite() {
		Reporter.log("close database connectivity", true);
		
	}
	
	@BeforeTest (groups = {"smoke", "Regression", "campaign"})
	public void beforeTest() {
		Reporter.log("Before parallel execution", true);
		
	}
	@AfterTest (groups = {"smoke", "Regression", "campaign"})
	public void afterTest() {
		Reporter.log("After parallel execution", true);
		
	}
	
	//@Parameters("BROWSER")
	@BeforeClass (groups = {"smoke", "Regression","campaign"})
	public void beforeClass() throws IOException {
		String BROWSER = prib.toReadDataFromPropertiesFile("Browser");
		//String BROWSER = browser;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		 sdriver = driver;
		
	}
	@AfterClass (groups = {"smoke", "Regression", "campaign"})
	public void afterClass() {
		driver.close();
		
	}
	
	@BeforeMethod (groups = {"smoke", "Regression", "campaign"})
	public void beforeMethod() throws IOException {
		String URL = prib.toReadDataFromPropertiesFile("Url");
		String USERNAME = prib.toReadDataFromPropertiesFile("Username");
		String PASSWORD = prib.toReadDataFromPropertiesFile("Password");
		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(URL, USERNAME, PASSWORD);	
		home = new HomePage(driver);
	}
	
	@AfterMethod (groups = {"smoke", "Regression", "campaign"})
	public void afterMethod() {
		 WebElement profileIcon = home.getProfileIcon();
	        wUtil.mouseHoverToWebElement(driver, profileIcon);
	        home.getLogoutButton().click();
		
	}
	
}
