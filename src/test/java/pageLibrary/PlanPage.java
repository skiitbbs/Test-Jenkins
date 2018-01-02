package pageLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;

public class PlanPage {

	
	WebDriver driver;
	
	//By keepOldNumber = By.xpath(".//*[@id='st-container']/div/div/div[2]/span/div/div/div[3]/div/div[1]/div/a/div/div/div[2]/div");
	By keepOldNumber = By.cssSelector(".col-lg-6:nth-child(1) .small-card-height .pocket-button");
	By buyThisPlan = By.cssSelector(".btn-block.Links");
	By unlmitedAddON = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div > div:nth-child(6) > div > div > div > div > div > div > div.col-xs-2.col-md-1 > div > img");
	By getItNow = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div > div:nth-child(3) > div > div:nth-child(2) > div > a > div > div.text-primary > div");
	By getDevice = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(1) > div > a > div > div.col-xs-4 > div:nth-child(2) > span");
	By selectColor = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div > div:nth-child(4) > div > div:nth-child(2) > div > div");
	By selectCapacity = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div > div:nth-child(5) > div.container-fluid > div > div > div");
	By selectfullPayment = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div > div:nth-child(6) > div.container-fluid > div > div:nth-child(1) > div > div > div:nth-child(2)");
	By getThisPhone = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > footer > div > div > div > a");
	
	
	public PlanPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnKeepOldNumber() {
		driver.findElement(keepOldNumber).click();
		
	}
	
	public void clickOnBuyThisPlan() {
		driver.findElement(buyThisPlan).click();
						
	}
	
	public void clickOnUnlimitedAddOn() {
		
		driver.findElement(unlmitedAddON).click();
	}
	
	public void getDevice() throws InterruptedException, AWTException {
		
		driver.findElement(getItNow).click();
		Thread.sleep(2000);
		driver.findElement(getDevice).click();
		Thread.sleep(2000);
		driver.findElement(selectColor).click();
		Thread.sleep(2000);
		driver.findElement(selectCapacity).click();
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		/*
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);
		*/

		driver.findElement(selectfullPayment).click();
		
		//Thread.sleep(2000);
		driver.findElement(getThisPhone).click();
		
	}
	
}
