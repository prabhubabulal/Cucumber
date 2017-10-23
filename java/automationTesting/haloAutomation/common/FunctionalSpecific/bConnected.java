package automationTesting.haloAutomation.common.FunctionalSpecific;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationTesting.haloAutomation.common.common.captureImage;
import automationTesting.haloAutomation.common.common.generateHTML;
import automationTesting.haloAutomation.common.common.webDriverClass;
import automationTesting.haloAutomation.common.common.webElementActionClass;
import automationTesting.haloAutomation.variables.bConnectedVariables;
import automationTesting.haloAutomation.variables.haloVariables;

public class bConnected {
	
public static void enroll(){
	  try{
		  Thread.sleep(1000);
		  WebDriver connectedDriver = webDriverClass.bConnectedDriver;
		  List<WebElement> wElement = connectedDriver.findElements(By.xpath(bConnectedVariables.STARTHERE));
		  wElement.get(4).click();
		  System.out.println();
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	
}
	 
	 
}
