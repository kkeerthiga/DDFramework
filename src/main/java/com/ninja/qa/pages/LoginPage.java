package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement EmailField;
	
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterEmail(String emailText) {
		EmailField.sendKeys(emailText);
	}
	
	public void EnterPassword(String PasswordText) {
		PasswordField.sendKeys(PasswordText);
	}
	
	public void ClickOnLoginButton() {
		LoginButton.click();
	}
}
