package day33;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingData {

	public static void main(String[] args) throws IOException {
	
		FileOutputStream file=new FileOutputStream("/Users/milanpatel9509gmail.com/Downloads/Data1.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Sheet1");
		
		Scanner sc=new Scanner(System.in);
		
			for(int r=0; r<3; r++)
			{
				XSSFRow row=sheet.createRow(r);
				for(int c=0;c<2;c++) 
				{
					System.out.println("enter value: ");
					row.createCell(c).setCellValue(sc.next());
				}
			}
			
		workbook.write(file);
		workbook.close();
		file.close();
		}
		

	}


