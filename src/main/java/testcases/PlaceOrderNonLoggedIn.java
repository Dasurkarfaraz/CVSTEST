package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseUtil.testclass;
import library.utility;

public class PlaceOrderNonLoggedIn extends testclass{
	
	@Test
	public void Home_Page() throws InterruptedException, IOException {
		ExtentTest test1 = extent.createTest("MyFirstTest").log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		
		test1.log(Status.INFO, "HIt the URL");
		driver.get("www.google.com");
		JavascriptExecutor j = (JavascriptExecutor) driver;
      j.executeScript("window.scrollBy(0,700)");
		new WebDriverWait(driver, 30L).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='product-image-photo'])[1]")));
      driver.findElement(By.xpath("(//a[@class='action tocart primary new_add_to_cart magnetoAddcart-2680'])[1]")).click();
      Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='product-image-photo'])[1]")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.xpath("//div[@class='member_block']")).isDisplayed());
      Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='price'])[1]")).isDisplayed());
		starttime = System.currentTimeMillis();
		Thread.sleep(3000l);
		endtime = System.currentTimeMillis();
		reponsetime = (endtime-starttime)/1000.0;
		System.out.println(reponsetime);
	}
	
	@Test(dependsOnMethods = {"Home_Page"})
	public void Select_Item_Page() throws InterruptedException {
		starttime = System.currentTimeMillis();
		Thread.sleep(2000l);
		endtime = System.currentTimeMillis();
		reponsetime = (endtime-starttime)/1000.0;
		System.out.println(reponsetime);
//		JavascriptExecutor j = (JavascriptExecutor) driver;
//        j.executeScript("window.scrollBy(0,700)");
//		new WebDriverWait(driver, 30L).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='product-image-photo'])[1]")));
//        driver.findElement(By.xpath("(//a[@class='action tocart primary new_add_to_cart magnetoAddcart-2680'])[1]")).click();
//        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='product-image-photo'])[1]")).isDisplayed());
////        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='member_block']")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='price'])[1]")).isDisplayed());
	}

}