package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homepage;
	
	LoginPageTest(){
		super();
		//Doubt: why we can't create login object here..if we create object here the test cases are failing.
		//loginPage = new LoginPage();
	}
	
	@BeforeMethod
	public void setUp() {
		//propertiesLoad();
		initilization();
		//If we create the login object here then the test cases are passing.
		 loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String titleLogin = loginPage.validateLoginTitlePage();
		Assert.assertEquals(titleLogin, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void loginCrmLogoTest() {
		boolean logoImg = loginPage.validateCRMImage();
		Assert.assertTrue(logoImg);
	}
	
	@Test(priority=3)
	public void loginTest() {
		 homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
