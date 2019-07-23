package com.crm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//We have to define Page factory or Object Repository for Login page
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]//parent::a[@class='navbar-brand']")
	WebElement crmLogo;
	
	@FindBy(xpath="//div[@class='intercom-author-summary-name-from']")
	WebElement alertText;
	
	@FindBy(xpath="//div[contains(@class,'intercom-chat-card-author')]")
	WebElement chatBoxAlert;
	
	//initilizing the page objects using the PageFactory class with method initElements()
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Actions we are defining in the Login page
	
	public String validateLoginTitlePage() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
//		boolean chatBox = chatBoxAlert.isDisplayed();
//		Thread.sleep(2000);
//		if(chatBox) {
//			driver.switchTo().frame("intercom-borderless-frame");
//			Actions action = new Actions(driver);
//			action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
//			driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
//		}
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
//	public Alert cancelAlertBox() {
//		Alert alert = driver.switchTo().alert();
//		//alert.dismiss();
//		return alert;
//	}
	
	
}
