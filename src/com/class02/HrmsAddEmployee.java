package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.AddEmployee;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class HrmsAddEmployee extends CommonMethods{
	
	@BeforeMethod
	public void open() {
		setUp();
	}
	
//	@Test(priority=1)
//	public void Login() {
//		LoginPageElements login=new LoginPageElements();
//		sendText(login.username, ConfigsReader.getProperty("username"));
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
//		
//		AddEmployee add=new AddEmployee();
//		Actions action=new Actions(driver);
//		action.moveToElement(add.PIM).perform();
//		click(add.addEmployee);
//		
//		isDisplayed(add.fullName);
//		isDisplayed(add.employeeId);
//		isDisplayed(add.photograph);
//	}
	
		@Test(priority=2)
		public void AddEmployee() {
		LoginPageElements login=new LoginPageElements();
			sendText(login.username, ConfigsReader.getProperty("username"));
			sendText(login.password, ConfigsReader.getProperty("password"));
			click(login.loginBtn);
			
			AddEmployee add=new AddEmployee();
			Actions action=new Actions(driver);
			action.moveToElement(add.PIM).perform();
			click(add.addEmployee);
			
			isDisplayed(add.fullName);
			isDisplayed(add.employeeId);
			isDisplayed(add.photograph);
			
		sendText(add.firstName,"Selma");
		sendText(add.lastName,"Karapicak");
		
		String filePath="C:\\Users\\karap\\OneDrive\\Masaüstü\\picture.JPG";
		add.uploadPhoto.sendKeys(filePath);
		
		wait(2);
		add.save.click();
		
		String expectedTitle = "Selma Karapicak";
        String actualTitle = add.verifyEmployee.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Employee has been successfully added");
        wait(1);
		
			
		}
		
		@AfterMethod
		public void close() {
			//tearDown();
		}
		
		
		
		
		
		
		
		
	}
		
		
		


