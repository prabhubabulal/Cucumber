package automationTesting.haloAutomation.common.common;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webElementActionClass {
	
	public static void setText(String locator,String locatorVariable,String value){
		
		try{
			WebDriver driver = webDriverClass.driver;
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//			WebDriverWait wait = new WebDriverWait(driver,60);
			if(locator.equalsIgnoreCase("ID")){				
				driver.findElement(By.id(locatorVariable)).clear();
				driver.findElement(By.id(locatorVariable)).sendKeys(value);	
			}else if(locator.equalsIgnoreCase("xpath")){
				driver.findElement(By.xpath(locatorVariable)).clear();
				driver.findElement(By.xpath(locatorVariable)).sendKeys(value);
			}			
		}catch(Exception e){
			System.out.println("Error Settinging value into Text Box. xpath Used: "+locatorVariable);
			e.printStackTrace();
		}
	}
	
	public static void clickLink(String locator,String locatorVariable){
		try{
			WebDriver driver = webDriverClass.driver;
			WebDriverWait wait = new WebDriverWait(driver,20);
			
			if(locator.equalsIgnoreCase("id")){
				wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorVariable)));
				driver.findElement(By.id(locatorVariable)).sendKeys(Keys.ENTER);
			}else if(locator.equalsIgnoreCase("xpath")){
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorVariable)));
				driver.findElement(By.xpath(locatorVariable)).sendKeys(Keys.ENTER);
				
			}else if(locator.equalsIgnoreCase("linktext")){
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locatorVariable)));
				driver.findElement(By.linkText(locatorVariable)).sendKeys(Keys.ENTER);
			}
		}catch(Exception e){
			System.out.println("Error while clicking link. xpath Used: "+locatorVariable);
			e.printStackTrace();
		}
	}
	
	public static void selectValue(String locator,String locatorVariable,String value){
		try{
			WebDriver driver = webDriverClass.driver;
			if(locator.equalsIgnoreCase("id")){
				driver.findElement(By.id(locatorVariable)).sendKeys(value);
			}else if(locator.equalsIgnoreCase("xpath")){
				driver.findElement(By.xpath(locatorVariable)).sendKeys(value);
			}
		}catch(Exception e){
			System.out.println("Error while selecting value from list. xpath Used: "+locatorVariable);
			e.printStackTrace();
		}
	}
	
	public static void WebElementLink(String locator, String locatorVariable){
		try{
			WebDriver driver = webDriverClass.driver;
			WebDriverWait wait = new WebDriverWait(driver, 30);
			if(locator.equalsIgnoreCase("id")){
				driver.findElement(By.id(locatorVariable)).sendKeys(Keys.ENTER);				
			}else if(locator.equalsIgnoreCase("xpath")){						
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorVariable)));
				driver.findElement(By.xpath(locatorVariable)).sendKeys(Keys.ENTER);				
			}else if(locator.equalsIgnoreCase("linktext")){
				driver.findElement(By.linkText(locatorVariable)).sendKeys(Keys.ENTER);
			}else if(locator.equalsIgnoreCase("cssselector")){
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorVariable)));
				driver.findElement(By.cssSelector(locatorVariable)).sendKeys(Keys.ENTER);
			}
		}catch(Exception e){
			System.out.println("Error while clicking link. xpath Used: "+locatorVariable);
			e.printStackTrace();
		}
	}
	
	public static void setCheckBox(String locator, String locatorVariable){
		try{
			WebDriver driver = webDriverClass.driver;			
			if(locator.equalsIgnoreCase("id")){
				driver.findElement(By.id(locatorVariable)).sendKeys(Keys.ENTER);
			}else if(locator.equalsIgnoreCase("xpath")){
				if(!driver.findElement(By.xpath(locatorVariable)).isSelected()){
					driver.findElement(By.xpath(locatorVariable)).sendKeys(Keys.SPACE);
				}				
			}else if(locator.equalsIgnoreCase("linktext")){
				driver.findElement(By.linkText(locatorVariable)).sendKeys(Keys.ENTER);
			}
		}catch(Exception e){
			System.out.println("Error while setting check box. xpath Used: "+locatorVariable);
			e.printStackTrace();
		}
	}
	
	public static String getTextFromWebElement(String locator, String locatorVariable){
		try{
			WebDriver driver = webDriverClass.driver;
			if(locator.equalsIgnoreCase("id")){
				return driver.findElement(By.id(locatorVariable)).getText();
			}else if(locator.equalsIgnoreCase("xpath")){
				return driver.findElement(By.xpath(locatorVariable)).getText();
			}else{
				return "";
			}
			
		}catch(Exception e){
			System.out.println("Error while getting value. xpath Used: "+locatorVariable);
			e.printStackTrace();
			return "";
		}
	}
	
	public static void selectValueFromList(String locator,String locatorVariable,String selectValue){
		try{
			WebDriver driver = webDriverClass.driver;			
			if(locator.equalsIgnoreCase("xpath")){
				WebElement select = driver.findElement(By.xpath(locatorVariable));
				List<WebElement> options = select.findElements(By.tagName(selectValue));
				for (WebElement option : options) {
				    if(selectValue.equals(option.getText()))
				        option.click();   
				}	
			}
			
		}catch(Exception e){
			System.out.println("Error while selecting value from list. xpath Used: "+locatorVariable);
			e.printStackTrace();
		}
	}
	
	public static void selectValueFromList(String locator,String locatorVariable,int index){
		try{
			WebDriver driver = webDriverClass.driver;			
			Select objSel = new Select(driver.findElement(By.xpath(locatorVariable)));
			objSel.selectByIndex(index);
		}catch(Exception e){e.printStackTrace();}
	}
	public static void selectValueList(String locator,String locatorVariable,String selecttionValue){
		try{			
			WebDriver driver = webDriverClass.driver;				
			WebDriverWait wait = new WebDriverWait(driver,60);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorVariable)));			
			WebElement select = driver.findElement(By.xpath(locatorVariable));
			List<WebElement> options = select.findElements(By.tagName("option"));
			for (WebElement option : options) {						
			    if(selecttionValue.equals(option.getText())){
			    	option.click();   
			    	break;
			    }			        
			}	

			
//			((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text.indexOf(arguments[1]) != -1){ select.options[i].selected = true; } }",
//		            select,
//		            selecttionValue);
		}catch(Exception e){e.printStackTrace();}
	}
	
//	public static void selectValueList(String locator, String locatorVariable,String value){
//		try{
//			WebDriver driver = webDriverClass.driver;
//			WebDriverWait wait = new WebDriverWait(driver,60);
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorVariable)));
//			WebElement select = driver.findElement(By.xpath(locatorVariable));
//			List<WebElement> options = select.findElements(By.tagName("option"));
//			for (WebElement option : options) {				
//				System.out.println("Selection value :"+option.getAttribute("Value"));
//			    if(value.equals(option.getAttribute("Value"))){
//			    	option.click();   
//			    	break;
//			    }
//			        
//			}
//		}catch(Exception e){}
//	}
	
	public static void clickLink(String locatorVariable){
		try{		
			WebDriver driver = webDriverClass.driver;
		    WebElement element = driver.findElement(By.xpath(locatorVariable));
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorVariable)));
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", element);
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static String getText(String locatorVariable){
		try{
			WebDriver driver = webDriverClass.driver;
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorVariable)));
		
		    WebElement element = driver.findElement(By.xpath(locatorVariable));
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    return executor.executeScript("return document.documentElement.innerText;", element).toString();	
		}catch(Exception e){
			return "";
		}
		
		
	}
	
	public static String[] readDataFromWebTable(String locatorVariable){
		try{
			
		
		String[] tableValue = null;		
		 WebDriver driver = webDriverClass.driver;
		 List<WebElement> PopupTable = driver.findElements(By.xpath(locatorVariable));		 
		 for(int i =0;i<PopupTable.size();i++){			  
			  List<WebElement> popupRow =  PopupTable.get(i).findElements(By.tagName("tr"));
			  tableValue = new String[popupRow.size()];
			  for(int j=0;j<popupRow.size();j++){
				  List<WebElement> propertyColumn = popupRow.get(j).findElements(By.tagName("td"));
				  String valueTable = "";
				  for(int k=0;k<propertyColumn.size();k++){
					  valueTable = valueTable+"|"+propertyColumn.get(k).getText();
				  }
				  tableValue[j] = valueTable;
				  if(j!=0 && tableValue[j].equals("")){
					  break;
				  }
			  }
			  break;
		  }
		 return tableValue;	
		}catch(Exception e){return null;}
	}

	public static String readDataFromWebTable(String columnName, String xpathVal){
		// "//*[@id='lvRating_itemPlaceholderContainer']//tr"
		 WebDriver driver = webDriverClass.driver;
		 List <WebElement> dataVal = driver.findElements(By.xpath(xpathVal));
		 String returnVal = ""; 
		  for(int i=1;i<=dataVal.size();i++){
			  List <WebElement> tdVal = dataVal.get(i).findElements(By.tagName("td"));
		  	  if(tdVal.get(0).getText().equalsIgnoreCase(columnName)){
		  		returnVal =  tdVal.get(1).getText();
		  		break;
		  	  }
		  }
		  return returnVal;
	}
	
}
