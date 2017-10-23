package automationTesting.haloAutomation.common.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class readDataFromExcel {
public Map<String, Object[]> readTestData(String file, String testdatasheet, String testcase)throws Exception
{
	Map<String, Object[]> map = new HashMap<String, Object[]>();
	String fileName ="";
	String tempStr  = null;
	String quoteColumns = "";

	FileInputStream ioFileName = new FileInputStream(new File("src\\test\\java\\data\\TestData.xlsx"));

    XSSFWorkbook workbook = new XSSFWorkbook(ioFileName);

      //Get first/desired sheet from the workbook
    XSSFSheet sh = workbook.getSheet(testdatasheet);
      
	Iterator<Row> rowIterator = sh.iterator();
	Iterator<Row> tempIterator;
	Row header_row,row;

	header_row = rowIterator.next();

	String[]   testDataKeysArray = new String[header_row.getLastCellNum()];
	int columnCnt = header_row.getLastCellNum()-1;
	System.out.println("Num of Columns in the testdata :"+ columnCnt);
	for(int c =0;c < columnCnt;c++)
		testDataKeysArray[c] = header_row.getCell(c).getStringCellValue();

	int numOfRows =0;
	int testcaseEndRow =0;
	while(rowIterator.hasNext()){
		row = rowIterator.next();
		if(row.getCell(0).getStringCellValue().compareTo(testcase)==0)
		{
			numOfRows ++;
			testcaseEndRow=row.getRowNum();
		}
	}
	int testcaseStartRow = testcaseEndRow+1 - numOfRows;
	System.out.println("Num of Columns in the testdata :"+ columnCnt +" and Num of Rows in the testcase "+ testcase +"  are :"+ numOfRows +"  Start Row : "+ testcaseStartRow +"  and testcase End Row :"+ testcaseEndRow);


	int k = 0;
	for(int c =0;c < columnCnt;c++)
	{
		Object[] temp = new Object[numOfRows];
		int indx = 0;
		tempIterator = sh.iterator();
		for(int i=0;i<testcaseStartRow;i++)
			tempIterator.next();
		for(int r=testcaseStartRow;r<=testcaseEndRow;r++){
			row = tempIterator.next();
			switch(row.getCell(c, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getCellType())
			{
			case 0:
				Double dbl = row.getCell(c).getNumericCellValue();

				temp[indx] = dbl.toString();
				break;
			case 1:
				temp[indx] = new String(row.getCell(c).getStringCellValue());
				break;
			case 3:
				temp[indx] = new String("");
				break;
			default:
				temp[indx] = new String("");
				break;
			}
			indx++;
		}
		map.put(testDataKeysArray[k].toString(), temp);
		temp = null;
		k++;
	}
	testDataKeysArray = null; 
	System.out.println("Reading TestData for "+ testcase + " completed ");
	return map;
}

public String getValuefromMap(Map<String, Object[]> map, String value, int location){
	String retunVal = "";
	for (String key: map.keySet()) {	
		if(key.equalsIgnoreCase(value)){
			Object[] v = map.get(key);			
		    retunVal = v[location].toString();	
		}			    
	}
	return retunVal;
}

public int getValuefromMap(Map<String, Object[]> map, String value){
	int retunVal = 0;
	for (String key: map.keySet()) {	
		if(key.equalsIgnoreCase(value)){
			Object[] v = map.get(key);			
		    retunVal = v.length;	
		}			    
	}
	return retunVal;
}

}
