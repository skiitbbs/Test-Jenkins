package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CirclesAppMenuPage {

	WebDriver driver;
	
	
	By customizeButton = By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[4]");
	By cuzB = By.xpath("//android.widget.RelativeLayout[@index='4']");
	By profileButton= By.id("user_number");//com.circles.selfcare.qa:id/user_number
	
	
	public CirclesAppMenuPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void clickOnCustomize() {
		
		driver.findElement(cuzB).click();
		
	}
	
	public void clickOnProfileButton() {
		driver.findElement(profileButton).click();
		
	}
	
}
