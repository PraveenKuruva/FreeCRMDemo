package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventListener;
	
		public TestBase() {
			try {
				prop = new Properties();
				FileInputStream fis = new FileInputStream("D:\\Workspace\\EcllipseWorkspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
				prop.load(fis);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
//		public static void propertiesLoad() {
//			try {
//				prop = new Properties();
//				FileInputStream fis = new FileInputStream("D:\\Workspace\\EcllipseWorkspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
//				prop.load(fis);
//			}catch(FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		public static void initilization() {
			
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Java\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "D:\\Selenium-Java\\geckodriver.exe");
				driver = new FirefoxDriver();

			}
			
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListner();
			e_driver.register(eventListener);
			driver = e_driver;
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
