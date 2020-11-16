package com.cumframework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void writexls(String filePath, String sheetName, String str, int r1, int c1) throws Exception {

		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		// 'Write data to excel'
		Row row = sheet.getRow(r1);
		row.createCell(c1).setCellValue(str);
		row.getCell(0);

		file.close();
		FileOutputStream outFile = new FileOutputStream(new File(filePath));
		workbook.write(outFile);
		outFile.close();
		workbook.close();

		
		
	}
	
	

}
