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

import pageLibrary.CirclesAppDashboardPage;
import pageLibrary.CirclesAppMenuPage;
import pageLibrary.CirclesAppProfilePage;

@Test
public class TS0010_PortInThroughApp {

	WebDriver driver;
	CirclesAppDashboardPage dashboardPage;
	CirclesAppMenuPage menupage;
	CirclesAppProfilePage profilePage;
	
	@BeforeTest
    public void setUp() throws MalformedURLException {
		
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
	
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("Full-Reset", "false");
		capabilities.setCapability("deviceName", "487fee9d");
	
		capabilities.setCapability("platformName", "Android");
		
		capabilities.setCapability("appPackage", "com.circles.selfcare.qa");

			
		capabilities.setCapability("appActivity", "com.circles.selfcare.ui.activity.LaunchActivity");
		
		driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void portInMobile() throws InterruptedException {
		
		profilePage = new CirclesAppProfilePage(driver);
		dashboardPage = new CirclesAppDashboardPage(driver);
		menupage = new CirclesAppMenuPage(driver);
		Thread.sleep(3000);
		dashboardPage.clickOnMenuButton();
		Thread.sleep(3000);
		menupage.clickOnProfileButton();
		Thread.sleep(3000);
        profilePage.portInOperation();
        Thread.sleep(5000);
        profilePage.clickOnDone();
	}
}
