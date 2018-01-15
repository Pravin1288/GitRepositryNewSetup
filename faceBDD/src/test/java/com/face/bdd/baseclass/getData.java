package com.face.bdd.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class getData {

	public static void readDatafromExcel() throws IOException {
		File file = new File("");
		String path = file.getAbsolutePath().toString();
		FileInputStream input = new FileInputStream(new File(path+"\\Data\\ExcelDatasheet.xlsx"));
		HSSFWorkbook workbook = new HSSFWorkbook(input);
		Sheet sheet = workbook.getSheetAt(0);
		for(int i=0 ;i<sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				Cell cell = row.getCell(j);
				/*switch (ce) {
				case value:
					
					break;

				default:
					break;
				}
*/			}
		}
		
	}
}
