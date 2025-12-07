package DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writing_Excel 
{

	public static void main(String[] args) throws IOException 
	{
		
		 FileOutputStream file = new FileOutputStream("C:\\Java Workspace\\Selenium_Basics\\myfile.xlsx");

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Data");
	        
	        XSSFRow Row01=sheet.createRow(0);
	        Row01.createCell(0).setCellValue("Java");
	        Row01.createCell(1).setCellValue("123456");
	        Row01.createCell(2).setCellValue("Automation");
	        Row01.createCell(3).setCellValue("In progress");
	        	
	        XSSFRow Row02=sheet.createRow(1);
	        Row02.createCell(0).setCellValue("C#");
	        Row02.createCell(1).setCellValue("7532159");
	        Row02.createCell(2).setCellValue("API");
	        Row02.createCell(3).setCellValue("to be started");	
	        	
	        workbook.write(file);
	        System.out.println("File created");
	        workbook.close();
	        file.close();
	  
	     }

}
