package com.face.bdd.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class getData {

	public static void main(String [] args) throws Exception {
		readDatafromExcel();
	}
	public static void readDatafromExcel() throws Exception {
		File file = new File("");
		String path = file.getAbsolutePath().toString();
		FileInputStream input = new FileInputStream(new File(path+"\\Data\\ExcelDatasheet.xlsx"));
		HSSFWorkbook workbook = new HSSFWorkbook(input);
		Sheet sheet = workbook.getSheetAt(0);
		for(int i=0 ;i<sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				Cell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				default:
					System.out.println("No data available");
					break;
				}
			}
		}
		input.close();
	}
}
