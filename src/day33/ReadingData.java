package day33;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("/Users/milanpatel9509gmail.com/Downloads/data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int totalRows=sheet.getLastRowNum();
		int totalCells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("total rows:"+totalRows);
		System.out.println("total rows:"+totalCells);
		
			for(int r=0;r<=totalRows;r++)
			{
				XSSFRow row=sheet.getRow(r);
				
				for(int c=0;c<totalCells;c++) 
				{
					XSSFCell cell=row.getCell(c);
					System.out.print(cell.toString()+"    ");
				}
				System.out.println();
			}
			workbook.close();
			file.close();
		}

}
