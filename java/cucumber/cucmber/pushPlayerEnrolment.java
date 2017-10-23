package cucumber.cucmber;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\babulalp\\eclipse-workspace\\cucmber\\Feature\\PushPlayerEnrolment.feature"		
		,format= {"pretty","html:src\\reports\\pushPlayerEnrolment"}		
		
		
		)
public class pushPlayerEnrolment{

}
