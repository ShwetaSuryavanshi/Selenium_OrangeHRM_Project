package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcelData_PIM {
	
	@DataProvider(name="EmployeeDetailExcellData")
	public String[][] readexceldata(Method m) throws EncryptedDocumentException, IOException {
		String excelsheet=m.getName();
		File f= new File("D:\\Devops\\TestNG_Updated2\\OrangeHRM_Project\\src\\test\\resources\\Excel\\EmployeeDetails.xlsx");
	FileInputStream FI= new FileInputStream(f);
	Workbook wbk= WorkbookFactory.create(FI);
	Sheet s= wbk.getSheet(excelsheet);
	
	int totalrows=s.getLastRowNum();
	System.out.println("Excell totalRows"+ totalrows);
	
	Row rowcells = s.getRow(0);
	int totalcols= rowcells.getLastCellNum();
	System.out.println("Excell totalcolumns"+ totalcols);
	
	DataFormatter format= new DataFormatter();
	String testdata[][]= new String[totalrows][totalcols];
	
	for(int i=1;i<=totalrows; i++) {
		for(int j=0;j<totalcols;j++) {
			testdata[i-1][j]=format.formatCellValue(s.getRow(i).getCell(j));
		}
	}
	return testdata;
	}

}
