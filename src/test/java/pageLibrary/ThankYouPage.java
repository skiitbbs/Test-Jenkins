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


public class ThankYouPage {
	
	WebDriver driver;
	
	By orderId = By.xpath("html/body/div[3]/div/div/div[1]/div/div/div[2]/span/div/div/div[2]/div/div/div/div/div[4]/div/span[2]");
	By orderNumber = By.cssSelector(".row:nth-child(2) .col-xs-12 div div div div:nth-child(4) div span:nth-child(2)");
	
	
	public ThankYouPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void writeOrderInExcel(String filePath,String fileName,String sheetName,String dataToWrite) throws IOException{
		
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
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		writeExcel.write(outputStream);
		outputStream.close();
		

	}
	
	
	public void getOrderId() throws IOException {
		
		String order = driver.findElement(orderNumber).getText();
		writeOrderInExcel(System.getProperty("user.dir")+"//src//test//resources","WriteExcel.xlsx","OrderDetails",order);
	}

}
