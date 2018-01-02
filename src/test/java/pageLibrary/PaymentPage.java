package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {
	
	WebDriver driver;
	By visa = By.xpath("html/body/div/div[2]/div/div[3]/form/table/tbody/tr/td[1]/div/a/img");
	By visaButton = By.name("visa_button");
	By creditCard = By.xpath("html/body/div/div[2]/div/div[3]/form/div[2]/input");
	By expiryMonth = By.xpath("html/body/div/div[2]/div/div[3]/form/div[3]/select[1]");
	By expiryYear = By.xpath("html/body/div/div[2]/div/div[3]/form/div[3]/select[2]");
	By cvv2 = By.xpath("html/body/div/div[2]/div/div[3]/form/div[4]/input");
	By Name = By.xpath("html/body/div/div[2]/div/div[3]/form/div[5]/input");
	By submit = By.xpath("html/body/div/div[2]/div/div[3]/form/div[6]/input[4]");
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectExpiry() {
		WebElement Month = driver.findElement(expiryMonth);
		Select dropdownMonth = new Select(Month);
	    dropdownMonth.selectByIndex(10);
	    
	    WebElement Year = driver.findElement(expiryYear);
		Select dropdownYear = new Select(Year);
		dropdownYear.selectByIndex(10);
	}
	
	public void enterCreditCardDetils() {
		
		driver.findElement(visaButton).click();
		driver.findElement(creditCard).sendKeys("4111111111111111");
		selectExpiry();
		driver.findElement(cvv2).sendKeys("123");
		driver.findElement(Name).sendKeys("Testing");
		driver.findElement(submit).click();
		
	}
	
	
}
