package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class LoginTest extends CommonMethods{
	
//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//	
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}
	
	@Test
	public void validAdminLogin() {
		//LoginPageElements login=new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		//DashBoardPageElements db=new DashBoardPageElements();
		String expectedUser="Welcome Admin";
		String actualUser=dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));	
	}
	
	@Test
	public void invalidPasswordLogin() {
		//LoginPageElements login=new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.loginBtn);
		
		String expected="Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text is not matched");	
	}
	
	@Test
	public void emptyUsernameLogin() {
		//LoginPageElements login=new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected = "User name cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message is not matched ");
	}

}
