package automationTesting.haloAutomation.common.FunctionalSpecific;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationTesting.haloAutomation.common.common.captureImage;
import automationTesting.haloAutomation.common.common.generateHTML;
import automationTesting.haloAutomation.common.common.readDataFromExcel;
import automationTesting.haloAutomation.common.common.webDriverClass;
import automationTesting.haloAutomation.common.common.webElementActionClass;
import automationTesting.haloAutomation.pageFactory.EnrollmentPage;
import automationTesting.haloAutomation.pageFactory.HomePage;
import automationTesting.haloAutomation.pageFactory.LoginPage;
import automationTesting.haloAutomation.pageFactory.MenuPage;
import automationTesting.haloAutomation.variables.haloVariables;

public class playerEnrollment {
	public static String playerLastName;
	
public static String enrollPlayer(String testCaseID) {
	WebDriver driver = webDriverClass.driver;
	WebDriverWait wait = new WebDriverWait(driver,60);
    String playerID = "";
		
	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	try{
		readDataFromExcel data = new readDataFromExcel();
		Map<String,Object[]> map = data.readTestData("TestData", "TestData", testCaseID);
		int noofLocation = data.getValuefromMap(map, "TestCase_ID");
		
		for(int loc=0;loc<=noofLocation;loc++) {			 
				  EnrollmentPage EnrollmentPage = PageFactory.initElements(driver, EnrollmentPage.class);			
				  MenuPage menus = PageFactory.initElements(driver, MenuPage.class);
				  
				  menus.PLAYERFUNCTIONS.click();
				  wait.until(ExpectedConditions.visibilityOf(menus.ENROLLPLAYER));
				  menus.ENROLLPLAYER.click();
				  
				  // Player Identity
				  
				  String playerType = data.getValuefromMap(map, "Enrollment_Type", loc);
				  String firstName = data.getValuefromMap(map, "FirstName", loc);
				  String lastName = data.getValuefromMap(map, "LastName", loc);
				  String dateOfBirth = data.getValuefromMap(map, "BirthDate", loc);
				  String gender = data.getValuefromMap(map, "Gender", loc);
				  
				  Random rand = new Random();
				  int random_3_Char = rand.nextInt(9999);
				  firstName = firstName+String.valueOf(random_3_Char);
				  int random4_char = rand.nextInt(9999);
				  lastName = lastName+String.valueOf(random4_char);
				  playerLastName = lastName;
				  
				  
				  wait.until(ExpectedConditions.visibilityOf(EnrollmentPage.ENROLLMENTTYPE));
				  EnrollmentPage.ENROLLMENTTYPE.sendKeys(playerType);
				  wait.until(ExpectedConditions.visibilityOf(EnrollmentPage.FIRSTNAME));
				  EnrollmentPage.PREFIX.sendKeys("MR");
				  EnrollmentPage.FIRSTNAME.sendKeys(firstName);
				  EnrollmentPage.MIDDLENAME.sendKeys("");
				  EnrollmentPage.LASTNAME.sendKeys(lastName);
				  EnrollmentPage.SUFFIX.sendKeys("Senior");
				  EnrollmentPage.BIRTHDATE.sendKeys(dateOfBirth);
				  EnrollmentPage.GENDER.sendKeys(gender);
				  
				  //Identification
				  String identificationID = data.getValuefromMap(map, "Identification_ID", loc);		  
				  
				  if(identificationID!="") {
					    int noOfIdentification = 0;
						Map<String,Object[]> identificationMap = data.readTestData("TestData", "Identification", identificationID);
						noOfIdentification = data.getValuefromMap(identificationMap, "Identification_ID");
						for(int ident = 0;ident<=noOfIdentification-1;ident++) {		
							
							// Read test data from Map
							  String identificationtype = data.getValuefromMap(identificationMap, "Type", ident);
							  String identificationNumber = data.getValuefromMap(identificationMap, "Number", ident);
							  String identificationDOB = data.getValuefromMap(identificationMap, "DOB", ident);
							  String identificationExpiryDate = data.getValuefromMap(identificationMap, "ExpireDate", ident);
							  String identificationCountry = data.getValuefromMap(identificationMap, "Country", ident);
							  String identificationState = data.getValuefromMap(identificationMap, "State", ident);
							  String identificationGender = data.getValuefromMap(identificationMap, "Gender", ident);	
							  
							 // Insert data into application
							  EnrollmentPage.IDENTIFICATIONTYPE.get(ident).sendKeys(identificationtype);
							  Thread.sleep(1000);
							  wait.until(ExpectedConditions.visibilityOf(EnrollmentPage.IDENTIFICATIONNUMBER.get(ident)));
							  EnrollmentPage.IDENTIFICATIONNUMBER.get(ident).sendKeys(identificationNumber);
							  EnrollmentPage.IDENTIFICATIONDOB.get(ident).sendKeys(identificationDOB);
							  EnrollmentPage.IDENTIFICATIONEXPIRYDATE.get(ident).sendKeys(identificationExpiryDate);
							 
//							  Select IDNTCOUNTRY = new Select(EnrollmentPage.IDENTIFICATIONCOUNTRY.get(ident));
//							  IDNTCOUNTRY.selectByValue(identificationCountry);
//							  Thread.sleep(500);
							  EnrollmentPage.IDENTIFICATIONCOUNTRY.get(ident).sendKeys(identificationCountry);
							  EnrollmentPage.IDENTIFICATIONCOUNTRY.get(ident).sendKeys(identificationCountry);
							  try {
								  EnrollmentPage.IDENTIFICATIONSTATE.get(ident).sendKeys(identificationState);  
							  }catch(Exception e) {}
							  
							  EnrollmentPage.IDENTIFICATIONGENDER.get(ident).sendKeys(identificationGender);
						  
							
							  if(ident >=0 && ident != noOfIdentification-1) {
								  EnrollmentPage.ADDIDENTIFICATION.click();
								  Thread.sleep(1000);
							  }
						}
					}	  		 
				  
				  // Address			  
				  String addressID = data.getValuefromMap(map, "Address_ID", loc);
				  if(addressID!="") {
					  Map<String,Object[]> addressMap = data.readTestData("TestData", "Address", addressID);
					  int addressCount = data.getValuefromMap(addressMap, "Address_ID");
					  for(int addCnt=0;addCnt<=addressCount-1;addCnt++) {					  
						  // Read test data from Map
						  String addressOpt = data.getValuefromMap(addressMap, "Opt", addCnt);
						  String addressType = data.getValuefromMap(addressMap, "Type", addCnt);
						  String addressAddressLine1 = data.getValuefromMap(addressMap, "AddressLine1", addCnt);
						  String addressAddressLine2 = data.getValuefromMap(addressMap, "AddressLine2", addCnt);
						  String addressCity = data.getValuefromMap(addressMap, "City", addCnt);
						  String addressCountry = data.getValuefromMap(addressMap, "Country", addCnt);
						  String addressState = data.getValuefromMap(addressMap, "State", addCnt);
						  String addressZip = data.getValuefromMap(addressMap, "Zip", addCnt);
						  String addressThiisTemproaryAddress = data.getValuefromMap(addressMap, "This_is_Temproary_Address", addCnt);
						  String addressFrom = data.getValuefromMap(addressMap, "From", addCnt);
						  String addressTo = data.getValuefromMap(addressMap, "To", addCnt);
						  
						  // insert value into application					  
						  if(addressOpt.equalsIgnoreCase(("Yes"))){
							  EnrollmentPage.ADDRESSOPT.get(addCnt).click();
						  }					  
						  EnrollmentPage.ADDRESSTYPE.get(addCnt).sendKeys(addressType);
						  EnrollmentPage.ADDRESSLINE1.get(addCnt).sendKeys(addressAddressLine1);
						  EnrollmentPage.ADDRESSLINE2.get(addCnt).sendKeys(addressAddressLine2);
						  EnrollmentPage.ADDRESSCITY.get(addCnt).sendKeys(addressCity);
						  EnrollmentPage.ADDRESSCOUNTRY.get(addCnt).sendKeys(addressCountry);
						  EnrollmentPage.ADDRESSCOUNTRY.get(addCnt).sendKeys(addressCountry);
						  EnrollmentPage.ADDRESSSTATE.get(addCnt).sendKeys(addressState);
						  EnrollmentPage.ADDRESSZIP.get(addCnt).sendKeys(addressZip);
						  if(addressThiisTemproaryAddress.equals("Yes")) {
							  EnrollmentPage.THISISATEMPROARYADDRESS.get(addCnt).click();  
							  EnrollmentPage.ADDRESSFROM.get(addCnt).sendKeys(addressFrom);
							  EnrollmentPage.ADDRESSTO.get(addCnt).sendKeys(addressTo);
						  }
						  
						  if(addCnt>=0 && addCnt != addressCount-1) {
							  EnrollmentPage.ADDADDRESS.click();
							  Thread.sleep(1000);
						  }
						  
					  }
				  }
				  
				// Telephone
				  String telephoneID = data.getValuefromMap(map, "Telephone_ID", loc);
				  if(telephoneID != "") {
					  Map<String,Object[]> telephoneMap = data.readTestData("TestData", "Telephone", telephoneID);
					  int telephoneCount = data.getValuefromMap(telephoneMap, "Telephone_ID");
					  for(int telCnt=0;telCnt<=telephoneCount-1;telCnt++) {
						  
						  // Read data from Map
						  String telephoneOpt = data.getValuefromMap(telephoneMap, "Opt", telCnt);
						  String telephoneType =  data.getValuefromMap(telephoneMap, "Type", telCnt);
						  String telephoneNumber = data.getValuefromMap(telephoneMap, "TelephoneNumber", telCnt); 
						  String telephoneStatus = data.getValuefromMap(telephoneMap, "Status", telCnt);
						  
						  // Insert Value Into application
						  if(telephoneOpt.equalsIgnoreCase(("Yes"))){
							  EnrollmentPage.TELEPHONEOPT.get(telCnt).click();
						  }	
						  EnrollmentPage.TELEPHONETYPE.get(telCnt).sendKeys(telephoneType);
						  EnrollmentPage.TELEPHONENUMBER.get(telCnt).sendKeys(telephoneNumber);
						  EnrollmentPage.TELEPHONESTATUS.get(telCnt).sendKeys(telephoneStatus);
						  
						  if(telCnt>=0 && telCnt != telephoneCount-1) {
							  EnrollmentPage.ADDTELEPHONE.click();
							  Thread.sleep(1000);
						  }
					  }
				  }
				  
				// Email Address
				String emailID = data.getValuefromMap(map, "Email_ID", loc);
				if(emailID!="") {
					  Map<String,Object[]> emailMap = data.readTestData("TestData", "Email", emailID);
					  int emailCount = data.getValuefromMap(emailMap, "Email_ID");
					  for(int eCnt=0;eCnt<=emailCount-1;eCnt++) {
						  
						  // Read Data From Map
						  String emailOpt = data.getValuefromMap(emailMap, "Opt", eCnt);
						  String emailType = data.getValuefromMap(emailMap, "Type", eCnt);
						  String emailAddress = data.getValuefromMap(emailMap, "Email_Address", eCnt);
						  String emailStatus = data.getValuefromMap(emailMap, "Status", eCnt);
						  
						  // Insert Value into application					  
						  if(emailOpt.equalsIgnoreCase("Yes")) {
							  EnrollmentPage.EMAILOPT.get(eCnt).click();						  
						  }
						  EnrollmentPage.EMAILTYPE.get(eCnt).sendKeys(emailType);
						  EnrollmentPage.EMAILADDRESS.get(eCnt).sendKeys(emailAddress);
						  EnrollmentPage.EMAILSTATUS.get(eCnt).sendKeys(emailStatus);
						  
						  if(eCnt>=0 && eCnt != emailCount-1) {
							  EnrollmentPage.ADDEMAIL.click();
							  Thread.sleep(1000);
						  }
					  }
				}
				
			// Social Network
			String socialNetworkID = data.getValuefromMap(map, "SocialNetwork_ID", loc);
			if(socialNetworkID!="") {
				 Map<String,Object[]> socialNetworkMap = data.readTestData("TestData", "SocialNetwork", socialNetworkID);
				  int socialNetworkCount = data.getValuefromMap(socialNetworkMap, "SocialNetwork_ID");
				  for(int snCnt=0;snCnt<=socialNetworkCount-1;snCnt++) {
					
					  // Read Data From Map
					  String socialNetworkOpt = data.getValuefromMap(socialNetworkMap, "Opt", snCnt);
					  String socialNetworkType = data.getValuefromMap(socialNetworkMap, "Type", snCnt);
					  String socialNetworkAccount = data.getValuefromMap(socialNetworkMap, "Account", snCnt);
					  String socialNetworkStatus = data.getValuefromMap(socialNetworkMap, "Status", snCnt);
					  
					 // Insert Value into Application
					  
					  if(socialNetworkOpt.equalsIgnoreCase("Yes")) {
						  EnrollmentPage.SOCIALNETWORKOPT.get(snCnt).click();						  
					  }
					  EnrollmentPage.SOCIALNETWORKTYPE.get(snCnt).sendKeys(socialNetworkType);
					  EnrollmentPage.SOCIALNETWORKACCOUNT.get(snCnt).sendKeys(socialNetworkAccount);
					  EnrollmentPage.SOCIALNETWORKSTATUS.get(snCnt).sendKeys(socialNetworkStatus);
					  
					  if(snCnt>=0 && snCnt != socialNetworkCount-1) {
						  EnrollmentPage.ADDSOCIALNETWORK.click();
						  Thread.sleep(1000);
					  }
					  
				  }
			}
			
			// SMS
			String smsID = data.getValuefromMap(map, "SMS_ID", loc);	
			if(smsID!="") {
				 Map<String,Object[]> smsMap = data.readTestData("TestData", "SMS", smsID);
				  int smsCount = data.getValuefromMap(smsMap, "SMS_ID");
				  for(int sCnt=0;sCnt<=smsCount-1;sCnt++) {
					
					  // Read Data From Map
					  String smsOpt = data.getValuefromMap(smsMap, "Opt", sCnt);
					  String smsType = data.getValuefromMap(smsMap, "Type", sCnt);
					  String smsAccount = data.getValuefromMap(smsMap, "Account", sCnt);
					  String smsStatus = data.getValuefromMap(smsMap, "Status", sCnt);
					  
					 // Insert Value into Application
					  
					  if(smsOpt.equalsIgnoreCase("Yes")) {
						  EnrollmentPage.SMSOPT.get(sCnt).click();						  
					  }
					  EnrollmentPage.SMSTYPE.get(sCnt).sendKeys(smsType);
					  EnrollmentPage.SMSACCOUNT.get(sCnt).sendKeys(smsAccount);
					  EnrollmentPage.SMSSTATUS.get(sCnt).sendKeys(smsStatus);
					  
					  if(sCnt>=0 && sCnt != smsCount-1) {
						  EnrollmentPage.ADDSMS.click();
						  Thread.sleep(1000);
					  }
					  
				  }
			}
			
			String enterPin = data.getValuefromMap(map, "Enter_PIN", loc);
			if(enterPin != "") {
				EnrollmentPage.ENTERPIN.sendKeys(enterPin);			
				EnrollmentPage.ENTERPINAGAIN.sendKeys(data.getValuefromMap(map, "ReEnter_PIN", loc));
			}
		
			EnrollmentPage.ENROLLONLY.click();
			Thread.sleep(1000);
			playerID = playerID+"|"+playerdetails(playerType);
		}
		
		
		return playerID;
			
		
	}catch(Exception e){
		return "";
	}	
	
	
}

public static String playerdetails(String playertype){
	 WebDriver driver = webDriverClass.driver;
	 try{
		 WebDriverWait wait = new WebDriverWait(driver,60);
		  Thread.sleep(1000);		  
		  webDriverClass.switchDriver("ifrContent");
		  String tierLabel = driver.findElement(By.xpath(haloVariables.TIERLABEL)).getText();
		  assertEquals(tierLabel, "RUBY");
		  String playerID = driver.findElement(By.xpath(haloVariables.PLAYERID)).getText();
		  Thread.sleep(1000);
		  webDriverClass.switchDriver();
		  generateHTML.writeResults("Player Enrollment", "Pass", playertype+" player enrolled successfully. Player ID is "+playerID+" and Tier Value is "+tierLabel , captureImage.capture("EnrollPage"));
		  return playerID;		  
	  }catch(Exception e){e.printStackTrace();}
	 	  generateHTML.writeResults("New Player Enrollment", "Fail", "Player Enrollment Failed", captureImage.capture("EnrollPage"));
		  driver.switchTo().defaultContent();
		  return "";
}

}
