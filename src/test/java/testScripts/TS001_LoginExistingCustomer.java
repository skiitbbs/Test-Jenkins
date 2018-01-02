package testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageLibrary.Login;

@Test
public class TS001_LoginExistingCustomer {
	Login logIn;
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "//Users//sumitkumar//Downloads//Automation//geckodriver");
    		driver = new FirefoxDriver();
		driver.get("https://circles-admin:123qweAadmin@staging.circles.asia/login");
		driver.get("https://staging.circles.asia/login");
				
	}
   
	@Test(description = "This TC will verify the title of the page" )
    public void verifyTitle() {
		String actualTitle = "Unlimit your telco. Now.";
		logIn = new Login(driver);
		Assert.assertEquals(driver.getTitle(), actualTitle);
		
	}
	
	@Test(description= "this TC will verify Successfull login")
	public void testLogin() throws IOException {
		logIn = new Login(driver);
		logIn.enterEmailAddress();
		//logIn.enterPassword();
		logIn.clickOnSignIn();
				
	}
	
	@Test(description = "this TC will verify Company logo should be present")
	public void verifyLogoIsPresent() {
		logIn =  new Login(driver);
		driver.findElement(By.xpath(".//*[@id='st-container']/div/div/div[1]/div/div/div[1]/a/img")).isDisplayed();
		
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
