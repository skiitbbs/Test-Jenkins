package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PreCheckoutPage {

	WebDriver driver;
	
	By secureCheckout = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/footer/div/div/div/a");
	By takeNumber = By.cssSelector(".col-lg-12 .hidden-small-device .row:nth-child(2) .col-xs-8 > span");
	
	public PreCheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnSecureCheckout() {
		
		driver.findElement(secureCheckout).click();
	}
	
	public void writeNumberInExcel(String filePath,String fileName,String sheetName,String dataToWrite) throws IOException{
		
		File file = new File(filePath+"//"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook writeExcel = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if(fileExtensionName.equals(".xlsx")){

	       
	        writeExcel = new XSSFWorkbook(inputStream);

	        }

	       
	        else if(fileExtensionName.equals(".xls")){

	          writeExcel = new HSSFWorkbook(inputStream);

	        }
		
		Sheet OrderDetails = writeExcel.getSheet(sheetName);
		int rowCount = OrderDetails.getLastRowNum()-OrderDetails.getFirstRowNum();
		Row row = OrderDetails.getRow(1);
		Row newRow = OrderDetails.createRow(rowCount+1);
		Cell cell = newRow.createCell(0);
		
		cell.setCellValue(dataToWrite);
		/*for(int j = 0; j < row.getLastCellNum(); j++){

	        Cell cell = newRow.createCell(j);

	        cell.setCellValue(dataToWrite);
	    }*/
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		writeExcel.write(outputStream);
		outputStream.close();
		

	}
	
	public void getNumber() throws IOException {
		String number = driver.findElement(takeNumber).getText();
		//System.out.println(number);
		writeNumberInExcel(System.getProperty("user.dir")+"//src//test//resources","WriteExcel.xlsx","OrderDetails",number);
		
	}
	
}
