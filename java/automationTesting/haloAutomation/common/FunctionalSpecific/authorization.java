package automationTesting.haloAutomation.common.FunctionalSpecific;


import automationTesting.haloAutomation.common.common.captureImage;
import automationTesting.haloAutomation.common.common.webDriverClass;
import automationTesting.haloAutomation.common.common.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class authorization {
	
public static void authorization(String password, String reason, String comments,String cardType){
	  try{
		  webElementActionClass.setText("xpath", haloVariables.AUTHORIZATION_PASSWORD, password);
		  Thread.sleep(1000);
		  if(cardType.equalsIgnoreCase("Card Score Earnings")){
			  webElementActionClass.selectValueList("xpath", haloVariables.ADJUSTMENT_TIER_REASON, reason);  
		  }else{
			  webElementActionClass.selectValueList("xpath", haloVariables.ADJUSTMENT_BUCKET_REASON, reason);
		  }	  
		  webElementActionClass.setText("xpath", haloVariables.ADJUSTMENT_COMMENT, comments);
		  webElementActionClass.clickLink("xpath", haloVariables.ADJUSTMENT_SUBMIT);
		  Thread.sleep(3000);
		  webDriverClass.switchDriver("FramePopUp1");
		  webElementActionClass.WebElementLink("xpath", haloVariables.OK_BUTTON);
		  Thread.sleep(1000);
		  captureImage.capture("passwordAuthorization");
		  webDriverClass.switchDriver();	
	  }catch(Exception e){
		  
	  }
	
}
	
	 
}
