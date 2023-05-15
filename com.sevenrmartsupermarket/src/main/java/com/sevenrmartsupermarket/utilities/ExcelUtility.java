package com.sevenrmartsupermarket.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream fileInputStream;
	XSSFWorkbook workBook;
	XSSFSheet sheet;

	public void getExcel() throws FileNotFoundException {
		String excelPath = System.getProperty("");
		fileInputStream = new FileInputStream(excelPath);
		workBook = new XSSFWorkbook();
		sheet = workBook.getSheet("Sheet 1");
	}
}
