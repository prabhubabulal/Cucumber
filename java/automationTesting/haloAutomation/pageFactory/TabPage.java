package automationTesting.haloAutomation.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TabPage {

	final WebDriver driver;
	

	@FindBy(how = How.XPATH, using = "//*[@id='dvPlayer']")
	public WebElement PLAYERINFO;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvComps']")
	public WebElement TRANSACTIONS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvTrips']")
	public WebElement TRIPS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvTierHistory']")
	public WebElement CARDSCOREHISTORY;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvTierPtEarn']")
	public WebElement CARDSCOREEARNINGS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvOffers']")
	public WebElement OFFERS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvCashBackEarn']")
	public WebElement POINTSEARNINGS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvCompEarn']")
	public WebElement EARNINGS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvRunningBalance']")
	public WebElement RUNNINGBALANCES;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvPromotion']")
	public WebElement PROMOTIONS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvPendingEarnings']")
	public WebElement PENDINGEARNINGS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvGift']")
	public WebElement GIFT;
	
	@FindBy(how = How.XPATH, using = "//*[@id='divBucketAward']")
	public WebElement AWARDS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='divOverflowEarning']")
	public WebElement OVERFLOWEARNINGS;
	
	@FindBy(how = How.XPATH, using = "//*[@id='divContactInformation']")
	public WebElement CONTACTINFORMATION;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dvDiscretionaryComps']")
	public WebElement DISCRETIONARYCOMPS;
		
	@FindBy(how = How.XPATH, using = "//*[@id='dvEventBlock']")
	public WebElement EVENTBLOCK;
	
	public TabPage(WebDriver driver) {
		this.driver = driver;
	}
	
}
