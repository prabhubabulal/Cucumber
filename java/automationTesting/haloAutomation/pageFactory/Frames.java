package automationTesting.haloAutomation.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Frames {

	final WebDriver driver;
	
	@FindBy(how = How.ID, using = "ifrContent")
	public WebElement IFRCONTENT;
	
	
	public Frames(WebDriver driver) {
		this.driver = driver.switchTo().frame(IFRCONTENT);
	}
	
}
