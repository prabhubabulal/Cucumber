package cucumber.cucmber.SanityStepGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\babulalp\\eclipse-workspace\\cucmber\\Feature\\SanityTesting.feature"		
		,format= {"pretty","html:src\\reports\\SanityTesting"}
		)
public class SanityTestRunner{	
}
