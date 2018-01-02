package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CirclesAppCustomizePage {
	
	WebDriver driver;
	
	By plusButton = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]");
	By pB = By.xpath("//android.widget.ListView[2]/android.widget.RelativeLayout[2]/android.widget.LinearLayout[@index='1']");
	By addOn20GB = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Switch");
	By enableButton = By.id("com.circles.selfcare.qa:id/dialog_button");
	By buyNowButton = By.xpath("//android.widget.TextView[@resource-id='com.circles.selfcare.qa:id/dialog_button' and @text='BUY NOW'");
	////android.widget.Button[contains(@resource-id,'digit5') and @text='5']
	public CirclesAppCustomizePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void clickOnPlus() {
		
		driver.findElement(pB).click();
	}

	public void clickOnAddOn() {
		
		driver.findElement(addOn20GB).click();
	}
	
	public void clickOnEnable() {
		
		driver.findElement(enableButton).click();
		driver.findElement(buyNowButton).click();
	}
}
