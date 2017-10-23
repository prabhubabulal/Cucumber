package automationTesting.haloAutomation.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	final WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'txtPlayerId')]")
	public WebElement PLAYERIDSEARCH;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'txtlastname')]")
	public WebElement PLAYERLASTNAME;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'txtfirstname')]")
	public WebElement PLAYERFIRSTNAME;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'txtdob')]")
	public WebElement PLAYERDOB;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
}
