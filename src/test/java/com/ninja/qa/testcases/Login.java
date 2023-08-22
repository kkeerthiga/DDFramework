 package com.ninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninja.qa.base.Base;
import com.ninja.qa.pages.AccountPage;
import com.ninja.qa.pages.HomePage;
import com.ninja.qa.pages.LoginPage;
import com.ninja.qa.utils.Utils;

public class Login extends Base {

	public Login() {
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod 
	public void setup() {
		LoadPropertiesValue();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homepage = new HomePage(driver);
		homepage.ClickMyAccountLink();
		homepage.SelectLoginLink();
		
	}
	
	@DataProvider(name="ValidCredentials")
	public Object[][] supplyData(){
		
		Object[][] data = Utils.getTestDataFromExcel("Login");
		return data;
		
	}
	
	@Test
	public void verifyLoginWithValidCredentials() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.EnterEmail("validEmail");
		loginpage.EnterPassword("validPassword");
		loginpage.ClickOnLoginButton();
	
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
	} 
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
