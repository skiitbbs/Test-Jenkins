package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CirclesAppProfilePage {

	WebDriver driver;
	
	By editButton = By.id("card_view_action");
	By enterNickName = By.id("nick_name_input");
	By ep = By.xpath("//android.widget.ImageView[contains(@resource-id,'card_view_action') and @index='1']");
	By doneButton = By.xpath("//android.widget.TextView[@content-desc='Done']");
	By portInButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[4]");
    By portingNumber = By.id("com.circles.selfcare.qa:id/porting_number");
	By postPaid = By.id("com.circles.selfcare.qa:id/radio_button1");
    By chooseOne = By.xpath("//android.widget.TextView[@text='Choose one']");
    By provider = By.xpath("//android.widget.TextView[@text='Singtel']");
	By chooseDate = By.xpath("//android.widget.TextView[@text='Choose date']");
	By portingDate = By.xpath("//android.widget.TextView[@text='23 November - Thursday']");
	By nircID = By.xpath("//android.widget.RadioButton[@text='Yes']");
	By editBillingAddress = By.xpath("//android.widget.ImageView[@resource-id='com.circles.selfcare.qa:id/card_view_action'] and [@index='1']");
	
	
	public CirclesAppProfilePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickOnEditProfile() {
		
		driver.findElement(ep).click();
	}
	
	public void enterValidDetails() {
		
		driver.findElement(enterNickName).sendKeys("abhinavTest");
		
	}
	
	public void clickOnDone() {
		
		driver.findElement(doneButton).click();
	}
	
	public void portInOperation() throws InterruptedException {
		
		driver.findElement(portInButton).click();
		driver.findElement(portingNumber).sendKeys("88346721");
		driver.findElement(postPaid).click();
		Thread.sleep(3000);
		driver.findElement(chooseOne).click();
		Thread.sleep(3000);
		driver.findElement(provider).click();
		Thread.sleep(3000);
		driver.findElement(chooseDate).click();
		Thread.sleep(3000);
		driver.findElement(portingDate).click();
		Thread.sleep(2000);
		driver.findElement(nircID).click();
	}
	
	public void updateBillingAddress() throws InterruptedException {
		
		driver.findElement(editBillingAddress).click();
		
	}
}
