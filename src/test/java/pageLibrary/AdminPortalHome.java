package pageLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPortalHome {
	
	WebDriver driver;
	Robot robot;
	
	By documentApprovals = By.xpath("html/body/div/div/div/div[1]/ul/li[5]/a");
	By orderRefApproval = By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/form/div[1]/div[3]/div/input");
	By filterApproval = By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/form/div[3]/div/div/button");
	By quickViweButton = By.xpath("html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[12]/button");		
	By approveButton = By.cssSelector("form#edit_put.edit_put button.btn.btn-sm.btn-success");
	By orders = By.xpath("html/body/div[1]/div/div/div[1]/ul/li[4]/a");
	By orderRefOrders = By.xpath("html/body/div[1]/div/div/div[2]/div[1]/div[2]/form/div[3]/div[1]/div/input");
	By orderId = By.xpath("html/body/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[3]/button");
	By otherActions = By.xpath("html/body/div[1]/div/div/div[2]/div[3]/div/div/div[2]/div/div[3]/ul/li[9]/a");
	By markAsDelivered = By.xpath("html/body/div[1]/div/div/div[2]/div[3]/div/div/div[2]/div/div[3]/div/div[9]/div/div[2]/div[5]/div[2]/form[1]/input[2]");
	By planSwitch = By.xpath("html/body/div[1]/div/div/div[2]/div[3]/div/div/div[2]/div/div[3]/div/div[9]/div/div[2]/div[7]/div[2]/form/input[2]");
	
	
	public AdminPortalHome(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void approveProcess() throws InterruptedException, AWTException {
		
		driver.findElement(documentApprovals).click();
		driver.findElement(orderRefApproval).sendKeys("000001510554209543");
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		driver.findElement(quickViweButton).click();
		Thread.sleep(4000);
		driver.findElement(approveButton).click();
		
		Thread.sleep(2000);
		Robot pressEnter = new Robot();
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(5000);
		pressEnter.keyPress(KeyEvent.VK_ENTER);
		pressEnter.keyRelease(KeyEvent.VK_ENTER);
		pressEnter.delay(4000);
		Thread.sleep(4000);
		
		
	}
	
	public void deliverProcess() throws InterruptedException, AWTException {
		
		driver.findElement(orders).click();
		driver.findElement(orderRefOrders).sendKeys("000001510554209543");
		Thread.sleep(3000);
		driver.findElement(orderId).click();
		Thread.sleep(4000);
		driver.findElement(otherActions).click();
		driver.findElement(markAsDelivered).click();
		Thread.sleep(4000);
		/*
		Robot pressEnter = new Robot();
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(5000);
		*/
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		Thread.sleep(4000);
		
		
	}
	
	public void planSwitchProcess() throws InterruptedException, AWTException {
		
		
		
		driver.findElement(otherActions).click();
		driver.findElement(planSwitch).click();
		Thread.sleep(2000);
		Robot pressEnter = new Robot();
		pressEnter.keyPress(KeyEvent.VK_ENTER);
		pressEnter.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
	}
	

}
