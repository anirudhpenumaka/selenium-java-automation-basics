package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reading_Excel {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream("C:\\Java Workspace\\Selenium_Basics\\ecommerce_test_data_Automation_Practise.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Products");

        int total_rows = sheet.getLastRowNum();
        System.out.println("Total Rows: " + total_rows);

        int total_cells = sheet.getRow(1).getLastCellNum();
        System.out.println("Total Cells: " + total_cells);
        
        //for reading the data
        for(int r=0;r<=total_rows;r++)
        {
        	XSSFRow CurrentRow=sheet.getRow(r);
        	
        	for(int c=0;c<total_cells;c++)
        	{
        		XSSFCell cell=CurrentRow.getCell(c);
        		System.out.println(cell.toString());
        	}
        }
        
        workbook.close();
        file.close();
    }
}
