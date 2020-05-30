package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class AssertionsDemo extends CommonMethods{
	
	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}
	
	 @Test(priority=1)
		public void titleValidation()  {
		 System.out.println("Executong title validation test case==========");
			String expectedTitle = "Human Managements Systems";
			String actualTitle = driver.getTitle(); //Human Management System
			Assert.assertEquals(actualTitle, expectedTitle,"Titles are matched");
	 }
	 
	@Test(enabled=true)
	public void loginAndValidate() {
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username, "Admin");
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		sendText(password, "Hum@nhrm123");
		
		click(driver.findElement(By.id("btnLogin")));
	}
		
		@Test(priority=2)
		public void logoValidation() {
		boolean isDisplayed=driver.findElement(By.xpath("//a[@href='https://syntaxtechs.com']/img")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Syntax logo is displayed");
		
		//using if condition we cannot make testNG test failes!
//		if (isDisplayed) {
//			System.out.println("logoValidation passed");
//		} else {
//			System.out.println("logoValidation failed");
//		}
	}
	
	
	@AfterMethod
	public void close() {
		//tearDown();
	}

}
