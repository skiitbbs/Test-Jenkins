package testScripts;

import org.testng.annotations.Test;

import pageLibrary.Login;
import pageLibrary.MyAccountPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Test
public class TS0012_UpdatePasswordwithValidData {

	Login logIn;
	WebDriver driver;
	MyAccountPage myAccount;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "/Users/leena/Downloads/circles-project-abhinav-Circles-life-code-8da840dde6afff2280eef736641bc6899ef6ffb7/src/test/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://circles-admin:123qweAadmin@staging.circles.asia/login");
		driver.get("https://staging.circles.asia/login");
				
	}
   
	@Test
	public void testUpdatePassword() throws IOException, InterruptedException {
		logIn = new Login(driver);
		myAccount = new MyAccountPage(driver);
		logIn.enterEmailAddress();
		//logIn.enterPassword();
		logIn.clickOnSignIn();
		Thread.sleep(2000);
	    logIn.clickOnMyAccount();
	    Thread.sleep(3000);
		myAccount.enterValidDetails();
	}
	
	
	
	
}
