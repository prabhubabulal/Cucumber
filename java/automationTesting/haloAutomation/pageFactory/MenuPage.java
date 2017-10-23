package automationTesting.haloAutomation.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuPage {

	final WebDriver driver;
	

	@FindBy(how = How.ID, using = "main_nav_1000010")
	public WebElement PLAYERFUNCTIONS;
	
	@FindBy(how = How.ID, using ="main_nav_1000000")
	public WebElement CONFIGURATION;
	
	@FindBy(how = How.ID, using ="main_nav_1000002")
	public WebElement ADMINISTRATION;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Enroll Player']")
	public WebElement ENROLLPLAYER;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Print Card']")
	public WebElement PRINTCARD;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Edit Patron Data']")
	public WebElement EDITPATRONDATA;
	
	@FindBy(how = How.XPATH, using ="//*[text()='User Transaction Log']")
	public WebElement USERTRANSACTIONLOG;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Add Pin']")
	public WebElement ADDPIN;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Link Player']")
	public WebElement LINKPLAYER;
	
	@FindBy(how = How.XPATH, using ="//*[text()='UnLink Player']")
	public WebElement UNLINKPLAYER;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Player Information Sync']")
	public WebElement PLAYERINFORMATIONSYNC;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Push Player Enrollment']")
	public WebElement PUSHPLAYERENROLLMENT;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Property Play Popup']")
	public WebElement PROPERTYPLAYPOPUP;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Adjust Bucket Value']")
	public WebElement ADJUSTBUCKETVALUE;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Bucket Balances Popup']")
	public WebElement BUCKETBALANCEPOPUP;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Adjust Player Tier Level']")
	public WebElement ADJUSTPLAYERTIERLEVEL;
	
	@FindBy(how = How.XPATH, using ="//*[text()='MERGE']")
	public WebElement MERGE;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Achiever Redemption History']")
	public WebElement ACHIVERREDEMPTIONHISTORY;
	
	@FindBy(how = How.XPATH, using ="//*[text()='Optin_Popup']")
	public WebElement OPTIONPOPUP;
	
	@FindBy(how = How.XPATH, using ="//*[text()='View Comment']")
	public WebElement VIEWCOMMENT;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
}
