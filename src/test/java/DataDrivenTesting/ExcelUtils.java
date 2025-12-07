package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    // =====================================================================
    // 1. GET ROW COUNT
    // =====================================================================
    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        int rowcount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowcount;
    }

    // =====================================================================
    // 2. GET CELL COUNT
    // =====================================================================
    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        int cellcount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellcount;
    }

    // =====================================================================
    // 3. GET CELL DATA
    // =====================================================================
    public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(column);

        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }

        wb.close();
        fi.close();
        return data;
    }

    // =====================================================================
    // 4. SET CELL DATA
    // =====================================================================
    public static void setCellData(String xlfile, String xlsheet, int rownum, int column, String data) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        row = ws.getRow(rownum);
        if (row == null) ws.createRow(rownum);

        cell = row.createCell(column);
        cell.setCellValue(data);

        fo = new FileOutputStream(xlfile);
        wb.write(fo);

        wb.close();
        fi.close();
        fo.close();
    }

    // =====================================================================
    // 5. FILL GREEN COLOR (PASS)
    // =====================================================================
    public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int column) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(column);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        fo = new FileOutputStream(xlfile);
        wb.write(fo);

        wb.close();
        fi.close();
        fo.close();
    }

    // =====================================================================
    // 6. FILL RED COLOR (FAIL)
    // =====================================================================
    public static void fillRedColor(String xlfile, String xlsheet, int rownum, int column) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(column);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        fo = new FileOutputStream(xlfile);
        wb.write(fo);

        wb.close();
        fi.close();
        fo.close();
    }
}
