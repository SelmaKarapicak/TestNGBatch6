package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;

/* Open Application
 * Verify Logo is displayed
 * Enter valid credentials
 * Verify user succesfully logged in
 */
public class SoftAssertionDemo extends CommonMethods{
	
	@BeforeMethod
	public void open() {
		setUp();
	}
	
	@Test
	public void logoAndLogin() {
		boolean logoDisplayed=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logoDisplayed=false;
		
		//Hard Assert will fail and execution will stop at that point
		//Assert.assertTrue(logoDisplayed,"Logo is NOT displayed");
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is NOT displayed");
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username, "Admin");
		WebElement password=driver.findElement(By.id("txtPassword"));
		sendText(password, "Hum@nhrm123");
		click(driver.findElement(By.id("btnLogin")));
		
		boolean welcomeDisplayed=driver.findElement(By.id("welcome")).isDisplayed();
		//Assert.assertTrue(welcomeDisplayed);  ---> hard assertion
		softAssert.assertTrue(welcomeDisplayed, "welcome element is NOT displayed");
		softAssert.assertAll(); //bunu koymazsan failure olanlari gostermiyor en sonuna mutlaka koymalisin ! to show all failures
	}
	
	@AfterMethod
	public void close() {
		tearDown();
	}
	
	

}
