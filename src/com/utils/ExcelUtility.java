package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private static Workbook book;
	private static Sheet sheet;
	
	public static void openExcel(String filePath, String sheetName) { //this for opening and reach to excel file
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
		     book=new XSSFWorkbook(fis);
		  sheet=book.getSheet(sheetName);
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	public static int rowCount() { //to get numbers of excel file
	 return sheet.getPhysicalNumberOfRows();
	}
	
	public static int colCount() {  //to get cell or col number of the excel file
	return sheet.getRow(0).getLastCellNum();
	}
	
	public static String getCellData(int rowIndex, int colIndex) { //to get specific data/cell
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	public static Object[][] excelToArray(String filePath, String sheetName){
		openExcel(filePath,sheetName);
		
		Object[][] data=new Object[rowCount()-1][colCount()]; //basligi almamak icin -1 kullandik
		for (int i=1; i <rowCount(); i++) {  //eliminate header o yuzden 1 den basliyor
			for (int j =0; j <colCount(); j++) {
				data[i-1][j]=getCellData(i,j);
			}
		}
		return data;
	}
	

}
