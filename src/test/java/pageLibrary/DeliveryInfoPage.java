package pageLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DeliveryInfoPage {
	
	WebDriver driver;
	Robot robot;
	
	By fullName = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[1]/div[2]/div[1]/div/div/div/div[2]/input");
    By contactNmber = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[1]/div[2]/div[4]/div/div/div/div[2]/input");
	By dobDay = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[1]/div[2]/div[3]/div/div[1]/select");
	By dobMonth = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[1]/div[2]/div[3]/div/div[2]/select");
	By dobYear = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[1]/div[2]/div[3]/div/div[3]/select");
	By postalCode = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div[2]/input");
	By houseNo = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/input");
	By streetName = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div/div[2]/input");
	By delivaryDay = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div span div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid div div div div.container-fluid div.row div.col-xs-15.delivery-slots-day:nth-child(7) div span:nth-child(2)");
	By DD = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div span div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid div div div div.container-fluid div.row div.col-xs-15.delivery-slots-day:nth-child(3) div span:nth-child(2)");
	By deliveryTime = By.cssSelector(".row .delivery-slots-time:nth-child(1)");
	By idType= By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[4]/div[2]/div[1]/div/div/select");
	By frontImage = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div > div:nth-child(4) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div");
	By fimg = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div span div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid div div.container-fluid div.row div.col-xs-6:nth-child(1) div img");
	
	By backImage = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div > div:nth-child(4) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div");
	By nic = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[4]/div[2]/div[2]/div/div/div/div[2]/input");
	By sceureCheckOut = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/footer/div/div/div/div");
	By portIncheck = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[4]/div[2]/div[4]/div[1]/div[1]/div/img");
	By deliveryAddrress = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div[2]/div/div/div/div[3]/div[2]/div/div[1]/div[1]/div/img");
	By pcDelivery = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div > div > div > div:nth-child(2) > input");
	By hsDelivery = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > div.col-xs-4 > div > div > div > div > div:nth-child(2) > input");
	By snDelivery = By.cssSelector("#st-container > div > div > div:nth-child(2) > span > div > div:nth-child(2) > div > div > div > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div > div.col-xs-8 > div > div > div > div > div:nth-child(2) > input");
	By onPage = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div span");
	By pcc = By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div span div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid div div div.container-fluid div.row div.col-xs-12 div div input.form-control");
	By hsn = By.name("deliveryBlkHse");
	By stn = By.name("deliveryStreetName");
	
	
	public DeliveryInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectDob() {
		WebElement Day = driver.findElement(dobDay);
		Select dropdownDay = new Select(Day);
	    dropdownDay.selectByIndex(10);
		
		WebElement Month = driver.findElement(dobMonth);
		Select dropdownMonth = new Select(Month);
		dropdownMonth.selectByIndex(7);
		
		WebElement Year = driver.findElement(dobYear);
		Select dropdownYear = new Select(Year);
		dropdownYear.selectByIndex(10);

		
	}
	
	public void uploadFrontAndBackImage() throws InterruptedException, AWTException {
		
		WebElement backimg = driver.findElement(backImage);
		WebElement frontimg = driver.findElement(fimg);
		Thread.sleep(5000);
        	frontimg.click();
	
		Actions builder = new Actions(driver);
		Actions series = builder
				.moveToElement(frontimg)
				.click();
		        series.perform();
		Thread.sleep(5000);
		
		uploadImg();
		Thread.sleep(5000);
								
		Actions builder1 = new Actions(driver);
		Actions series1 = builder1
						.moveToElement(backimg)
						.click();
						series1.perform();
	    Thread.sleep(5000);	
		uploadImgBack();										        
	    Thread.sleep(5000);
		
	}
	
public void uploadFrontAndBackImagePortIN() throws InterruptedException, AWTException {
		
		WebElement backimg = driver.findElement(backImage);
		WebElement frontimg = driver.findElement(fimg);
		Thread.sleep(5000);
        	frontimg.click();
	
		Actions builder = new Actions(driver);
		Actions series = builder
				.moveToElement(frontimg)
				.click();
		        series.perform();
		Thread.sleep(5000);
		
		uploadImgBack();
		Thread.sleep(5000);
								
		Actions builder1 = new Actions(driver);
		Actions series1 = builder1
						.moveToElement(backimg)
						.click();
						series1.perform();
	    Thread.sleep(5000);	
		uploadImgBack();										        
	    Thread.sleep(5000);
		
	}
public void uploadImg() {
	
	File file = new File("/Users/sumitkumar/Desktop/Screenshots/Screenshot.png");
	 
	StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
	 
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	 
	try {
		robot = new Robot();
	} catch (AWTException e) {
		e.printStackTrace();
	}
	
	// Cmd + Tab is needed since it launches a Java app and the browser looses focus
	
	
	/*robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.delay(5000);*/
	 
	//Open Goto window
	 
	robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_SHIFT);
	robot.keyPress(KeyEvent.VK_G);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_SHIFT);
	robot.keyRelease(KeyEvent.VK_G);
	robot.delay(1000);
	
	//Paste the clipboard value
	 
	robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_V);
	robot.delay(1000);
	//Press Enter key to close the Goto window and Upload window
	 
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.delay(1000);
	
	robot.keyPress(KeyEvent.VK_ENTER); 
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.delay(1000);
	
	//Switching focus
	robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.delay(500);
	
	
	
}

public void uploadImgBack() {
	
	File file = new File("/Users/sumitkumar/Desktop/Screenshots/Screenshot.png");
	 
	StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
	 
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	 
	try {
		robot = new Robot();
	} catch (AWTException e) {
		e.printStackTrace();
	}
	
	// Cmd + Tab is needed since it launches a Java app and the browser looses focus
	
	
	robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.delay(5000);
	 
	//Open Goto window
	 
	robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_SHIFT);
	robot.keyPress(KeyEvent.VK_G);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_SHIFT);
	robot.keyRelease(KeyEvent.VK_G);
	robot.delay(1000);
	
	//Paste the clipboard value
	 
	robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_V);
	robot.delay(1000);
	//Press Enter key to close the Goto window and Upload window
	 
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.delay(1000);
	
	robot.keyPress(KeyEvent.VK_ENTER); 
	robot.keyRelease(KeyEvent.VK_ENTER);
	robot.delay(1000);
	
	//Switching focus
	robot.keyPress(KeyEvent.VK_META);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.keyRelease(KeyEvent.VK_META);
	robot.keyRelease(KeyEvent.VK_TAB);
	robot.delay(500);
	
	
	
}


public void readDeliveryExcel(String filePath, String fileName, String sheetName) throws IOException{
		
		File file = new File(filePath+"//"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook readWorkbook = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		if(fileExtensionName.equals(".xlsx")){

		     readWorkbook = new XSSFWorkbook(inputStream);

		    }
		
		else if(fileExtensionName.equals(".xls")){

	         readWorkbook = new HSSFWorkbook(inputStream);
	    }
		
		Sheet readSheet = readWorkbook.getSheet(sheetName);
		
		//Read data from excel sheet cell by cell	
		String fullName1 = readSheet.getRow(1).getCell(0).getStringCellValue();
		Double contactNumber1 = readSheet.getRow(1).getCell(1).getNumericCellValue();
		Double postalCode1 = readSheet.getRow(1).getCell(2).getNumericCellValue();
		String houseNo1 = readSheet.getRow(1).getCell(3).getStringCellValue();
		String streetName1 = readSheet.getRow(1).getCell(4).getStringCellValue();
		String nirc1 = readSheet.getRow(1).getCell(5).getStringCellValue();
		driver.findElement(fullName).sendKeys(fullName1);
		driver.findElement(contactNmber).sendKeys(contactNumber1.toString());
		selectDob();
		driver.findElement(postalCode).sendKeys(postalCode1.toString());
		driver.findElement(houseNo).sendKeys(houseNo1);
		driver.findElement(streetName).sendKeys(streetName1);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement id = driver.findElement(idType);
		Select dropdownIdType = new Select(id);
		dropdownIdType.selectByIndex(1);
		driver.findElement(nic).sendKeys(nirc1);
		
					
	}

   

    public void readDeliveryAddress(String filePath, String fileName, String sheetName) throws IOException{
    	
    	File file = new File(filePath+"//"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook readWorkbook = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		if(fileExtensionName.equals(".xlsx")){

		     readWorkbook = new XSSFWorkbook(inputStream);

		    }
		
		else if(fileExtensionName.equals(".xls")){

	         readWorkbook = new HSSFWorkbook(inputStream);
	    }
		
		Sheet readSheet = readWorkbook.getSheet(sheetName);
		
		Double postalCodeDelivery = readSheet.getRow(1).getCell(6).getNumericCellValue();
		String houseNo1 = readSheet.getRow(1).getCell(7).getStringCellValue();
		String streetName1 = readSheet.getRow(1).getCell(8).getStringCellValue();
		driver.findElement(pcDelivery).sendKeys(postalCodeDelivery.toString());
		driver.findElement(hsDelivery).sendKeys(houseNo1);
		driver.findElement(snDelivery).sendKeys(streetName1);
		
    	
    }

	public void enterDeliveryInfo() throws InterruptedException, AWTException, IOException {
		
		String filePath = System.getProperty("user.dir")+"//src//test//resources";
		readDeliveryExcel(filePath, "ReadExcel.xlsx", "DeliverySheet");
		
		robot = new Robot();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		/*robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(5000);*/
		
		/*robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		robot.delay(1000);*/
		Thread.sleep(2000);
		
		driver.findElement(delivaryDay).click();
		Thread.sleep(3000);
		driver.findElement(deliveryTime).click();
		Thread.sleep(3000); 
        
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

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);


		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

        uploadFrontAndBackImage();
		Thread.sleep(3000);
	    driver.findElement(sceureCheckOut).click();
	}
	
	public void enterPortInDeliveryInfo() throws InterruptedException, AWTException, IOException{
		
		String filePath = System.getProperty("user.dir")+"//src//test//resources";
		readDeliveryExcel(filePath, "ReadExcel.xlsx", "DeliverySheet");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(delivaryDay).click();
		Thread.sleep(3000);
		driver.findElement(deliveryTime).click();
		Thread.sleep(3000);
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
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		Thread.sleep(3000);
        driver.findElement(portIncheck).click();
        uploadFrontAndBackImage();
		Thread.sleep(3000);
	    driver.findElement(sceureCheckOut).click(); 
		
	}
	
	public void deliveryAddress() throws InterruptedException, AWTException, IOException{
		String filePath = System.getProperty("user.dir")+"//src//test//resources";
		readDeliveryExcel(filePath, "ReadExcel.xlsx", "DeliverySheet");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(delivaryDay).click();
		Thread.sleep(3000);
		driver.findElement(deliveryTime).click();
		Thread.sleep(3000); 
		driver.findElement(deliveryAddrress).click();
		/*Robot robot = new Robot();
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
		robot.delay(1000);*/

		Thread.sleep(3000);
		
		readDeliveryAddress(filePath, "ReadExcel.xlsx", "DeliverySheet");
		Thread.sleep(2000);
		
		Robot robot1 = new Robot();
		
		robot1.keyPress(KeyEvent.VK_META);
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyRelease(KeyEvent.VK_META);
		robot1.keyRelease(KeyEvent.VK_TAB);
		robot1.delay(5000);
        driver.findElement(onPage).click();
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
		robot1.delay(1000);

		uploadFrontAndBackImage();
		Thread.sleep(3000);
	    driver.findElement(sceureCheckOut).click(); 
		
		
	}
	
public void enterDeliveryInfoDevice() throws InterruptedException, AWTException, IOException {
		
		robot = new Robot();
	    //driver.findElement(onPage).click();
		/*String filePath = System.getProperty("user.dir")+"//src//test//resources";
		readDeliveryExcel(filePath, "ReadExcel.xlsx", "DeliverySheet");*/
	    
	    driver.findElement(fullName).sendKeys("fullName");
		driver.findElement(contactNmber).sendKeys("88776543");
		selectDob();
		//driver.findElement(onPage).click();
		Thread.sleep(3000);
		/*robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(5000);
       // driver.findElement(onPage).click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);


		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);*/

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("html body div#root div div div#st-container.st-container.st-effect-3 div.st-pusher div.st-content div span div.container div.row div.col-lg-12.col-md-12.col-sm-12.col-xs-12 div div div.container-fluid div div div.container-fluid div.row div.col-xs-12 div div input.form-control")));
		
		driver.findElement(pcc).sendKeys("119077");
		driver.findElement(hsn).sendKeys("13B");
		driver.findElement(stn).sendKeys("Main_road");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement id = driver.findElement(idType);
		Select dropdownIdType = new Select(id);
		dropdownIdType.selectByIndex(1);
		driver.findElement(nic).sendKeys("S1467255I");		
		Thread.sleep(3000);
		Thread.sleep(2000);
		
		driver.findElement(delivaryDay).click();
		Thread.sleep(3000);
		driver.findElement(deliveryTime).click();
		Thread.sleep(3000); 
        
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)", "");
		
		/*
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

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);


		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.delay(1000);
		*/

        uploadFrontAndBackImagePortIN();       
		Thread.sleep(3000);
	    driver.findElement(sceureCheckOut).click();
	}

	
	
}