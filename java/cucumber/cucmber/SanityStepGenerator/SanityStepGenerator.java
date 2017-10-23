package cucumber.cucmber.SanityStepGenerator;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.datastax.driver.core.utils.Bytes;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.sun.jna.platform.win32.WinDef.BYTE;

import automationTesting.haloAutomation.common.FunctionalSpecific.adjustPlayerTierLevel;
import automationTesting.haloAutomation.common.FunctionalSpecific.bConnected;
import automationTesting.haloAutomation.common.FunctionalSpecific.loginClass;
import automationTesting.haloAutomation.common.FunctionalSpecific.playerEnrollment;
import automationTesting.haloAutomation.common.FunctionalSpecific.propertyPlayPopUp;
import automationTesting.haloAutomation.common.FunctionalSpecific.pushPlayerEnrollment;
import automationTesting.haloAutomation.common.FunctionalSpecific.search;
import automationTesting.haloAutomation.common.common.captureImage;
import automationTesting.haloAutomation.common.common.generateHTML;
import automationTesting.haloAutomation.common.common.webDriverClass;
import automationTesting.haloAutomation.common.common.webElementActionClass;
import automationTesting.haloAutomation.common.common.writeDataExcel;
import automationTesting.haloAutomation.variables.bConnectedVariables;
import automationTesting.haloAutomation.variables.haloVariables;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.Utils;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

public class SanityStepGenerator {
	public static WebDriver driver = null;
	public static WebDriver bConnectedDriver = null;
	public static Scenario scenario;
	public static String playerID;
	public static String LastPropertyPlayed;
	public static String currentTestCase;
	public static int passCount;
	public static int failCount;
	
	public static int enrollmentTCCount;
	public static int enrollmentPassCount;
	public static int enrollmentFailCount;
	
	public static int pushPlayerEnrollmentTCCount;
	public static int pushPlayerEnrollmentPassCount;
	public static int pushPlayerEnrollmentFailCount;
	
	public static int propertyPlayPopUpTCCount;
	public static int propertyPlayPopUpPassCount;
	public static int propertyPlayPopUpFailCount;
	
	public static int adjustPlayerEnrollmentTCCount;
	public static int adjustPlayerEnrollmentPassCount;
	public static int adjustPlayerEnrollmentFailCount;
	
	@After
	public static void aftertest() {
		try {
			driver.quit();
		}catch(Exception e) {}
		if(scenario.getName().equalsIgnoreCase("Enrollment")) {
			enrollmentTCCount = enrollmentTCCount + 1;
			if(scenario.getStatus().equalsIgnoreCase("Passed")) {				
				enrollmentPassCount = enrollmentPassCount + 1;
			}else if(scenario.getStatus().equalsIgnoreCase("Failed")) {
				enrollmentFailCount = enrollmentFailCount + 1;
			}
		}else if(scenario.getName().equalsIgnoreCase("Push Player Enrollment")) {
			pushPlayerEnrollmentTCCount = pushPlayerEnrollmentTCCount + 1;
			if(scenario.getStatus().equalsIgnoreCase("Passed")) {				
				pushPlayerEnrollmentPassCount = pushPlayerEnrollmentPassCount + 1;
			}else if(scenario.getStatus().equalsIgnoreCase("Failed")) {
				pushPlayerEnrollmentFailCount = pushPlayerEnrollmentFailCount + 1;
			}
		}else if(scenario.getName().equalsIgnoreCase("Property Play Pop Up")) {
			propertyPlayPopUpTCCount = propertyPlayPopUpTCCount + 1;
			if(scenario.getStatus().equalsIgnoreCase("Passed")) {				
				propertyPlayPopUpPassCount = propertyPlayPopUpPassCount + 1;
			}else if(scenario.getStatus().equalsIgnoreCase("Failed")) {
				propertyPlayPopUpFailCount = propertyPlayPopUpFailCount + 1;
			}
		}else if(scenario.getName().equalsIgnoreCase("Adjust Player Enrollment")) {
			adjustPlayerEnrollmentTCCount = adjustPlayerEnrollmentTCCount + 1;				
			if(scenario.getStatus().equalsIgnoreCase("Passed")) {					
				adjustPlayerEnrollmentPassCount = adjustPlayerEnrollmentPassCount + 1;
			}else if(scenario.getStatus().equalsIgnoreCase("Failed")) {
				adjustPlayerEnrollmentFailCount = adjustPlayerEnrollmentFailCount + 1;
			}
				}
		System.out.println("=============================");
		System.out.println("=============================");
		System.out.println("Scenario Status "+scenario.getId());
		System.out.println("Scenario Status "+scenario.getName());
		System.out.println("Scenario Status "+scenario.getStatus());
		System.out.println("Scenario Status "+scenario.getSourceTagNames());
		System.out.println("=============================");
		System.out.println("=============================");
		if(scenario.getStatus().equalsIgnoreCase("Passed")) {				
			System.out.println("Scenario Name :"+scenario.getName());
			passCount = passCount + 1;
		}else if(scenario.getStatus().equalsIgnoreCase("Failed")) {
			failCount = failCount + 1;
		}
	}
	
	
	 @Then("^Property play PopUp$")
	    public void getpropertyplayPopUp() {
	    	LastPropertyPlayed = propertyPlayPopUp.getpropertyPlayPopUp();
	    }
	
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@Given("^Test Case ID is \"(.*?)\"$")
	public void testCaseID(String tCaseID) {
		this.currentTestCase = tCaseID;
	}
	

	@Given("^Make initial setup$")
	  public void makeInitialSetup() {	
		  String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		  Date today = new Date();
		  String currentTime = today.getHours()+"-"+today.getMinutes()+"-"+today.getSeconds();
		  String datetime = currentDate+"-"+currentTime;
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
			
		  String appURL = prop.getProperty("app.url");
		  generateHTML.writeStartResults("Halo", datetime, "Prabhu Babulal", "UAT",webDriverClass.appUsername,appURL);
		  generateHTML.writeResults("E2E Testing", "", "", "");		  	
	  }
	
	@Given("^Create New Line of Test Result with \"(.*?)\", \"(.*?)\", \"(.*?)\" and \"(.*?)\"$")
	public void generateHTMLReport(String step, String result, String remarks, String image) {
		generateHTML.writeResults(step, result, remarks, image);
	}
	

	
	@Given("^Launch HALo url in \"(.*?)\" browser$")
	public void user_is_on_homepage(String browserType) {		
		  driver = webDriverClass.getDriver(browserType,"Halo");
	}
	
	@Given("^Launch BConnected url in \"(.*?)\" browser$")
	public void launchBConnected(String browserType) {	
		 try {
				bConnectedDriver = webDriverClass.getDriver(browserType,"Bconnected");
				Thread.sleep(1500);
				 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	@Then("^Enroll Player in BConnected$")
	public static void erollBConnectedPlayer() {
		try {		
		  List<WebElement> wElement = bConnectedDriver.findElements(By.xpath(bConnectedVariables.STARTHERE));
		  wElement.get(3).click();
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.CARDNUMBER)).sendKeys(playerID);
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.LASTNAME)).sendKeys(playerEnrollment.playerLastName);
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.DOBMonth)).sendKeys("January");				 
		  Thread.sleep(500);			
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.DOBDate)).sendKeys("1");
		  Thread.sleep(500);
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.DOBYear)).sendKeys("1975"); 		  
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.REGISTER)).click();
		  Thread.sleep(1000);		  
		  String UName = playerID+"Halo";
		  generateHTML.writeResults("BConnected User Credentials", "Pass", "User Name : "+UName+" and "
		  		+ "Password :"+playerID, captureImage.captureBConnected("bConnected"));
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.EMAIL)).sendKeys("test@test.com"); 
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.USERNAME)).sendKeys(UName); 
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.PASSWORD)).sendKeys(playerID); 
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.RETYPEPASSWORD)).sendKeys(playerID);
		  Thread.sleep(1000);
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.NEXT)).click();
		  Thread.sleep(1500);
		  WebDriverWait wait = new WebDriverWait(bConnectedDriver, 20);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bConnectedVariables.CRAPS)));
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.CRAPS)).click();
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.BLUES)).click();
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.ITALIAN)).click();		  
		  JavascriptExecutor jse = (JavascriptExecutor)bConnectedDriver;
		  jse.executeScript("window.scrollBy(0,350)", "");		  
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.GOLF)).click();
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.WEDDINGS)).click();
		  Thread.sleep(1500);
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.REGISTER)).click();
		  Thread.sleep(1000);
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.SUBMIT)).click();
		  Thread.sleep(1000);
		  bConnectedDriver.findElement(By.xpath(bConnectedVariables.LOGINASANOTHERUSER)).click();		  
		}catch(Exception e) {}
	}
	
	@When("^Login as \"(.*?)\" user$")
	public void login(String usertype) {
		String appUserName = "";
		String appPassword = "";
		if(usertype.toString().equalsIgnoreCase("IP")){
   		 appUserName = "qauser1";
   		 appPassword = "Password1";
	   	 }else if(usertype.toString().equalsIgnoreCase("SC")){
	   		 appUserName = "qauser4";	   		
	   		 appPassword = "Password1";
	   	 }else if(usertype.toString().equalsIgnoreCase("STLV")){
	   		 appUserName = "qauser7";
	   		 appPassword = "Password1";
	   	 }else if (usertype.toString().equalsIgnoreCase("BC")) {
	   		 appUserName = "BabulalP";
	   		 appPassword = "Bal667Pra";
	   	 }
		loginClass.login(appUserName, appPassword, "BCGDEV.Local");		
	}
	
	@When("^Number of Users \"(.*?)\"$")
	public static void noOfUsers(String noofUsers) {
		System.out.println(noofUsers);
	}

	
	@Then("^Check login sucessfull$")
	public static void msgdisplayed() {		
		try {
			Thread.sleep(1000);					
			if(driver.findElement(By.name("ctl00$txtPlayerId")).isDisplayed()) {
				 System.out.println("Login Successful");
			 }	
		}catch(Exception e) {}
		 
	}
			
	@Then("^Enroll (\\d+) \"(.*?)\" Player$")
	public static void enrollPlayer(int noOfPlayer, String playerType) {
		try {		
			String testCase = "";
			if(playerType.equalsIgnoreCase("Marketing")) {
				testCase = "TestCase_001";
			}else if(playerType.equalsIgnoreCase("NONUSCANADA")) {
				testCase = "TestCase_002";
			}else if(playerType.equalsIgnoreCase("TRANSPORTATION")) {
				testCase = "TestCase_003";
			}		
			
			for(int i=0;i<noOfPlayer;i++) {
				playerID = playerEnrollment.enrollPlayer(testCase);
				writeDataExcel.writeDataExcel(playerID);
				scenario.write("Player ID : "+playerID);
				TakesScreenshot camera = (TakesScreenshot) driver;
				byte[] screenshot = camera.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				
			}
		}catch(Exception e) {}
	}
	
	@Then("^Enroll \"(.*?)\" \"(.*?)\" Player$")
	public static void playerEnrollment(int noOfPlayer, String playerType) {		
		try {	
			String testCase = "";
			if(playerType.equalsIgnoreCase("Marketing")) {
				testCase = "TestCase_001";
			}else if(playerType.equalsIgnoreCase("NONUSCANADA")) {
				testCase = "TestCase_002";
			}else if(playerType.equalsIgnoreCase("TRANSPORTATION")) {
				testCase = "TestCase_003";
			}		
			
			for(int i=0;i<noOfPlayer;i++) {
				playerID = playerEnrollment.enrollPlayer(testCase);
				writeDataExcel.writeDataExcel(playerID);
				scenario.write("Player ID : "+playerID);
				TakesScreenshot camera = (TakesScreenshot) driver;
				byte[] screenshot = camera.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		}catch(Exception e) {}
		
	}
	
	@Then("^Adjust Player Tier level to \"(.*?)\" with lock type as \"(.*?)\"$")
	public static void playerTierLevelEnrolment(String tierLevel,String lockType) {
		adjustPlayerTierLevel.adjustPlayerTierLevel(playerID, tierLevel, lockType);
	}
	
	@Then("^Push Player to \"(.*?)\"$")
	public static void pushplayerEnrollment(String pushTo) {
		try {
			pushPlayerEnrollment.pushPlayer(playerID, pushTo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^Logout$")
	public static void logout() {
		driver.findElement(By.xpath(haloVariables.LOGOUT)).click();
	}
	
    @Then("^User close browser$")
    public static void closeBrowser() {
    	driver.quit();
    }
    
    @Then("^Update Account type in CMS Property :\"([^\"]*)\" and Player Type :\"([^\"]*)\"\"$")
    public static void updateAccountTypeInCMS(String property,String playerType) throws IOException {
    	 try {  
    		 String propertyName="";
    		 if(property.equals("IP")) {
    			 propertyName = "PROP5UAT";
    		 }else if(property.equals("SC")) {
    			 propertyName = "PROP6UAT";
    		 }else if(property.equals("STLV")) {
    			 propertyName = "PROP3UAT";
    		 }else if(property.equals("BC")) {
    			 propertyName = "PROP1UAT";
    		 }
    		 String cmd = "src\\test\\java\\automationTesting\\haloAutomation\\common\\common\\UpdateAccountType.vbs";
    		 Process p = Runtime.getRuntime().exec("wscript "+cmd+" "+propertyName+" " + playerID+" "+playerType);
		  	 p.waitFor();
		  	 Thread.sleep(10000);
		  	 search.appSearch(playerID);
		  	 if (driver.findElement(By.id(haloVariables.CREDITBUTTON)).isEnabled()) {
		  		 generateHTML.writeResults("Update Player in CMS", "Pass", "Player Change into "+playerType+" in "
		  		 		+ "HALo", captureImage.capture("playerUpdate"));
		  	 }else {
		  		generateHTML.writeResults("Player not updated in HALo", "Fail", "Player Failed to Change into "+playerType+" "
		  				+ "in HALo", captureImage.capture("playerUpdate"));
		  	 }
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		  
    }
    
@Given("^Final Report Generation$")    
public static void finalReportGeneration() throws Exception {
	String var = "";
	String Enrollvar = "['Enrollment',PASS,FAIL],";
	String AdjustPlayerEnrollvar = "['Adjust Player Tier Level',PASS,FAIL],";
	String PushPlayerEnrollmentVar = "['Push Player Enrollment',PASS,FAIL]";
	String PropertyPlayPopUpVar = "['Property Play Popup',PASS,FAIL]";
	if(enrollmentTCCount!=0) {
		Enrollvar = Enrollvar.replace("PASS", Integer.toString(enrollmentPassCount));
		Enrollvar = Enrollvar.replace("FAIL", Integer.toString(enrollmentFailCount));
		var = var + Enrollvar;
	}
	if(adjustPlayerEnrollmentTCCount!=0) {
		AdjustPlayerEnrollvar = AdjustPlayerEnrollvar.replace("PASS", Integer.toString(adjustPlayerEnrollmentPassCount));
		AdjustPlayerEnrollvar = AdjustPlayerEnrollvar.replace("FAIL", Integer.toString(adjustPlayerEnrollmentFailCount));
		var = var + AdjustPlayerEnrollvar;
	}
	
	if(pushPlayerEnrollmentTCCount!=0) {
		PushPlayerEnrollmentVar = PushPlayerEnrollmentVar.replace("PASS", Integer.toString(pushPlayerEnrollmentPassCount));
		PushPlayerEnrollmentVar = PushPlayerEnrollmentVar.replace("FAIL", Integer.toString(pushPlayerEnrollmentFailCount));
		var = var + PushPlayerEnrollmentVar;
	}
	
	if(propertyPlayPopUpTCCount!=0) {
		PropertyPlayPopUpVar = PropertyPlayPopUpVar.replace("PASS", Integer.toString(propertyPlayPopUpPassCount));
		PropertyPlayPopUpVar = PropertyPlayPopUpVar.replace("FAIL", Integer.toString(propertyPlayPopUpFailCount));
		var = var + PropertyPlayPopUpVar;
	}
	generateHTML.drawReport(var);
//	CucumberResultsOverview results = new CucumberResultsOverview();
//	results.setOutputDirectory("target");
//	results.setOutputName("cucumber-results");
//	results.setSourceFile("target/Destination/cucumber.json");
//	results.execute();
}
}
