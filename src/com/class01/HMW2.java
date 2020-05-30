package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
//Leave password empty 
//HRMS Application Negative Login

public class HMW2 extends CommonMethods{

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}
	
	@Test
	public void loginAndValidate() {
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username, "Admin");
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		sendText(password, "");
		
		click(driver.findElement(By.id("btnLogin")));
		
		WebElement errorMessage=driver.findElement(By.xpath("//span[@id='spanMessage']"));
		if(errorMessage.isDisplayed()) {
			System.out.println("Error message is displayed, Test case is passed");
		}else {
			System.err.println("Error message is not displayed, test case is failed");
		}	
	}
	
	@AfterMethod
	public void close() {
		//tearDown();
	}
}
