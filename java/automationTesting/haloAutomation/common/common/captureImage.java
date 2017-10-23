package automationTesting.haloAutomation.common.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class captureImage {

	public static String capture(String name){

		 String path;
		 try {
			    WebDriver driver = webDriverClass.driver;
		        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        System.out.println(source.getAbsolutePath());
		        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		        //get current date time with Date()
		        Date date = new Date();

		        // Now format the date
		        String date1= dateFormat.format(date);
		        date1 = date1.replace("/", "");
		        date1 = date1.replace(":", "");
		        date1 = date1.replace(" ", "_");

		        System.out.println(date1);	   
		        String  fileName = name + date1+".png";
		        System.out.println(fileName);
		        String imageFile = "Screenshot/"+fileName;
		        FileUtils.copyFile(source,new File("src/test/resources/result/Screenshot/"+fileName));
		        return imageFile;
		    }
		    catch(IOException e) {
		        path = "Failed to capture screenshot: " + e.getMessage();
		        System.out.println(path);
		        return "";
		    }

	}
	
	public static String captureBConnected(String name){

		 String path;
		 try {
			    WebDriver driver = webDriverClass.bConnectedDriver;
		        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        System.out.println(source.getAbsolutePath());
		        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		        //get current date time with Date()
		        Date date = new Date();

		        // Now format the date
		        String date1= dateFormat.format(date);
		        date1 = date1.replace("/", "");
		        date1 = date1.replace(":", "");
		        date1 = date1.replace(" ", "_");

		        System.out.println(date1);	   
		        String  fileName = name + date1+".png";
		        System.out.println(fileName);
		        String imageFile = "Screenshot/"+fileName;
		        FileUtils.copyFile(source,new File("src/test/resources/result/Screenshot/"+fileName));
		        return imageFile;
		    }
		    catch(IOException e) {
		        path = "Failed to capture screenshot: " + e.getMessage();
		        System.out.println(path);
		        return "";
		    }

	}
	
}
