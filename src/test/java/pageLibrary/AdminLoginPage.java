package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
	
	WebDriver driver;
	
	By userEmail =  By.xpath("html/body/div/div/div/div[2]/form/div[1]/input");
	By userPassword = By.xpath("html/body/div/div/div/div[2]/form/div[2]/input");
	By loginButton = By.xpath("html/body/div/div/div/div[2]/form/div[4]/input");
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterLoginDetails() {
		driver.findElement(userEmail).sendKeys("abhinav.shingate@velotio.com");
		driver.findElement(userPassword).sendKeys("123qweAadmin");
		driver.findElement(loginButton).click();
		
	}

}
