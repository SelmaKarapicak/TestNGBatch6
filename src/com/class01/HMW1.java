package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

//validate Syntax logo is displayed after you login

public class HMW1 extends CommonMethods{
	
	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}
	
	@Test
	public void loginAndValidate() {
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username, "Admin");
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		sendText(password, "Hum@nhrm123");
		
		click(driver.findElement(By.id("btnLogin")));
		
		WebElement logo=driver.findElement(By.xpath("//a[@href='https://syntaxtechs.com']/img"));
		if(logo.isDisplayed()) {
			System.out.println("Test case is passed, Syntax Logo displayed");
		}else {
			System.err.println("Logo is not displayed, test case is failed");
		}
	}
	
	@AfterMethod
	public void close() {
		//tearDown();
	}
	

}
