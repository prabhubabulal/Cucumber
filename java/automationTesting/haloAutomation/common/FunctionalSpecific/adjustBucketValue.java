package automationTesting.haloAutomation.common.FunctionalSpecific;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import automationTesting.haloAutomation.sanityTest;
import automationTesting.haloAutomation.common.common.captureImage;
import automationTesting.haloAutomation.common.common.generateHTML;
import automationTesting.haloAutomation.common.common.webDriverClass;
import automationTesting.haloAutomation.common.common.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class adjustBucketValue {
	
public static void adjustBucketValue(String playerID, String EarningType){
	  try{
		  WebDriver driver = webDriverClass.driver;
		  WebDriverWait wait = new WebDriverWait(driver,60);
		  search.appSearch(playerID);
		  Thread.sleep(1000);
		  if(EarningType.contains("Card Score")){
			  System.out.println("Before Update: "+getCardScoreEarnings("before"));  
		  }else if(EarningType.contains("Slot Points")){
			  System.out.println("Before Update :"+getSlotPontEarnings("before"));
		  }
		  
		  webElementActionClass.clickLink("id", haloVariables.PLAYERFUNCTIONSMENU);
		  Thread.sleep(900);
		  webElementActionClass.clickLink(haloVariables.ADJUST_BUCKET_VALUE);
		  Thread.sleep(1000);
		  webDriverClass.switchDriver("FramePopUp1");
		  if(EarningType.equalsIgnoreCase("Card Score Earnings")){
			  webElementActionClass.selectValueList("xpath", haloVariables.SELECT_BUDGET_TO_ADJUST, "Card Score");  
		  }else if(EarningType.equalsIgnoreCase("Slot Points Earnings")){
			  webElementActionClass.selectValueList("xpath", haloVariables.SELECT_BUDGET_TO_ADJUST, "Points");
		  }		  
		  webElementActionClass.setText("xpath", haloVariables.ENTER_BUCKET_ADJUSTMENT_VALUE, "100");
		  webElementActionClass.selectValueList("xpath", haloVariables.ENROLLTOPROPERTY, "IP Biloxi");
		  //captureImage.capture("adjustment");
		  webElementActionClass.WebElementLink("xpath",haloVariables.ADJUST_BUTTON);
		  Thread.sleep(2000);
		  webDriverClass.switchDriver();
		  authorization.authorization(webDriverClass.appPassword, "Guest Satisfaction", "Tests",EarningType);			  
		  if(EarningType.contains("Card Score")){
			  System.out.println("After update"+getCardScoreEarnings("after"));  
		  }else if(EarningType.contains("Slot Points")){
			  System.out.println("After Update :"+getSlotPontEarnings("after"));
		  }
		  
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	
}
	
public static String getCardScoreEarnings(String beforeAfter) throws InterruptedException{
	try{
		  webElementActionClass.clickLink(haloVariables.CREDITSCORE_EARNINGS);
		  Thread.sleep(1000);
		  webDriverClass.switchDriver("ifrContent");
		  String[] cardEarningScore = webElementActionClass.readDataFromWebTable(haloVariables.EARNINGS_TABLE);
		  String[] cardEarnings = cardEarningScore[1].toString().split("\\|");
		  String lastupdateDate = cardEarnings[2].toString();
		  String cardScore = cardEarnings[3].toString();
		  System.out.println("Last Update Date : "+lastupdateDate+" Card Score :"+cardScore);
		  generateHTML.writeResults("Card Score - Adjust Bucket Value", "Pass", "Card Score Bucket Value "+beforeAfter+" adjustment is "+cardScore, captureImage.capture("creditScore"));;
		  webDriverClass.switchDriver();
		  return cardScore;
	}catch(Exception e){
		generateHTML.writeResults("Card Score - Adjust Bucket Value", "Pass", "Card Score Bucket Value "+beforeAfter+" adjustment is Blank", captureImage.capture("creditScore"));;
		webDriverClass.switchDriver();
		return "";
	}
}

public static String getSlotPontEarnings(String beforeAfter) throws InterruptedException{
	try{
		webElementActionClass.clickLink(haloVariables.SLOTPOINTSEARNINGS_MENU);
		  Thread.sleep(1000);
		  webDriverClass.switchDriver("ifrContent");
		  String[] cardEarningScore = webElementActionClass.readDataFromWebTable(haloVariables.EARNINGS_TABLE);
		  String[] cardEarnings = cardEarningScore[1].toString().split("\\|");
		  String lastupdateDate = cardEarnings[2].toString();
		  String cardScore = cardEarnings[3].toString();
		  System.out.println("Last Update Date : "+lastupdateDate+" Card Score :"+cardScore);
		  generateHTML.writeResults("Slot Point - Adjust Bucket Value", "Pass", "Slot Point Bucket Value "+beforeAfter+" bucket Value is "+cardScore, captureImage.capture("slotPoints"));		  
		  webDriverClass.switchDriver();
		  return cardScore;
	}catch(Exception e){
		 generateHTML.writeResults("Slot Point - Adjust Bucket Value", "Pass", "Slot Point Bucket Value "+beforeAfter+" bucket Value is blank", captureImage.capture("slotPoints"));
		webDriverClass.switchDriver();
	return "";}
}
	 
}
