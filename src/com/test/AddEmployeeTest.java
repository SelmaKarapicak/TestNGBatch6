package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.AddEmployeePageElements;
import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {
	
//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//	}
//	@AfterMethod
//	public void closeBrowser() {
//     	tearDown();
//	}
	
	@Test
	public void addEmployeePage() {

		//LoginPageElements login = new LoginPageElements();
		
		login.login();

//		login.username.sendKeys(ConfigsReader.getProperty("username"));
//		login.password.sendKeys(ConfigsReader.getProperty("password"));
//		login.loginBtn.click();
        
		//DashBoardPageElements board = new DashBoardPageElements();

		dashboard.PIM.click();
		jsClick(dashboard.addEmp);

		//AddEmployeePageElements emp1 = new AddEmployeePageElements();
		
		addEmp.employeeDetails("Selma","Acar" );
		
		//dashboard.navigateToAddEmployee();
		//wait(7);

		//add assertion to verify that employee has been added successfully

		//2.way
//		sendText(emp1.empFirstname, ConfigsReader.getProperty("employeeFirstname"));
//		sendText(emp1.empLastname, ConfigsReader.getProperty("employeeLastname"));
//		sendText(emp1.uploadpic, ConfigsReader.getProperty("filePath"));
//		click(emp1.save);

	}
	
	

}
