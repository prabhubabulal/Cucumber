package automationTesting.haloAutomation.common.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.htrace.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;

public class writeDataExcel 
{
	public static void writeData(String playerID,int rowNumber, int columnNumber) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("src\\test\\resources\\data\\TableRating.xlsm");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Rating");
		Row row=sh.getRow(rowNumber);
		Cell cell=row.createCell(columnNumber);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(playerID);
		FileOutputStream fos=new FileOutputStream("src\\test\\resources\\data\\TableRating.xlsm");
		wb.write(fos);
		fos.close();
		System.out.println("Excel File Written.");
}
	
	
	public static void writeDataExcel(String playerID) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("Q:\\Documents and User manuals\\3. Testing\\Automation\\TestData\\AutomationTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("TestData");		
		Row row=sh.getRow(sh.getLastRowNum()+1);
		Cell cell=row.createCell(1);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(playerID);
		FileOutputStream fos=new FileOutputStream("Q:\\Documents and User manuals\\3. Testing\\Automation\\TestData\\AutomationTestData.xlsx");
		wb.write(fos);
		fos.close();
		System.out.println("Excel File Written.");
}


}
