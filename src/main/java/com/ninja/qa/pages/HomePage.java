package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountLink;
	
	@FindBy(linkText="Register")
	private WebElement RegisterLink;
	
	@FindBy(linkText="Login")
	private WebElement LoginLink;
	
	public HomePage(WebDriver driver) {
	this.driver = driver;	
	PageFactory.initElements(driver, this);
	}
	
	public void ClickMyAccountLink() {
		MyAccountLink.click();
	}
	
	public void SelectRegisterLink() {
		RegisterLink.click();
	}
	
	public void SelectLoginLink() {
		LoginLink.click();
	}
}
