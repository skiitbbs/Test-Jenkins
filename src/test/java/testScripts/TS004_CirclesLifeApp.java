package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class TS004_CirclesLifeApp {
	
	WebDriver driver;

	@BeforeTest
    public void setUp() throws MalformedURLException {
		
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
	
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("Full-Reset", "false");
		capabilities.setCapability("deviceName", "0115314335373530");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.circles.selfcare.qa");
		capabilities.setCapability("appActivity", "com.circles.selfcare.ui.activity.LaunchActivity");
	
		
		driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void checkDataBalance() {

		
		String ActualData = new String();
		ActualData = "2.7 GB to go";
		
		WebElement dataUsage = driver.findElement(By.id("com.circles.selfcare.qa:id/pre_text_view"));
		String DataBalance = dataUsage.getText();
		
		Assert.assertEquals(DataBalance, ActualData);
	}
	
	
}
