package pageLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

	WebDriver driver;
	
	By oldPassword = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div div div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid div div.container-fluid div.row div.col-lg-12 form div.form-group.row:nth-child(1) div.col-lg-12 input.form-control");
	By NewPassword = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div div div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid div div.container-fluid div.row div.col-lg-12 form div.form-group.row:nth-child(2) div.col-lg-12 input.form-control");
	By confirmPassword = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div div div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid div div.container-fluid div.row div.col-lg-12 form div.form-group.row:nth-child(3) div.col-lg-12 input.form-control");
    By updatePassword = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div div div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid:nth-child(2) div div.container-fluid div.row div.col-lg-12 form div.form-group.row div.col-lg-12.text-xs-center button.btn.btn-primary.Button");
	
	
	public MyAccountPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void enterValidDetails() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(oldPassword).sendKeys("arsenal2422232");
		driver.findElement(NewPassword).sendKeys("testingpassword123");
		driver.findElement(confirmPassword).sendKeys("testingpassword123");
		Thread.sleep(3000);
		driver.findElement(updatePassword).click();
	}
	
	public void enterInvalidDetails() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(oldPassword).sendKeys("arsenal2422232");
		driver.findElement(NewPassword).sendKeys("sjhdjsjj");
		driver.findElement(confirmPassword).sendKeys("kjsusuii");
		Thread.sleep(3000);
		driver.findElement(updatePassword).click();
		
		
	}
	
}
