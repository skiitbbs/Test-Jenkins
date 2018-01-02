package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage {

	WebDriver driver;
	
	By payNow = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/footer/div/div/div/div");
	
	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnPayNow() {
		driver.findElement(payNow).click();
	}
}
