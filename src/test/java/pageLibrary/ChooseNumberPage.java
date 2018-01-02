package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ChooseNumberPage {

	WebDriver driver;
	
	By getNewNumber = By.xpath(".//*[@id='number-select-container']/div[2]/div/div/div/div/div[1]/div[2]/div/div/center");
    By selectGoldenNumber = By.xpath("//*[@id=\"number-select-container\"]/div[2]/div/div/div/div/div[2]/div[3]/div/div[2]/div[3]/div[3]/button/center");
    By getThisNumber = By.xpath(".//*[@id='number-select-container']/footer/div/div/div/a");
    By currentNumber = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div span div#number-select-container.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div div input.form-control");
    By currentTelco = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div span div#number-select-container.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div div div div.container-fluid div.row div.col-xs-4:nth-child(1) div:nth-child(1) div div");
    
    public ChooseNumberPage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public void getAGoldenNumber() throws InterruptedException {
    	driver.findElement(getNewNumber).click();
    	Thread.sleep(2000);
    	driver.findElement(selectGoldenNumber).click();
    	Thread.sleep(2000);
    	driver.findElement(getThisNumber).click();
    }
    
    public void keepOldNumberPortIn() throws InterruptedException {
    	
    	driver.findElement(currentNumber).sendKeys("88098623");
    	Thread.sleep(2000);
    	driver.findElement(currentTelco).click();
    	Thread.sleep(2000);
    	driver.findElement(getThisNumber).click();
    }
    
    
}
