package utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static String[][] readExcelForCarWashing() throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\ExcelData\\inputExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int row_cnt = sheet.getLastRowNum();
		int cell_cnt = sheet.getRow(0).getLastCellNum();
		String[][] data1 = new String[row_cnt][cell_cnt];
		DataFormatter df = new DataFormatter();
		
		for(int r=1; r<=row_cnt; r++) {
			XSSFRow row = sheet.getRow(r);
			for(int c=0; c<cell_cnt; c++) {
				XSSFCell cell = row.getCell(c);
				data1[r-1][c] =  df.formatCellValue(cell);
			}
		}
		workbook.close();
		file.close();
		return data1;
	}
	
	public static String[][] readExcelForFreeListing() throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\ExcelData\\inputExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		
		int row_cnt = sheet.getLastRowNum();
		int cell_cnt = sheet.getRow(0).getLastCellNum();
		String[][] data2 = new String[row_cnt][cell_cnt];
		DataFormatter df = new DataFormatter();
		
		for(int r=1; r<=row_cnt; r++) {
			XSSFRow row = sheet.getRow(r);
			for(int c=0; c<cell_cnt; c++) {
				XSSFCell cell = row.getCell(c);
				data2[r-1][c] =  df.formatCellValue(cell);
			}
		}
		workbook.close();
		file.close();
		return data2;
	}
	
	
	//Will do it later
	public static void writeExcel(List<String> carWashsingServices, List<String> phoneNumbers, List<String> customersRating, List<String> customersVotes, String errorMessageText, List<String> gymSubMenu) throws IOException {
		
//		FileOutputStream file=new FileOutputStream("C:\\Users\\2407425\\eclipse-workspace\\zzHackthon_Project\\ExcelData\\outPutExcel.xlsx");
//		XSSFWorkbook workbook=new XSSFWorkbook();
//		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
//		XSSFRow row1=sheet.createRow(2);
//		row1.createCell(0).setCellValue("Top 5 Car Washing Services In Chennai");
//		for(int i=1;i<6;i++) {
//			XSSFRow row=sheet.createRow(i);
//			row.createCell(0).setCellValue(carWashsingServices.get(i-1));
//			row.createCell(1).setCellValue(phoneNumbers.get(i-1));
//			row.createCell(2).setCellValue(customersRating.get(i-1));
//			row.createCell(3).setCellValue(customersVotes.get(i-1));
//		}
//		
//		XSSFRow row2=sheet.createRow(7);
//		row2.createCell(0).setCellValue("Error Message While Entering Wrong Number");
//		row2.createCell(1).setCellValue(errorMessageText);
//		
//		XSSFRow row3=sheet.createRow(9);
//		row3.createCell(0).setCellValue("Submenu of Gym Menu");
//		
//		for(int i=10;i<gymSubMenu.size()+10;i++) {
//			XSSFRow row=sheet.createRow(i);
//			row.createCell(0).setCellValue(gymSubMenu.get(i-10));
//		}
		
//		workbook.write(file);
//		workbook.close();
//		file.close();
	}
	
	
}
