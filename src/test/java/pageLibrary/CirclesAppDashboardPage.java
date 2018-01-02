package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CirclesAppDashboardPage {

	WebDriver driver;
	
	By menuButton = By.className("android.widget.ImageButton");
	
	public CirclesAppDashboardPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickOnMenuButton() {
		
		driver.findElement(menuButton).click();
	}
	
}
