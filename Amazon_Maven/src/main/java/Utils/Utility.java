package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;

public class Utility {

 
	
	public static String getDataFromExcelSheetn(String FilePath,String sheet,int row,int column) throws EncryptedDocumentException, IOException 
	{
		String value="";
		
		InputStream file = new FileInputStream(FilePath);
		
		 Workbook workbook = WorkbookFactory.create(file);
		 Cell cell=workbook.getSheet(sheet).getRow(row).getCell(column);
		 
			 
			 try 
			 {
				 value =cell.getStringCellValue();
				 
			 }
			 
			 
			 catch(IllegalStateException e)
			 {
				 double doubleValue =cell.getNumericCellValue();
				 
				 
				  value = String.valueOf(doubleValue);
			 }
			 
			 catch(NullPointerException e)
			 {
				 System.out.println("no data ");
			 }
		 
		 
		
		 return value;
	}
	
	

	
	public static void captureScreenshot(String TestID) throws IOException
	{ 
	WebDriver driver=new ChromeDriver();
//	TakesScreenshot ts = (TakesScreenshot) driver;
//	   File src = ts.getScreenshotAs(OutputType.FILE);
	
	WebDriver augmentedDriver = new Augmenter().augment(driver);
    File screenshot = ((TakesScreenshot)augmentedDriver).
                        getScreenshotAs(OutputType.FILE);
	   //File src = ts.getScreenshotAs(OutputType.FILE);
		   File dest = new File("test-output\\FailedTestScreenshot\\Test "+TestID+" "+Time()+".jpg");
		   FileHandler.copy(screenshot, dest);
	}
	   
	   
	   
	  
	public static String Time()
	{
		return new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
	}


	}

	












