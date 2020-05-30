package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class PersonalDetailsPageElements {
	
	@FindBy(id="personal_cmbNation")
	WebElement nationalityDD;
	
	@FindBy(name="personal[optGender]") //radio button
	public List<WebElement> genderRadioGroup;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement verifyEmp;
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	

}
