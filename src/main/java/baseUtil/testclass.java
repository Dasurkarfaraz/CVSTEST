package baseUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.opencsv.CSVWriter;

import library.utility;


public class testclass extends ExtentReportsDemo{
	public WebDriver driver;
	public static long starttime;
	public static long endtime;
	public static double reponsetime;
	public static String ApplicationName  = "ASS VIDYALAYA";
	int count;
	int newValue;
	 
	@BeforeTest
	public void Launch() {
		System.setProperty(commons.cKey, commons.cPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@AfterMethod
	public void reponse(ITestResult result) throws IOException {
		
		String responseT = Double.toString(reponsetime);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String CurrentDate = dtf.format(now);
		String MethodName = result.getName();
		File src=new File("C:\\Users\\faraz\\eclipse-workspace\\CVSTEST\\ReportWithReponse\\data.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0); 
		int RowCount = sheet.getLastRowNum();
		int rowsum = RowCount+1;
		System.out.println(RowCount);
		System.out.println(rowsum);
		Row r =sheet.createRow(rowsum);
		sheet.getRow(rowsum).createCell(0).setCellValue(ApplicationName);
		sheet.getRow(rowsum).createCell(1).setCellValue(MethodName);
		sheet.getRow(rowsum).createCell(2).setCellValue(CurrentDate);
		if(ITestResult.SUCCESS==result.getStatus()) {
			sheet.getRow(rowsum).createCell(3).setCellValue(responseT);
		}
		if(ITestResult.FAILURE== result.getStatus() ) {
			utility.captureScreenshot(driver, result.getName());
			sheet.getRow(rowsum).createCell(4).setCellValue("E");	
			
		}

		FileOutputStream  FW = new FileOutputStream(src);
		workbook.write(FW);
		fis.close();
		System.out.println("in After method");
	}
	@AfterTest
	public void qi() {
		driver.quit();
	}
}