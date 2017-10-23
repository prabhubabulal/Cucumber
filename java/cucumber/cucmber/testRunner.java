package cucumber.cucmber;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ReportRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\babulalp\\eclipse-workspace\\cucmber\\Feature\\MultiplayerEnrollment.feature"		
		,format= {"pretty","html:src\\reports\\MultiplayerEnrollment"}		
		)
public class testRunner{
	
}
