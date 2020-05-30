package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

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

public class AddRecruitment {
	
	@FindBy(xpath="//a[@id='menu_recruitment_viewRecruitmentModule']")
	public WebElement recruitment;
	
	@FindBy(id="menu_recruitment_viewCandidates")
	public WebElement candidates;
	
	@FindBy(id="btnAdd")
	public WebElement add;
	
	@FindBy(name="addCandidate[firstName]")
	public WebElement firstName;
	
	@FindBy(name="addCandidate[lastName]")
	public WebElement lastName;
	
	@FindBy(name="addCandidate[email]")
	public WebElement email;
	
	@FindBy(xpath="//select[@id='addCandidate_vacancy']")
	public WebElement vacancy;
	
	@FindBy(id="addCandidate_resume")
	public WebElement resume;
	
	@FindBy(xpath="//img[@class='ui-datepicker-trigger']")
	public WebElement dateOfApplication;
	
	@FindBy(id="btnSave")
	public WebElement save;
	
	@FindBy(xpath="//a[@href='https://syntaxtechs.com']/img")
	public WebElement logo;
	
	public AddRecruitment() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
