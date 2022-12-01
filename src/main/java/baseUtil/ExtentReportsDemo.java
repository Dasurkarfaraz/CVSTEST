package baseUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	ExtentSparkReporter spark;
	protected ExtentReports extent;
	String todayday ;

	@BeforeSuite
	public void reportSetup() {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		   LocalDateTime now2 = LocalDateTime.now();
		  todayday = dtf2.format(now2);
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark"+ todayday +".html");
		extent.attachReporter(spark);
		
		

	}

	@AfterSuite
	public void reportTeardown() {
	  extent.flush();
	
	 }
}