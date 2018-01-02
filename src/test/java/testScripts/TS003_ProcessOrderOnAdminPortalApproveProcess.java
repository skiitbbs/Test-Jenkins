package testScripts;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageLibrary.AdminLoginPage;
import pageLibrary.AdminPortalHome;

@Test
public class TS003_ProcessOrderOnAdminPortalApproveProcess {
	
	WebDriver driver;
	AdminLoginPage adminLogin;
	AdminPortalHome adminHome;
	
	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","//Users//sumitkumar//Downloads//Automation//chromedriver");
		driver= new ChromeDriver(); 
    	    driver.get("http://borg.circles.asia:6180/");
    	    
		
	}
	
	@Test
	public void approveProcess() throws InterruptedException, AWTException {
		
		adminLogin = new AdminLoginPage(driver);
		adminHome = new AdminPortalHome(driver);
		adminLogin.enterLoginDetails();
		//adminHome.approveProcess();
		Thread.sleep(4000);
		adminHome.deliverProcess();
		adminHome.planSwitchProcess();
						
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
