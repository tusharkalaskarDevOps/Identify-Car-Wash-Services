package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelUtils {
	


	public static FileInputStream file1; // mi ahe sub branch madheeeeeee
	public static XSSFWorkbook workbook1;
	
	public static String[][] readExcelForCarWashing(){
		try {
			file1 = new FileInputStream(System.getProperty("user.dir")+"\\ExcelData\\inputExcel.xlsx");
			workbook1=new XSSFWorkbook(file1);
	 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet=workbook1.getSheet("Sheet1");
		
		int row_cnt = sheet.getLastRowNum();
		int cell_cnt = sheet.getRow(0).getLastCellNum();
		String[][] data1 = new String[row_cnt][cell_cnt];
		DataFormatter df = new DataFormatter();
		//make changes here for getting more dataset
		for(int r=1; r<=row_cnt; r++) {
			XSSFRow row = sheet.getRow(r);
			for(int c=0; c<cell_cnt; c++) {
				XSSFCell cell = row.getCell(c);
				data1[r-1][c] =  df.formatCellValue(cell);
			}
		}
		try {
			workbook1.close();
			file1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data1;
	}
	
	public static String[][] readExcelForFreeListing() throws IOException {
		
		XSSFSheet sheet1=workbook1.getSheet("Sheet2");
		
		int row_cnt = sheet1.getLastRowNum();
		int cell_cnt = sheet1.getRow(0).getLastCellNum();
		String[][] data2 = new String[row_cnt][cell_cnt];
		DataFormatter df = new DataFormatter();
		
		for(int r=1; r<=row_cnt; r++) {
			XSSFRow row = sheet1.getRow(r);
			for(int c=0; c<cell_cnt; c++) {
				XSSFCell cell = row.getCell(c);
				data2[r-1][c] =  df.formatCellValue(cell);
			}
		}
		workbook1.close();
		file1.close();
		return data2;
	}
	
	
	//Will do it later
	public static XSSFWorkbook workbook2 = new XSSFWorkbook();
	public static void write_car_washing_data(List<String> carWashsingServices, List<String>phoneNumbers , List<String>customersRating , List<String>customersVotes ) {
		
		XSSFSheet sheet2 = null;
		FileOutputStream file2 = null;
		try {
			file2=new FileOutputStream(System.getProperty("user.dir")+"\\ExcelData\\outPutExcel.xlsx");
			sheet2=workbook2.createSheet("ResultData1");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Creating header of the excel sheet
        XSSFRow header = sheet2.createRow(0);
        // Creating cell and setting the cell value
        header.createCell(0).setCellValue("Service Name");
        header.createCell(1).setCellValue("Mobile Number");
        header.createCell(2).setCellValue("Rating");
        header.createCell(3).setCellValue("Voting");
		
		for(int i=1;i<6;i++) {
			XSSFRow row=sheet2.createRow(i);
			row.createCell(0).setCellValue(carWashsingServices.get(i-1));
			row.createCell(1).setCellValue(phoneNumbers.get(i-1));
			row.createCell(2).setCellValue(customersRating.get(i-1));
			row.createCell(3).setCellValue(customersVotes.get(i-1));
		}
		
		try {
			workbook2.write(file2);
//			workbook2.close();
			file2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write_error_message_ofFreeListing(String errorMsg) {
		
		XSSFSheet sheet2 = null;
		FileOutputStream file2 = null;
		try {
			file2=new FileOutputStream(System.getProperty("user.dir")+"\\ExcelData\\outPutExcel.xlsx");
			sheet2=workbook2.createSheet("ResultData2");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Creating header of the excel sheet
        XSSFRow header = sheet2.createRow(0);
        // Creating cell and setting the cell value
        header.createCell(0).setCellValue("Error Message");
        
        XSSFRow row_msg = sheet2.createRow(1);
        row_msg.createCell(0).setCellValue(errorMsg);
        
		try {
			workbook2.write(file2);
//			workbook2.close();
			file2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void write_subMenu_data(List<WebElement> subMenu) {
		

		XSSFSheet sheet2 = null;
		FileOutputStream file2 = null;
		try {
			file2=new FileOutputStream(System.getProperty("user.dir")+"\\ExcelData\\outPutExcel.xlsx");
			sheet2=workbook2.createSheet("ResultData3");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Creating header of the excel sheet
        XSSFRow header = sheet2.createRow(0);
        // Creating cell and setting the cell value
        header.createCell(0).setCellValue("Gym SubMenus");
        
        for(int i=1;i<=subMenu.size();i++) {
			XSSFRow row=sheet2.createRow(i);
			row.createCell(0).setCellValue(subMenu.get(i-1).getText());
		}
        
		try {
			workbook2.write(file2);
			workbook2.close();
			file2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
