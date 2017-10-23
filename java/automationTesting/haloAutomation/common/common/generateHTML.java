package automationTesting.haloAutomation.common.common;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class generateHTML {
	public static String reportPath;
	public static String HTMLFileName;
	public static void writeStartResults(String adjuster, String startdatetime, String testerName, String env,String appUser, String URL) {
		reportPath=null;
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get("src/test/resources/result.htm")));
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
			Date d = new Date();
			String date1= dateFormat.format(d);
			date1 = date1.replaceAll("/", "");

			reportIn = reportIn.replaceFirst("timestarted'>","timestarted'> : "+startdatetime);

			reportIn = reportIn.replaceFirst("envversion'>","envversion'>: "+ URL);
			reportIn = reportIn.replaceFirst("ipaddress'>","ipaddress'> : "+ appUser);
			
			reportIn = reportIn.replaceFirst("envname'>","envname'> : "+ env);
			
			HTMLFileName = adjuster+"_report_" + startdatetime;
			
			reportPath = "src\\test\\resources\\result\\"+ adjuster+"_report_" + startdatetime + ".html";
			try
			{
				Thread.sleep(500);
			}catch (Exception e){}

			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);

		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}

	}
	
	public static void writeResults(String step, String result, String remarks, String image) {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(reportPath)));
			String temp=null;
			String url = image.replace("\\", "/");
			System.out.println("The Image URL  is :"+url);
			
			if(result.equalsIgnoreCase("Pass"))
				temp = "<tr class='PassedHigh'><td width='18%' class='bg_gray_eee'><font class='PassedHigh'>"+ step+"</font></td><td width='6%'><font class='PassedHigh'>"+ result +"</font></td><td width='68%'><font class='PassedHigh'>"+ remarks+"</font></td><td width='8%'><font class='PassedHigh'><a href='"+ url +"'>IMG</a></font></td></tr>";
			else if(result.equalsIgnoreCase("Fail")){
					temp = "<tr class='FailedHigh'><td width='18%' class='bg_gray_eee'><font class='FailedHigh'>"+ step+"</font></td><td width='6%'><font class='FailedHigh'>"+ result +"</font></td><td width='68%'><font class='FailedHigh'>"+ remarks+"</font></td><td width='8%'><font class='FailedHigh'><a href='"+ url +"'>IMG</a></font></td></tr>";					
			}else{
				temp = "<tr class='bg_yellow'><td width='18%' class='bg_yellow'><font class='hl2'>"+ step+"</font></td><td width='6%'><font class='hl2'>"+ result +"</font></td><td width='68%'><font class='hl2'>"+ remarks+"</font></td><td width='8%'></td></tr>";
			}
			
			reportIn = reportIn.replaceFirst("<tr class='bg_ligtblue' id='temp'>",temp+"<tr class='bg_ligtblue' id='temp'>");

			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);

		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
	
	public static void drawReport(String report) {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(reportPath)));
			String temp=null;
					
			reportIn = reportIn.replaceFirst("UPDATERESULTINHTMLREPORT",report);

			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);

		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
	
	public static void writeEndResult(){
		try{
			String reportIn = new String(Files.readAllBytes(Paths.get(reportPath)));
			  String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				Date today = new Date();
				String currentTime = today.getHours()+"-"+today.getMinutes()+"-"+today.getSeconds();
			  String datetime = currentDate+"-"+currentTime;
			reportIn = reportIn.replaceFirst("timeended'>","timeended'> : "+datetime);
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
		}catch(Exception e){}
	}
	
}
