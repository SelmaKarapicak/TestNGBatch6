package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class AddEmployee {
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement PIM;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmployee;
	
	@FindBy(xpath="//label[@class='hasTopFieldHelp']")
	public WebElement fullName;
	
	 @FindBy(xpath = "//label[contains(text(),'Employee Id')]")
	 public WebElement employeeId;
	 
	 @FindBy(xpath = "//label[contains(text(),'Photograph')]")
	 public WebElement photograph;
	
	@FindBy(id="firstName")
	public WebElement firstName;
	 
	@FindBy(id="lastName")
	public WebElement lastName;

	@FindBy(id="employeeId")
	public WebElement empId;
	
	@FindBy(id="photofile")
	public WebElement uploadPhoto;
	
	@FindBy(id="btnSave")
	public WebElement save;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement verifyEmployee;
	
	public AddEmployee() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	
}



