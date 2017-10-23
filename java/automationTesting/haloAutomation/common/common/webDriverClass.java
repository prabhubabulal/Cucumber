package automationTesting.haloAutomation.common.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import automationTesting.haloAutomation.pageFactory.Frames;

public class webDriverClass {
	public static WebDriver driver;
	public static WebDriver bConnectedDriver;
	public static String appUsername;
	public static String appPassword;
	public static String appDomain;
	public static String appURL;
	public static String appCMSProperty;
public static WebDriver getDriver(String browserType,String url){
	File file = new File("src\\test\\java\\resources\\config\\haloApp-UAT.properties");
	FileInputStream fileInput = null;
	try {
		fileInput = new FileInputStream(file.getAbsolutePath());
		System.out.println("Application Properties File Path : "+file.getAbsolutePath());
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties prop = new Properties();

	//load properties file
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	if(url.equalsIgnoreCase("Halo")) {
		appURL = prop.getProperty("app.url");	
	}else {
		appURL = prop.getProperty("app.bconnectedURL");
	}
	
	appUsername = prop.getProperty("app.UserName");
	appPassword = prop.getProperty("app.Password");
	appDomain = prop.getProperty("app.Domain");
	appCMSProperty = prop.getProperty("app.CMS");
	
	if(browserType.equals("ie")){
//		  System.setProperty("webdriver.ie.driver", "src\\test\\resources\\Installables\\IEDriverServer2.53.2.exe");
		  System.setProperty("webdriver.ie.driver", "src\\test\\IEDriverServer.exe");				  
		  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		  capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		  capabilities.setCapability("requireWindowFocus", true);
		  capabilities.setCapability("ignoreZoomSetting", true);
		  capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,appURL);

		  capabilities.setJavascriptEnabled(true);		  
		  capabilities.setCapability("unexpectedAlertBehaviour", "accept");
		  capabilities.setCapability("ignoreProtectedModeSettings", true);
		  capabilities.setCapability("disable-popup-blocking", true);
		  capabilities.setCapability("enablePersistentHover", true);

		  if(url.equalsIgnoreCase("Halo")) {
			  driver = new InternetExplorerDriver(capabilities);
			  driver.manage().window().maximize();
			  return driver;	
			}else {
				 bConnectedDriver = new InternetExplorerDriver(capabilities);
				 bConnectedDriver.manage().window().maximize();
				  return bConnectedDriver;
			}
		  
		 
	}else if(browserType.equalsIgnoreCase("Chrome")){
		  System.setProperty("webdriver.chrome.driver", "src\\test\\chromedriver.exe");		 
		  if(url.equalsIgnoreCase("Halo")) {
			  driver = new ChromeDriver();
			  driver.get(appURL);
			  driver.manage().window().maximize();
			  return driver;	
			}else {
				  bConnectedDriver = new ChromeDriver();
				  bConnectedDriver.get(appURL);
				  bConnectedDriver.manage().window().maximize();
				  return bConnectedDriver;
			}
		  
	}else if(browserType.equalsIgnoreCase("edge")){
		 System.setProperty("webdriver.edge.driver", "src\\test\\resources\\Installables\\MicrosoftWebDriver.exe");
		 driver = new EdgeDriver();
		 driver.get(appURL);
		  driver.manage().window().maximize();
		  return driver;
	}else{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
}

public static WebDriver switchDriver(String frameID) throws InterruptedException{
	Thread.sleep(1000);
	driver.switchTo().frame(frameID);	
	return driver;
}

public static WebDriver switchDriver() throws InterruptedException{
	Thread.sleep(1000);
	driver.switchTo().defaultContent();
	return driver;
	
}
}
