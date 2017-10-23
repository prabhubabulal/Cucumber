package automationTesting.haloAutomation.variables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class haloVariables {
	
		
	// Player Enrollment
	
	public static String ENROLLMENTTYPE = "ctl00_ContentPlaceHolder1_ddlEnrolType";
	public static String PLAYERFUNCTIONSMENU = "main_nav_1000010";
	public static String ENROLLPLAYER_MENU = "Enroll Player";
	public static String EDIT_PATRON_MENU = "//*[text()='Edit Patron Data']";
	public static String ADJUST_BUCKET_VALUE = "//*[text()='Adjust Bucket Value']";
	public static String ADJUST_PLAYER_TIER_VALUE = "//*[text()='Adjust Player Tier Level']";
	public static String PROPERTYPLAY_POPUP_MENU = "//*[text()='Property Play Popup']";
	public static String PREFIX = "ctl00_ContentPlaceHolder1_ucPlayerIdentity_ddlPrefix";
	public static String PUSHPLAYERENROLLEMNT_MENU = "//*[text()='Push Player Enrollment']";
	public static String FIRSTNAME = "//*[contains(@id,'txtFirstName')]";
	public static String LASTNAME = "//*[contains(@id,'txtLastName')]";
	public static String BIRTHDATE = "//*[contains(@id,'txtBirthDate')]";
	public static String GENDER = "//*[contains(@id,'ddlGender') and contains(@id,'ucPlayerIdentity')]";
	public static String TYPE = "//*[contains(@id,'ddlType')]";
	public static String IDENTIFICATIONNUMBER = "//*[contains(@id,'txtID') and contains(@id,'ucPlayerIdentification')]";
	public static String EXPIRE_DATE = "//*[contains(@id,'txtExpireDate')]";
	public static String ID_STATE = "//*[contains(@id,'ddlState') and contains(@id,'ucPlayerIdentification')]";
	
	public static String UCPLAYERADDRESS_CHKOPTIN = "//*[contains(@id,'chkOptIn') and contains(@id,'ucPlayerAddress')]";
	public static String ADDRESSTYPE = "//*[contains(@id,'ddlAddressType')]";
	public static String ADDRESSLINE1 = "//*[contains(@id,'txtAddressLine1')]";
	public static String TXTCITY = "//*[contains(@id,'txtCity')]";
	public static String TXTSTATE = "//*[contains(@id,'ddlState') and contains(@id,'ucPlayerAddress')]";
	public static String TXTCOUNTRY = "//*[contains(@id,'ddlCountry') and contains(@id,'ucPlayerAddress')]";
	public static String TXTZIP = "//*[contains(@id,'txtZipPostalCode')and contains(@id,'ucPlayerAddress')]";
	public static String ENROLL = "//*[contains(@id,'btnEnrollOnly')]";
	public static String PLAYERINFO = "//*[@id='ddlPlayerInfo']";
	public static String TIERLABEL = "//*[contains(@id,'imgTierLabel')]";
	public static String PLAYERNAME = "//*[contains(@id,'lblPlayerName')]";
	public static String PLAYERID = "//*[contains(@id,'lblPlayerId')]";
	public static String CREDITBUTTON = "btnCr";
	public static String CREDITEDITBUTTON = "//*[contains(@id,'BtnEditCr')]";
	public static String BTN_ENROLL = "//*[contains(@id,'ctl00_ContentPlaceHolder1_btnEnrollOnly')]";
	public static String BUTTON_ENROLL = "//*[@id='BtnEnroll']";
	public static String OK_BUTTON = "//*[@id='btnStatusOk']";
	
	public static String PROPERTY_PLAY_POPUP_TABLE = "//*[contains(@class,'ig_Item igg_Item item-row')]";
	
	// Main Menus
	
//	public static String TRANSACTIONS_MENU = "//*[@id='dvComps']";
	public static String TRIPS_MENU = "//*[@id='dvTrips']";
	public static String CARDSCOREHISTORY_MENU = "//*[@id='dvTierHistory']";
	public static String CREDITSCORE_EARNINGS = "//*[@id='dvTierPtEarn']";
	public static String  PLAYERINFO_MENU = "//*[@id='dvPlayer']";
	public static String SLOTPOINTSEARNINGS_MENU = "//*[@id='dvCashBackEarn']";
	
	//Search
	public static String SEARCH_PLAYER_ID = "//*[contains(@id,'txtPlayerId')]";
	public static String SEARCH_LASTNAME = "//*[contains(@id,'txtlastname')]";
	public static String SEARCH_FIRSTNAME = "//*[contains(@id,'txtfirstname')]";
	public static String SEARCH_BIRTHDAY = "//*[contains(@id,'txtdob')]";
	public static String SEARCH_IMAGE = "//*[contains(@id,'ImgSearch')]";
	public static String TABLEID = "//*[text()='PRABHU']";
	
	public static String LOCK_TYPE = "//*[@id='ddlLockType']";
	public static String ADJUST_PLAYER_CARD_SCORE = "//*[@id='ddlTier']";
	public static String ENROLLTOPROPERTY = "//*[@id='ddlProperty']";
	public static String CANCELBUTTON = "//*[@id='button']";
	
	public static String LOGOUT = "//a[contains(@id,'lnkLogout')]";
	
	public static String SELECT_BUDGET_TO_ADJUST = "//*[@id='ddlBucketType']";
	public static String ADJUST_BUTTON = "//*[@id='btnAdjust']";
	public static String ENTER_BUCKET_ADJUSTMENT_VALUE = "//*[@id='txtBucketValue']";
	
	public static String AUTHORIZATION_PASSWORD = "//*[@id='TxtAuthorisationPwd']";
	public static String ADJUSTMENT_TIER_REASON = "//*[@id='ddlAdjustTierPoint']";
	public static String ADJUSTMENT_BUCKET_REASON = "//*[@id='ddlTierReason']";
	public static String ADJUSTMENT_COMMENT = "//*[@id='TxtAuthComment']";
	public static String ADJUSTMENT_SUBMIT = "//*[@id='btnPopupSubmit']";
	public static String BTN_PLAYER_ADJUST = "//*[@id='btnPlayerAdjust']";
	
	
	public static String EARNINGS_TABLE = "//*[@class='ig_Item igg_Item']";
	
	public static String TRIPLINK = "//*[@id='lvTrip_groupPlaceholderContainer']//td[TRIPNUMBER]/a";
	public static String TRIPWEBTABLE = "//*[@id='lvRating_itemPlaceholderContainer']//tr";
	
	final WebDriver driver;
	
	public haloVariables(WebDriver driver) {
		this.driver = driver;
	}
	
	
}
