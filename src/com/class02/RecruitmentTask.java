package com.class02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

//Open chrome browser
//2. Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//3. Login into the application and verify syntax logo 
//4. Click on Recruitments --> candidates
//5. click on Add button 
//verify labels: full name, email, job vacancy, resume 
//6. provide info for firstname,lastname,email,jobVacancy
//7. chooseFile and upload a proper fit file
//8. Verify if the file has been uploaded succesfully
//9. Close the browser

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.AddRecruitment;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class RecruitmentTask extends CommonMethods {
	
	@BeforeMethod
	public void open() {
		setUp();
	}
	
	@AfterMethod
	public void close() {
	//	tearDown();
	}
	
//	@Test(priority=1)
//	public void Login() {
//	LoginPageElements login=new LoginPageElements();
//	sendText(login.username,ConfigsReader.getProperty("username"));
//	sendText(login.password,ConfigsReader.getProperty("password"));
//	click(login.loginBtn);
//	}
	
	@Test
	public void addCandidates() {	
		
		LoginPageElements login=new LoginPageElements();
		sendText(login.username,ConfigsReader.getProperty("username"));
		sendText(login.password,ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
	AddRecruitment add=new AddRecruitment();
	//isDisplayed(add.logo);
	
	Actions action=new Actions(driver);
	action.moveToElement(add.recruitment).perform();
	click(add.candidates);
	click(add.add);
	
	sendText(add.firstName,"Selma");
	sendText(add.lastName,"Refia");
	sendText(add.email,"selma@gmail.com");
	
	Select select=new Select(add.vacancy);
	select.selectByIndex(0);
	
	String filePath="C:\\Users\\karap\\OneDrive\\Masaüstü\\picture.JPG";
	add.resume.sendKeys(filePath);
	
	click(add.dateOfApplication);
	
	WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	Select monthSelect=new Select(month);
	monthSelect.selectByValue("Mar");
	
	List<WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
	
	for (WebElement cell: cells) {
		String text=cell.getText();
		if(text.equals("9")) {
			cell.click();
			break;
		}	
	}
	
	wait(2);
	
	click(add.save);
	
	
	
	
		
	}
	

}
