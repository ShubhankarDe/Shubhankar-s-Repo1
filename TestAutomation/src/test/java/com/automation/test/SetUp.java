package com.automation.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.pageObjects.LoginPage;
import com.automation.utilities.PropertiesFile;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SetUp {
	
public static WebDriver driver;
	
	static LoginPage loginPageobj;
	
	public static Actions action;
	public static String message = "";
	FileOutputStream fop = null;
	File file;
	public static byte[][] screenshotsArray = new byte[10][10000];
	public static Date date;
	public static String BrowserName = "";
	public static Properties data = null;
	
	@Before	public static void setupTest() throws Exception
	{
		data =PropertiesFile.readPropertiesFile();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/exe/chromedriver.exe" );
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--allow-insecure-websocket-from-https-origin");
		options.addArguments("disable-extensions");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver =  new ChromeDriver(cap);
		
		
		loginPageobj = PageFactory.initElements(driver, LoginPage.class);
	
		
		
		driver.get(data.getProperty("URL"));
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		action = new Actions(driver);
		
		Capabilities cap1 = ((RemoteWebDriver) driver).getCapabilities();
		BrowserName = cap1.getBrowserName().toLowerCase();
		
		System.out.println("BrowserName == "+BrowserName);
		
	}
	
	
	@After
	public static void tearDown(Scenario result) throws Exception
	{
		if(result.isFailed()){
			result.write(result.toString());
			result.write(result.getStatus());
			result.write("ScreenShot taken for failed step ");
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			result.write(message);
			result.embed(screenshot, "image/png");
		}
		result.write(message);
		driver.close();
		driver.quit();
		
	}

}