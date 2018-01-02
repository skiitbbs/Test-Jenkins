package testScripts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageLibrary.CirclesAppCustomizePage;
import pageLibrary.CirclesAppDashboardPage;
import pageLibrary.CirclesAppMenuPage;

@Test
public class TS008_ChangePlanOnCirclesApp {

	WebDriver driver;
	CirclesAppDashboardPage dashboardPage;
	CirclesAppMenuPage menupage;
	CirclesAppCustomizePage customizePage;
	
	@BeforeTest
    public void setUp() throws MalformedURLException {
		
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
	
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("Full-Reset", "false");
		capabilities.setCapability("deviceName", "487fee9d");
	
		capabilities.setCapability("platformName", "Android");
		
		capabilities.setCapability("appPackage", "com.circles.selfcare.qa");

			
		capabilities.setCapability("appActivity", "com.circles.selfcare.ui.activity.LaunchActivity");
		//capabilities.setCapability("appActivity", "com.circles.selfcare.ui.activity.DashboardActivity");
		
		
		driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	/*@Test(description="This TC will verify menu click button")
	public void checkMenuClick() {
		
		dashboardPage = new CirclesAppDashboardPage(driver);
		dashboardPage.clickOnMenuButton();
				
	}*/
	
	@Test(description="This TC will verify the change plan functionality")
	public void changePlan() throws InterruptedException {
		dashboardPage = new CirclesAppDashboardPage(driver);
		menupage = new CirclesAppMenuPage(driver);
		customizePage = new CirclesAppCustomizePage(driver);
		dashboardPage.clickOnMenuButton();
		menupage.clickOnCustomize();
		Thread.sleep(3000);
		customizePage.clickOnPlus();
		Thread.sleep(2000);
		customizePage.clickOnAddOn();
		Thread.sleep(2000);
		customizePage.clickOnEnable();
		
				
	}
	
}
