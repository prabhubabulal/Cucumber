package automationTesting.haloAutomation.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	final WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtUserame']")
	public WebElement LOGINUSERNAME;
	
	@FindBy(how = How.XPATH, using ="//*[@id='txtPassword']")
	public WebElement LOGINPASSWORD;
	
	@FindBy(how = How.XPATH, using ="//*[@id='ddlDomain']")
	public WebElement LOGINDOMAIN;
	
	@FindBy(how = How.XPATH, using ="//*[@id='btnSubmit1']")
	public WebElement LOGINSUBMIT;	

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
}
