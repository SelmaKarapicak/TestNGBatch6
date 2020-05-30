package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class LoginPageElements extends CommonMethods {

	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(name="txtPassword")
	public WebElement password;
	
	@FindBy(css="input#btnLogin")
	public WebElement loginBtn;
	
	@FindBy(xpath="//div[@div='divLogo']/img")
	public WebElement logo;
	
	@FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	@FindBy(id="spanMessage")
	public WebElement errorMessage;
	
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	//if we would be keeping elements as private 
	//then we will need to create public getters and setters
	//so we can access page elements from test classes
	
//	//setter
//	public void sendUsername(String uid) {
//		sendText(username,uid);
//	}
//	//getter
//	public WebElement getUsername() {
//		return username;
//	}
	
	public void login() {
		sendText(username, ConfigsReader.getProperty("username") );     // Configden de alabilirsin username ve password
		sendText(password, ConfigsReader.getProperty("password"));
		click(loginBtn);
	}
	
	public void loginpar(String uid,String pwd) {
		sendText(username, uid ); 
		sendText(password, pwd);
		click(loginBtn);
	}
	

}
