package automationTesting.haloAutomation.common.FunctionalSpecific;


import automationTesting.haloAutomation.common.common.captureImage;
import automationTesting.haloAutomation.common.common.generateHTML;
import automationTesting.haloAutomation.common.common.webDriverClass;
import automationTesting.haloAutomation.common.common.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class propertyPlayPopUp {
public static String getpropertyPlayPopUp() {
	String LastPropertyPlayer = "";
	try{	
		
	  webElementActionClass.clickLink("id", haloVariables.PLAYERFUNCTIONSMENU);
	  Thread.sleep(1000);
	  webElementActionClass.clickLink(haloVariables.PROPERTYPLAY_POPUP_MENU);	  
	  Thread.sleep(1000);
	  webDriverClass.switchDriver("FramePopUp1");	  
	  String[] propertyPlayPopup = webElementActionClass.readDataFromWebTable(haloVariables.PROPERTY_PLAY_POPUP_TABLE);
	  for(int i=0;i<propertyPlayPopup.length;i++){
		  System.out.println("Transaction "+(i+1)+" :"+propertyPlayPopup[i].toString());
		  LastPropertyPlayer = propertyPlayPopup[i].toString();
		  break;
	  }
	  
	  generateHTML.writeResults("Property Play Popup", "Pass", "Property Play Popup entry is successful and Last Entry is "+ LastPropertyPlayer, captureImage.capture("propertyPlayPopup"));
	  webElementActionClass.clickLink("xpath", haloVariables.CANCELBUTTON);
	  webDriverClass.switchDriver();
	}catch(Exception e){e.printStackTrace();}
	return LastPropertyPlayer;
}



}
