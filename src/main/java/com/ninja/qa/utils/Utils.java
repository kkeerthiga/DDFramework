package com.ninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Utils {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 10;
	
	public static String generateEmailWithTimeStamp() {
			Date date=new Date();
			String timestamp=date.toString().replace(" ","_").replace(":", "_");
			return "test"+timestamp+"gmail.com";
			
		}
	
	public static Object[][] getTestDataFromExcel(String sheetname) {
		
	File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ninja\\qa\\testdata\\Ninja_Testdata.xlsx");
	XSSFWorkbook workbook = null;
	try {
		FileInputStream fis = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fis);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	XSSFSheet sheet = workbook.getSheet(sheetname);
	
	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[rows][cols];
	
	for( int i = 0; i < rows; i++) {
		 
		XSSFRow row = sheet.getRow(i+1);
		
		for(int j = 0; j < cols; j++) {
			
			XSSFCell cell = row.getCell(j);
		    org.apache.poi.ss.usermodel.CellType cellType = cell.getCellType();
			
			switch(cellType) {
			
			case STRING:
				data[i][j] = cell.getStringCellValue();
				break;
			case NUMERIC:
				data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
			case BOOLEAN:
				data[i][j] = cell.getBooleanCellValue();
				break;
				}
		}
		
	}
	return data;
	
	}
}

