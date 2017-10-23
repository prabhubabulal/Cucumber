package automationTesting.haloAutomation.common.FunctionalSpecific;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import automationTesting.haloAutomation.common.common.captureImage;
import automationTesting.haloAutomation.common.common.generateHTML;
import automationTesting.haloAutomation.common.common.webDriverClass;
import automationTesting.haloAutomation.common.common.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class adjustPlayerTierLevel {
	
public static void adjustPlayerTierLevel(String playerID, String CardType, String lockType){
	  try{
		  WebDriver driver = webDriverClass.driver;
		  WebDriverWait wait = new WebDriverWait(driver,60);
		  search.appSearch(playerID);
		  Thread.sleep(1000);		
		  System.out.println("Before Change: "+getTierDetails("before"));
		  webElementActionClass.clickLink("id", haloVariables.PLAYERFUNCTIONSMENU);
		  Thread.sleep(900);
		  webElementActionClass.clickLink(haloVariables.ADJUST_PLAYER_TIER_VALUE);
		  Thread.sleep(1000);
		  webDriverClass.switchDriver("FramePopUp1");
		  webElementActionClass.selectValueList("xpath", haloVariables.ADJUST_PLAYER_CARD_SCORE, CardType);
		  webElementActionClass.selectValueList("xpath", haloVariables.LOCK_TYPE, lockType);
		  webElementActionClass.clickLink(haloVariables.BTN_PLAYER_ADJUST);
		  webDriverClass.switchDriver();
		  Thread.sleep(1000);
		  authorization.authorization(webDriverClass.appPassword, "Card Level Gifted", "Test",CardType);
		  Thread.sleep(1000);
		  System.out.println("After Change :"+getTierDetails("after"));
		  
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	
}
	public static String getTierDetails(String beforeAfter){
		try{
			webElementActionClass.clickLink(haloVariables.PLAYERINFO_MENU);
			Thread.sleep(1000);
			webDriverClass.switchDriver("ifrContent");
			String tierDetail = webElementActionClass.getTextFromWebElement("xpath", haloVariables.TIERLABEL);
			generateHTML.writeResults("Adjust Tier Value", "Pass", "Tier Value "+beforeAfter+" adjustment is "+tierDetail,captureImage.capture("tierDetails"));
			webDriverClass.switchDriver();
			return tierDetail;
		}catch(Exception e){return "";}
	}
	 
}
