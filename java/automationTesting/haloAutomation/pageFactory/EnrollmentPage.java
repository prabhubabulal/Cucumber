package automationTesting.haloAutomation.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class EnrollmentPage {
	
	final WebDriver driver;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_ddlEnrolType")
	public WebElement ENROLLMENTTYPE;
	
	//=============================================================================================================================		
	// Player Identity
	//=============================================================================================================================	
	
	@FindBy(how = How.ID, using ="ctl00_ContentPlaceHolder1_ucPlayerIdentity_ddlPrefix")
	public WebElement PREFIX;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'txtFirstName')]")
	public WebElement FIRSTNAME;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'txtMiddleName')]")
	public WebElement MIDDLENAME;	
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'txtLastName')]")
	public WebElement LASTNAME;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'ddlSuffix')]")
	public WebElement SUFFIX;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'txtBirthDate')]")
	public WebElement BIRTHDATE;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'ddlGender') and contains(@id,'ucPlayerIdentity')]")
	public WebElement GENDER;

	
	//=============================================================================================================================	
	// Identification	
	//=============================================================================================================================
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'ddlType')]")
	public List <WebElement> IDENTIFICATIONTYPE;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'txtID') and contains(@id,'ucPlayerIdentification')]")
	public List <WebElement> IDENTIFICATIONNUMBER;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'txtDOB') and contains(@id,'ucPlayerIdentification')]")
	public List <WebElement> IDENTIFICATIONDOB;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'txtExpireDate') and contains(@id,'ucPlayerIdentification')]")
	public List <WebElement> IDENTIFICATIONEXPIRYDATE;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'ddlCountry') and contains(@id,'ucPlayerIdentification')]")
	public List <WebElement> IDENTIFICATIONCOUNTRY;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'ddlState') and contains(@id,'ucPlayerIdentification')]")
	public List <WebElement> IDENTIFICATIONSTATE;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'ddlNationality') and contains(@id,'ucPlayerIdentification')]")
	public List <WebElement> IDENTIFICATIONNATIONALITY;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'ddlGender') and contains(@id,'ucPlayerIdentification')]")
	public List <WebElement> IDENTIFICATIONGENDER;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'btnIdentification') and contains(@id,'ContentPlaceHolder')]")
	public WebElement ADDIDENTIFICATION;
	
	//=============================================================================================================================
	// Address
	//=============================================================================================================================	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'chkOptIn')]")
	public List <WebElement> ADDRESSOPT;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'ddlAddressType')]")
	public List <WebElement> ADDRESSTYPE;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'txtAddressLine1')]")
	public List <WebElement> ADDRESSLINE1;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'txtAddressLine2')]")
	public List <WebElement> ADDRESSLINE2;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'txtCity')]")
	public List <WebElement> ADDRESSCITY;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'ddlCountry')]")
	public List <WebElement> ADDRESSCOUNTRY;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'ddlState')]")
	public List <WebElement> ADDRESSSTATE;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'txtZipPostalCode')]")
	public List <WebElement> ADDRESSZIP;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'chkTemporaryAddress')]")
	public List <WebElement> THISISATEMPROARYADDRESS;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'txtFromDate')]")
	public List <WebElement> ADDRESSFROM;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerAddress') and contains(@id,'txtToDate')]")
	public List <WebElement> ADDRESSTO;
	
	@FindBy(how = How.XPATH, using ="//*[contains(@id,'btnAddress') and contains(@id,'ContentPlaceHolder')]")
	public WebElement ADDADDRESS;
	
	//=============================================================================================================================
	// Telephone
	//=============================================================================================================================	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerTelephone') and contains(@id,'chkOptIn')]")
	public List <WebElement> TELEPHONEOPT;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerTelephone') and contains(@id,'ddlType')]")
	public List <WebElement> TELEPHONETYPE;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerTelephone') and contains(@id,'txtTelephoneNumber')]")
	public List <WebElement> TELEPHONENUMBER;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerTelephone') and contains(@id,'txtTelephoneNumber')]")
	public List <WebElement> TELEPHONESTATUS;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ContentPlaceHolder') and contains(@id,'btnTelephone')]")
	public WebElement ADDTELEPHONE;
	
	//=============================================================================================================================
	// Email
	//=============================================================================================================================	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerEmail') and contains(@id,'chkOptIn')]")
	public List <WebElement> EMAILOPT;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerEmail') and contains(@id,'ddlEmailType')]")
	public List <WebElement> EMAILTYPE;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerEmail') and contains(@id,'txtEmailAddress')]")
	public List <WebElement> EMAILADDRESS;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerEmail') and contains(@id,'ddlStatus')]")
	public List <WebElement> EMAILSTATUS;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ContentPlaceHolder') and contains(@id,'btnEmail')]")
	public WebElement ADDEMAIL;
	
	//=============================================================================================================================
	// Social Network
	//=============================================================================================================================	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerSocial') and contains(@id,'chkOptIn')]")
	public List <WebElement> SOCIALNETWORKOPT;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerSocial') and contains(@id,'ddlSocialType')]")
	public List <WebElement> SOCIALNETWORKTYPE;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerSocial') and contains(@id,'txtSocialAccount')]")
	public List <WebElement> SOCIALNETWORKACCOUNT;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerSocial') and contains(@id,'ddlStatus')]")
	public List <WebElement> SOCIALNETWORKSTATUS;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ContentPlaceHolder') and contains(@id,'btnSocial')]")
	public WebElement ADDSOCIALNETWORK;
	
	//=============================================================================================================================
	// SMS
	//=============================================================================================================================	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerSMS') and contains(@id,'chkOptIn')]")
	public List <WebElement> SMSOPT;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerSMS') and contains(@id,'ddlSMSType')]")
	public List <WebElement> SMSTYPE;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerSMS') and contains(@id,'txtSMS')]")
	public List <WebElement> SMSACCOUNT;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerSMS') and contains(@id,'ddlStatus')]")
	public List <WebElement> SMSSTATUS;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ContentPlaceHolder') and contains(@id,'btnSMS')]")
	public WebElement ADDSMS;
	
	//=============================================================================================================================
	// SMS
	//=============================================================================================================================	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerPin') and contains(@id,'txtEnterPIN')]")
	public WebElement ENTERPIN;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerPin') and contains(@id,'txtEnterPINAgain')]")
	public WebElement ENTERPINAGAIN;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ucPlayerPin') and contains(@id,'btnClearPIN')]")
	public WebElement CLEARPIN;
	
	//=============================================================================================================================
	// Buttons
	//=============================================================================================================================
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ContentPlaceHolder') and contains(@id,'btnEnrollPrint')]")
	public WebElement ENROLLANDPRINT;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ContentPlaceHolder') and contains(@id,'btnEnrollOnly')]")
	public WebElement ENROLLONLY;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ContentPlaceHolder') and contains(@id,'btnCancel')]")
	public WebElement CANCEL;
	
	public EnrollmentPage(WebDriver driver) {
		this.driver = driver;
	}
	
}
