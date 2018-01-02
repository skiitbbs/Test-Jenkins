package testScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageLibrary.ChooseNumberPage;
import pageLibrary.DeliveryInfoPage;
import pageLibrary.Login;
import pageLibrary.OrderSummaryPage;
import pageLibrary.PaymentPage;
import pageLibrary.PlanPage;
import pageLibrary.PreCheckoutPage;
import pageLibrary.ThankYouPage;

@Test
public class TS006_NewOrderDeliveryAddressDifferent {
	
	Login logIn;
	PlanPage planPage;
	WebDriver driver;
	ChooseNumberPage chooseNumberPage;
	PreCheckoutPage preCheckoutPage;
	DeliveryInfoPage deliveryInfoPage;
	OrderSummaryPage orderSummaryPage;
	PaymentPage paymentPage;
	ThankYouPage thankYouPage;
	
    @BeforeClass
    void Setup() {
    		
    		System.setProperty("webdriver.gecko.driver", "//Users//sumitkumar//Downloads//Automation//geckodriver");
    		driver = new FirefoxDriver();

    		driver.get("https://circles-admin:123qweAadmin@staging.circles.asia/login");
    		driver.get("https://staging.circles.asia/login");
    
    }
    
    @Test(description ="This TC will verify Successfull login")
    void VerifyLogin() throws IOException {
    		
    		logIn = new Login(driver);
		logIn.enterEmailAddress();
		logIn.clickOnSignIn();
    	
    }
    
    @Test
    public void enterDeliveryAddress() throws  InterruptedException, AWTException, IOException {
    	
    	planPage = new PlanPage(driver);
    	chooseNumberPage = new ChooseNumberPage(driver);
    	preCheckoutPage = new PreCheckoutPage(driver);
    	deliveryInfoPage = new DeliveryInfoPage(driver);
    	orderSummaryPage = new OrderSummaryPage(driver);
    	paymentPage = new PaymentPage(driver);
    	thankYouPage = new ThankYouPage(driver);
    	
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 planPage.clickOnKeepOldNumber();
    	 chooseNumberPage.getAGoldenNumber();
     planPage.clickOnBuyThisPlan();
     preCheckoutPage.getNumber();
     preCheckoutPage.clickOnSecureCheckout();
	 Thread.sleep(2000);
    	 deliveryInfoPage.deliveryAddress();
    	 orderSummaryPage.clickOnPayNow();
 	 Thread.sleep(2000);
     paymentPage.enterCreditCardDetils();
 	 Thread.sleep(20000);
 	 thankYouPage.getOrderId();
 	 
    }

}
