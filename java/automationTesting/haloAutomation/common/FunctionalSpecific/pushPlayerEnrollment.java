package automationTesting.haloAutomation.common.FunctionalSpecific;


import automationTesting.haloAutomation.common.common.captureImage;
import automationTesting.haloAutomation.common.common.generateHTML;
import automationTesting.haloAutomation.common.common.webDriverClass;
import automationTesting.haloAutomation.common.common.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class pushPlayerEnrollment {
public static void pushPlayer(String playerID, String pushTo) throws InterruptedException{
	search.appSearch(playerID);
	Thread.sleep(1000);
	webElementActionClass.clickLink("id", haloVariables.PLAYERFUNCTIONSMENU);
	Thread.sleep(1000);
	webElementActionClass.clickLink(haloVariables.PUSHPLAYERENROLLEMNT_MENU);	
	webDriverClass.switchDriver("FramePopUp1");
	Thread.sleep(1000);
	webElementActionClass.selectValueList("xpath", haloVariables.ENROLLTOPROPERTY, pushTo);
	 
	webElementActionClass.WebElementLink("xpath", haloVariables.BUTTON_ENROLL);
	Thread.sleep(5000);
	webElementActionClass.WebElementLink("xpath", haloVariables.OK_BUTTON);
    Thread.sleep(1000);
    webDriverClass.switchDriver();	
    generateHTML.writeResults("Push Player Enrolment", "Pass", "Push Player to "+pushTo+" successful", captureImage.capture("pushPlayer"));
	System.out.println("Push Player Enrollment Completed");
	
}
}
